package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListDidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopic;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateCourse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T16:59:09.247+03:00[Europe/Moscow]")

public class CreateCourse   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("educationPlan")
  private UUID educationPlan;

  @JsonProperty("topics")
  private ResultListTopic topics = null;

  @JsonProperty("didacticUnits")
  private ResultListDidacticUnit didacticUnits = null;

  public CreateCourse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название дисциплины
   * @return name
  */
  @ApiModelProperty(example = "Философия", value = "Название дисциплины")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateCourse educationPlan(UUID educationPlan) {
    this.educationPlan = educationPlan;
    return this;
  }

  /**
   * id учебного плана
   * @return educationPlan
  */
  @ApiModelProperty(example = "4daa9121-a1cb-416c-840a-7d793e12101f", value = "id учебного плана")

  @Valid

  public UUID getEducationPlan() {
    return educationPlan;
  }

  public void setEducationPlan(UUID educationPlan) {
    this.educationPlan = educationPlan;
  }

  public CreateCourse topics(ResultListTopic topics) {
    this.topics = topics;
    return this;
  }

  /**
   * Get topics
   * @return topics
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResultListTopic getTopics() {
    return topics;
  }

  public void setTopics(ResultListTopic topics) {
    this.topics = topics;
  }

  public CreateCourse didacticUnits(ResultListDidacticUnit didacticUnits) {
    this.didacticUnits = didacticUnits;
    return this;
  }

  /**
   * Get didacticUnits
   * @return didacticUnits
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResultListDidacticUnit getDidacticUnits() {
    return didacticUnits;
  }

  public void setDidacticUnits(ResultListDidacticUnit didacticUnits) {
    this.didacticUnits = didacticUnits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCourse createCourse = (CreateCourse) o;
    return Objects.equals(this.name, createCourse.name) &&
        Objects.equals(this.educationPlan, createCourse.educationPlan) &&
        Objects.equals(this.topics, createCourse.topics) &&
        Objects.equals(this.didacticUnits, createCourse.didacticUnits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, educationPlan, topics, didacticUnits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCourse {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    educationPlan: ").append(toIndentedString(educationPlan)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
    sb.append("    didacticUnits: ").append(toIndentedString(didacticUnits)).append("\n");
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

