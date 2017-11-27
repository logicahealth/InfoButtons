package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CDSService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CDSServiceInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class CDSServiceInformation   {
  @JsonProperty("services")
  private List<CDSService> services = null;

  public CDSServiceInformation services(List<CDSService> services) {
    this.services = services;
    return this;
  }

  public CDSServiceInformation addServicesItem(CDSService servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<CDSService>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CDSService> getServices() {
    return services;
  }

  public void setServices(List<CDSService> services) {
    this.services = services;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CDSServiceInformation cdSServiceInformation = (CDSServiceInformation) o;
    return Objects.equals(this.services, cdSServiceInformation.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CDSServiceInformation {\n");
    
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

