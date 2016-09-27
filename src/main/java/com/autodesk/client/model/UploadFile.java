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


package com.autodesk.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * UploadFile
 */

public class UploadFile   {
  @JsonProperty("bucketKey")
  private String bucketKey = null;

  @JsonProperty("objectId")
  private String objectId = null;

  @JsonProperty("objectKey")
  private String objectKey = null;

  @JsonProperty("sha1")
  private String sha1 = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("location")
  private String location = null;

  public UploadFile bucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * The key of the Bucket
   * @return bucketKey
  **/
  @ApiModelProperty(example = "null", value = "The key of the Bucket")
  public String getBucketKey() {
    return bucketKey;
  }

  public void setBucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
  }

  public UploadFile objectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

   /**
   * The object id
   * @return objectId
  **/
  @ApiModelProperty(example = "null", value = "The object id")
  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public UploadFile objectKey(String objectKey) {
    this.objectKey = objectKey;
    return this;
  }

   /**
   * The key for uploaded object
   * @return objectKey
  **/
  @ApiModelProperty(example = "null", value = "The key for uploaded object")
  public String getObjectKey() {
    return objectKey;
  }

  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }

  public UploadFile sha1(String sha1) {
    this.sha1 = sha1;
    return this;
  }

   /**
   * The hash value for uploaded object (fingerprint)
   * @return sha1
  **/
  @ApiModelProperty(example = "null", value = "The hash value for uploaded object (fingerprint)")
  public String getSha1() {
    return sha1;
  }

  public void setSha1(String sha1) {
    this.sha1 = sha1;
  }

  public UploadFile size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * The size (bytes) of the uploaded object
   * @return size
  **/
  @ApiModelProperty(example = "null", value = "The size (bytes) of the uploaded object")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public UploadFile contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * The content-type of uploaded object
   * @return contentType
  **/
  @ApiModelProperty(example = "null", value = "The content-type of uploaded object")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public UploadFile location(String location) {
    this.location = location;
    return this;
  }

   /**
   * The location from which you can download the object (download URL)
   * @return location
  **/
  @ApiModelProperty(example = "null", value = "The location from which you can download the object (download URL)")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadFile uploadFile = (UploadFile) o;
    return Objects.equals(this.bucketKey, uploadFile.bucketKey) &&
        Objects.equals(this.objectId, uploadFile.objectId) &&
        Objects.equals(this.objectKey, uploadFile.objectKey) &&
        Objects.equals(this.sha1, uploadFile.sha1) &&
        Objects.equals(this.size, uploadFile.size) &&
        Objects.equals(this.contentType, uploadFile.contentType) &&
        Objects.equals(this.location, uploadFile.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, objectId, objectKey, sha1, size, contentType, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFile {\n");

    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

