package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Suggestion
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class Suggestion   {
  @JsonProperty("label")
  private String label = null;

  @JsonProperty("uuid")
  private UUID uuid = null;

  @JsonProperty("actions")
  private List<Action> actions = null;

  public Suggestion label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Suggestion uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Suggestion actions(List<Action> actions) {
    this.actions = actions;
    return this;
  }

  public Suggestion addActionsItem(Action actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<Action>();
    }
    this.actions.add(actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Action> getActions() {
    return actions;
  }

  public void setActions(List<Action> actions) {
    this.actions = actions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Suggestion suggestion = (Suggestion) o;
    return Objects.equals(this.label, suggestion.label) &&
        Objects.equals(this.uuid, suggestion.uuid) &&
        Objects.equals(this.actions, suggestion.actions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, uuid, actions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Suggestion {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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

