package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticalUnit;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResultListDidacticalUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-07T14:49:56.665+03:00[Europe/Moscow]")

public class ResultListDidacticalUnit   {
  @JsonProperty("items")
  @Valid
  private List<DidacticalUnit> items = null;

  public ResultListDidacticalUnit items(List<DidacticalUnit> items) {
    this.items = items;
    return this;
  }

  public ResultListDidacticalUnit addItemsItem(DidacticalUnit itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<DidacticalUnit> getItems() {
    return items;
  }

  public void setItems(List<DidacticalUnit> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultListDidacticalUnit resultListDidacticalUnit = (ResultListDidacticalUnit) o;
    return Objects.equals(this.items, resultListDidacticalUnit.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultListDidacticalUnit {\n");
    
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

