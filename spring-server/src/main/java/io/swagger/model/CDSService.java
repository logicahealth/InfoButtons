package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Hook;
import io.swagger.model.Prefetch;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CDSService
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class CDSService   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("hook")
  private Hook hook = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("prefetch")
  private Prefetch prefetch = null;

  public CDSService id(String id) {
    this.id = id;
    return this;
  }

   /**
   * short id for this service, unique with the CDS Provider (will be used in URL paths)
   * @return id
  **/
  @ApiModelProperty(value = "short id for this service, unique with the CDS Provider (will be used in URL paths)")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CDSService hook(Hook hook) {
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

  public CDSService title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Human-readable name for the CDS Service (e.g. \"CMS Drug Pricing Service\")
   * @return title
  **/
  @ApiModelProperty(value = "Human-readable name for the CDS Service (e.g. \"CMS Drug Pricing Service\")")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CDSService description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Longer-form description of what the service offers
   * @return description
  **/
  @ApiModelProperty(value = "Longer-form description of what the service offers")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CDSService prefetch(Prefetch prefetch) {
    this.prefetch = prefetch;
    return this;
  }

   /**
   * Get prefetch
   * @return prefetch
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Prefetch getPrefetch() {
    return prefetch;
  }

  public void setPrefetch(Prefetch prefetch) {
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
    CDSService cdSService = (CDSService) o;
    return Objects.equals(this.id, cdSService.id) &&
        Objects.equals(this.hook, cdSService.hook) &&
        Objects.equals(this.title, cdSService.title) &&
        Objects.equals(this.description, cdSService.description) &&
        Objects.equals(this.prefetch, cdSService.prefetch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hook, title, description, prefetch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CDSService {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hook: ").append(toIndentedString(hook)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

