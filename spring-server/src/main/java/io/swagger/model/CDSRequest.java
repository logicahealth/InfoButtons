package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Hook;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CDSRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class CDSRequest   {
  @JsonProperty("hook")
  private Hook hook = null;

  @JsonProperty("hookInstance")
  private UUID hookInstance = null;

  @JsonProperty("fhirServer")
  private String fhirServer = null;

  @JsonProperty("oauth")
  private Object oauth = null;

  @JsonProperty("user")
  private String user = null;

  @JsonProperty("patient")
  private String patient = null;

  @JsonProperty("encounter")
  private String encounter = null;

  @JsonProperty("context")
  private Object context = null;

  @JsonProperty("prefetch")
  private Object prefetch = null;

  public CDSRequest hook(Hook hook) {
    this.hook = hook;
    return this;
  }

   /**
   * Get hook
   * @return hook
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Hook getHook() {
    return hook;
  }

  public void setHook(Hook hook) {
    this.hook = hook;
  }

  public CDSRequest hookInstance(UUID hookInstance) {
    this.hookInstance = hookInstance;
    return this;
  }

   /**
   * Get hookInstance
   * @return hookInstance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getHookInstance() {
    return hookInstance;
  }

  public void setHookInstance(UUID hookInstance) {
    this.hookInstance = hookInstance;
  }

  public CDSRequest fhirServer(String fhirServer) {
    this.fhirServer = fhirServer;
    return this;
  }

   /**
   * Get fhirServer
   * @return fhirServer
  **/
  @ApiModelProperty(value = "")


  public String getFhirServer() {
    return fhirServer;
  }

  public void setFhirServer(String fhirServer) {
    this.fhirServer = fhirServer;
  }

  public CDSRequest oauth(Object oauth) {
    this.oauth = oauth;
    return this;
  }

   /**
   * Get oauth
   * @return oauth
  **/
  @ApiModelProperty(value = "")


  public Object getOauth() {
    return oauth;
  }

  public void setOauth(Object oauth) {
    this.oauth = oauth;
  }

  public CDSRequest user(String user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public CDSRequest patient(String patient) {
    this.patient = patient;
    return this;
  }

   /**
   * Get patient
   * @return patient
  **/
  @ApiModelProperty(value = "")


  public String getPatient() {
    return patient;
  }

  public void setPatient(String patient) {
    this.patient = patient;
  }

  public CDSRequest encounter(String encounter) {
    this.encounter = encounter;
    return this;
  }

   /**
   * Get encounter
   * @return encounter
  **/
  @ApiModelProperty(value = "")


  public String getEncounter() {
    return encounter;
  }

  public void setEncounter(String encounter) {
    this.encounter = encounter;
  }

  public CDSRequest context(Object context) {
    this.context = context;
    return this;
  }

   /**
   * Get context
   * @return context
  **/
  @ApiModelProperty(value = "")


  public Object getContext() {
    return context;
  }

  public void setContext(Object context) {
    this.context = context;
  }

  public CDSRequest prefetch(Object prefetch) {
    this.prefetch = prefetch;
    return this;
  }

   /**
   * Get prefetch
   * @return prefetch
  **/
  @ApiModelProperty(value = "")


  public Object getPrefetch() {
    return prefetch;
  }

  public void setPrefetch(Object prefetch) {
    this.prefetch = prefetch;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CDSRequest cdSRequest = (CDSRequest) o;
    return Objects.equals(this.hook, cdSRequest.hook) &&
        Objects.equals(this.hookInstance, cdSRequest.hookInstance) &&
        Objects.equals(this.fhirServer, cdSRequest.fhirServer) &&
        Objects.equals(this.oauth, cdSRequest.oauth) &&
        Objects.equals(this.user, cdSRequest.user) &&
        Objects.equals(this.patient, cdSRequest.patient) &&
        Objects.equals(this.encounter, cdSRequest.encounter) &&
        Objects.equals(this.context, cdSRequest.context) &&
        Objects.equals(this.prefetch, cdSRequest.prefetch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hook, hookInstance, fhirServer, oauth, user, patient, encounter, context, prefetch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CDSRequest {\n");
    
    sb.append("    hook: ").append(toIndentedString(hook)).append("\n");
    sb.append("    hookInstance: ").append(toIndentedString(hookInstance)).append("\n");
    sb.append("    fhirServer: ").append(toIndentedString(fhirServer)).append("\n");
    sb.append("    oauth: ").append(toIndentedString(oauth)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    encounter: ").append(toIndentedString(encounter)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    prefetch: ").append(toIndentedString(prefetch)).append("\n");
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

