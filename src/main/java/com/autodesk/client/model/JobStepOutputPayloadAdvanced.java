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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * Advanced options for &#x60;step&#x60; type.
 */
@ApiModel(description = "Advanced options for `step` type.")

public class JobStepOutputPayloadAdvanced   {
  /**
   * A STEP file can be generated with the following Application Protocols: `203` for configuration controlled design, `214` for core data for automotive mechanical design processes, `242` for managed model based 3D engineering. By default, `214` will be exported. 
   */
  public enum ApplicationProtocolEnum {
    _203("203"),
    
    _214("214"),
    
    _242("242");

    private String value;

    ApplicationProtocolEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @JsonProperty("applicationProtocol")
  private ApplicationProtocolEnum applicationProtocol = ApplicationProtocolEnum._214;

  @JsonProperty("tolerance")
  private Float tolerance = 0.001f;

  public JobStepOutputPayloadAdvanced applicationProtocol(ApplicationProtocolEnum applicationProtocol) {
    this.applicationProtocol = applicationProtocol;
    return this;
  }

   /**
   * A STEP file can be generated with the following Application Protocols: `203` for configuration controlled design, `214` for core data for automotive mechanical design processes, `242` for managed model based 3D engineering. By default, `214` will be exported. 
   * @return applicationProtocol
  **/
  @ApiModelProperty(example = "null", value = "A STEP file can be generated with the following Application Protocols: `203` for configuration controlled design, `214` for core data for automotive mechanical design processes, `242` for managed model based 3D engineering. By default, `214` will be exported. ")
  public ApplicationProtocolEnum getApplicationProtocol() {
    return applicationProtocol;
  }

  public void setApplicationProtocol(ApplicationProtocolEnum applicationProtocol) {
    this.applicationProtocol = applicationProtocol;
  }

  public JobStepOutputPayloadAdvanced tolerance(Float tolerance) {
    this.tolerance = tolerance;
    return this;
  }

   /**
   * Possible values are between `0` and `1`. By default it is set at 0.001.
   * @return tolerance
  **/
  @ApiModelProperty(example = "null", value = "Possible values are between `0` and `1`. By default it is set at 0.001.")
  public Float getTolerance() {
    return tolerance;
  }

  public void setTolerance(Float tolerance) {
    this.tolerance = tolerance;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobStepOutputPayloadAdvanced jobStepOutputPayloadAdvanced = (JobStepOutputPayloadAdvanced) o;
    return Objects.equals(this.applicationProtocol, jobStepOutputPayloadAdvanced.applicationProtocol) &&
        Objects.equals(this.tolerance, jobStepOutputPayloadAdvanced.tolerance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationProtocol, tolerance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobStepOutputPayloadAdvanced {\n");

    sb.append("    applicationProtocol: ").append(toIndentedString(applicationProtocol)).append("\n");
    sb.append("    tolerance: ").append(toIndentedString(tolerance)).append("\n");
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

