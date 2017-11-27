package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Link;
import io.swagger.model.Source;
import io.swagger.model.Suggestion;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Card
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class Card   {
  @JsonProperty("summary")
  private String summary = null;

  @JsonProperty("detail")
  private String detail = null;

  /**
   * Gets or Sets indicator
   */
  public enum IndicatorEnum {
    INFO("info"),
    
    WARNING("warning"),
    
    HARD_STOP("hard-stop");

    private String value;

    IndicatorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IndicatorEnum fromValue(String text) {
      for (IndicatorEnum b : IndicatorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("indicator")
  private IndicatorEnum indicator = null;

  @JsonProperty("source")
  private Source source = null;

  @JsonProperty("suggestions")
  private List<Suggestion> suggestions = null;

  @JsonProperty("links")
  private List<Link> links = null;

  public Card summary(String summary) {
    this.summary = summary;
    return this;
  }

   /**
   * Get summary
   * @return summary
  **/
  @ApiModelProperty(value = "")


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Card detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Get detail
   * @return detail
  **/
  @ApiModelProperty(value = "")


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Card indicator(IndicatorEnum indicator) {
    this.indicator = indicator;
    return this;
  }

   /**
   * Get indicator
   * @return indicator
  **/
  @ApiModelProperty(value = "")


  public IndicatorEnum getIndicator() {
    return indicator;
  }

  public void setIndicator(IndicatorEnum indicator) {
    this.indicator = indicator;
  }

  public Card source(Source source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public Card suggestions(List<Suggestion> suggestions) {
    this.suggestions = suggestions;
    return this;
  }

  public Card addSuggestionsItem(Suggestion suggestionsItem) {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<Suggestion>();
    }
    this.suggestions.add(suggestionsItem);
    return this;
  }

   /**
   * Get suggestions
   * @return suggestions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Suggestion> getSuggestions() {
    return suggestions;
  }

  public void setSuggestions(List<Suggestion> suggestions) {
    this.suggestions = suggestions;
  }

  public Card links(List<Link> links) {
    this.links = links;
    return this;
  }

  public Card addLinksItem(Link linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<Link>();
    }
    this.links.add(linksItem);
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.summary, card.summary) &&
        Objects.equals(this.detail, card.detail) &&
        Objects.equals(this.indicator, card.indicator) &&
        Objects.equals(this.source, card.source) &&
        Objects.equals(this.suggestions, card.suggestions) &&
        Objects.equals(this.links, card.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary, detail, indicator, source, suggestions, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    indicator: ").append(toIndentedString(indicator)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    suggestions: ").append(toIndentedString(suggestions)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

