package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.Course;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Список курсов
 */
@ApiModel(description = "Список курсов")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-30T10:32:20.922+03:00[Europe/Moscow]")

public class ResultListCourse   {
  @JsonProperty("items")
  @Valid
  private List<Course> items = null;

  public ResultListCourse items(List<Course> items) {
    this.items = items;
    return this;
  }

  public ResultListCourse addItemsItem(Course itemsItem) {
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

  public List<Course> getItems() {
    return items;
  }

  public void setItems(List<Course> items) {
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
    ResultListCourse resultListCourse = (ResultListCourse) o;
    return Objects.equals(this.items, resultListCourse.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultListCourse {\n");
    
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

