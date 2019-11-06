package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * EHR event that triggers an external decision support request
 */
public enum Hook {
  
  PATIENT_VIEW("patient-view"),
  
  ORDER_SELECT("order-select"),
  
  ORDER_REVIEW("order-review");

  private String value;

  Hook(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Hook fromValue(String text) {
    for (Hook b : Hook.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

