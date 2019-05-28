package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnit;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Список дидактических единиц
 */
@ApiModel(description = "Список дидактических единиц")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T12:04:30.405+03:00[Europe/Moscow]")

public class ResultListDidacticUnit   {
  @JsonProperty("items")
  @Valid
  private List<DidacticUnit> items = null;

  public ResultListDidacticUnit items(List<DidacticUnit> items) {
    this.items = items;
    return this;
  }

  public ResultListDidacticUnit addItemsItem(DidacticUnit itemsItem) {
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

  public List<DidacticUnit> getItems() {
    return items;
  }

  public void setItems(List<DidacticUnit> items) {
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
    ResultListDidacticUnit resultListDidacticUnit = (ResultListDidacticUnit) o;
    return Objects.equals(this.items, resultListDidacticUnit.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultListDidacticUnit {\n");
    
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

