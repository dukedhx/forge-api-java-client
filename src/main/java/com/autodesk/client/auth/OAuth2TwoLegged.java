/**
 * Forge SDK
 * The Forge Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. From visualizing data to 3D printing, take advantage of Autodesk’s expertise in design and engineering.
 *
 * OpenAPI spec version: 0.1.0
 * Contact: forge.help@autodesk.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.autodesk.client.auth;
import com.autodesk.client.Configuration;
import com.autodesk.client.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;


public class OAuth2TwoLegged implements Authentication {

    private Credentials credentials;
    private String name;
    private String type;
    private OAuthFlow flow;
    private String tokenUrl;
    private String redirectUri;
    private List<String> scopes;
    private List<String> selectedScopes;
    private String clientId;
    private String clientSecret;

    // makes a POST request to url with form parameters and returns body as a string
    private String post(String url, Map<String,String> formParameters,Map<String,String> headers) throws ClientProtocolException, IOException {
        HttpPost request = new HttpPost(url);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        for(String key: headers.keySet()){
            request.setHeader(key, headers.get(key));
        }

        for (String key : formParameters.keySet()) {
            nvps.add(new BasicNameValuePair(key, formParameters.get(key)));
        }

        request.setEntity(new UrlEncodedFormEntity(nvps));

        return execute(request);
    }

    // makes request and checks response code for 200
    private String execute(HttpRequestBase request) throws ClientProtocolException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Expected 200 but got " + response.getStatusLine().getStatusCode() + ", with body " + body);
        }

        return body;
    }

    private String getScopes(){
        String scopeStr = "";
        if(!selectedScopes.isEmpty()){
            int index = 0;
            for (String key : selectedScopes) {
                index++;
                if (scopes.contains(key)) {
                    scopeStr += key;
                    if(index < selectedScopes.size()) scopeStr += " ";
                }
            }
        }
        return scopeStr;
    }


    public OAuth2TwoLegged(String clientId, String clientSecret, List<String> selectedScopes){
        this.flow = OAuthFlow.application;
        this.scopes = new ArrayList<String>();
        this.redirectUri = redirectUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.selectedScopes = selectedScopes;
    
        this.name = "oauth2_application";
        this.type = "oauth2";
        this.tokenUrl = Configuration.getDefaultApiClient().getBasePath() + "/authentication/v1/authenticate";
        this.scopes.add("data:read");
        this.scopes.add("data:write");
        this.scopes.add("data:create");
        this.scopes.add("data:search");
        this.scopes.add("bucket:create");
        this.scopes.add("bucket:read");
        this.scopes.add("bucket:update");
        this.scopes.add("bucket:delete");
        this.scopes.add("code:all");
        this.scopes.add("account:read");
        this.scopes.add("account:write");
        this.scopes.add("user-profile:read");

    
      if(this.selectedScopes == null) this.selectedScopes = this.scopes;
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
        if (this.credentials != null && this.credentials.getAccessToken() != null) {
            headerParams.put("Authorization", "Bearer " + this.credentials.getAccessToken());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setSelectedScopes(List<String> selectedScopes){
        this.selectedScopes = selectedScopes;
    }

    public String getAccessToken() {
        if (this.credentials != null) {
            return this.credentials.getAccessToken();
        }
        else{
            return null;
        }
    }

    public Long getAccessTokenExpirationTime() {
        if (this.credentials != null) {
            return this.credentials.getExpiresAt();
        }
        else{
            return Long.parseLong("0");
        }
    }

    /**
     * Get the access token in a 2-legged flow
     * @return
     */
    public Credentials authorize() throws Exception{

        if(flow == OAuthFlow.application) {

            final String url = this.tokenUrl;

            Map<String, String> body = new HashMap<>();
            body.put("grant_type", "client_credentials");
            body.put("client_id", this.clientId);
            body.put("client_secret", this.clientSecret);

            String scopeStr = getScopes();
            if(!scopeStr.isEmpty()) {
                body.put("scope", scopeStr);
            }

            Credentials response = null;
            try {
                String bodyResponse = post(url, body, new HashMap<String, String>());
                JSONObject jsonObject = null;

                // get the access token from json
                try {
                    jsonObject = (JSONObject) new JSONParser().parse(bodyResponse);
                    System.out.println("Response from forge:" + jsonObject.toJSONString());

                    String access_token = (String) jsonObject.get("access_token");
                    Long expires_in = (Long) jsonObject.get("expires_in");
                    Long expiresAt = new Date().getTime() + expires_in * 1000;
                    this.credentials = new Credentials(access_token, expiresAt);
                    response = new Credentials(access_token, expiresAt);

                } catch (ParseException e) {
                    throw new RuntimeException("Unable to parse json " + body);
                }
            } catch (IOException e) {
                System.err.println("Exception when trying to get token");
                e.printStackTrace();
            }
            return response;
        }
        else{
            throw new Exception("authorize requires application flow type");
        }
    }

    public Boolean isAuthorized(){
         return (this.credentials != null) && !!(this.credentials.getExpiresAt() != null && (this.credentials.getExpiresAt() > (new Date().getTime())));
    }
}
