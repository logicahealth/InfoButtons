package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Card;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CDSResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

public class CDSResponse   {
  @JsonProperty("cards")
  private List<Card> cards = null;

  public CDSResponse cards(List<Card> cards) {
    this.cards = cards;
    return this;
  }

  public CDSResponse addCardsItem(Card cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<Card>();
    }
    this.cards.add(cardsItem);
    return this;
  }

   /**
   * Get cards
   * @return cards
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CDSResponse cdSResponse = (CDSResponse) o;
    return Objects.equals(this.cards, cdSResponse.cards);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CDSResponse {\n");
    
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
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

