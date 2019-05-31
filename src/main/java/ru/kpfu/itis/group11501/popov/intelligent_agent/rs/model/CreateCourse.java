package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopicDescription;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateCourse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-30T10:32:20.922+03:00[Europe/Moscow]")

public class CreateCourse   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("educationPlan")
  private UUID educationPlan;

  @JsonProperty("topics")
  private ResultListTopic topics = null;

  @JsonProperty("topicDescriptions")
  private ResultListTopicDescription topicDescriptions = null;

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

  public CreateCourse topicDescriptions(ResultListTopicDescription topicDescriptions) {
    this.topicDescriptions = topicDescriptions;
    return this;
  }

  /**
   * Get topicDescriptions
   * @return topicDescriptions
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResultListTopicDescription getTopicDescriptions() {
    return topicDescriptions;
  }

  public void setTopicDescriptions(ResultListTopicDescription topicDescriptions) {
    this.topicDescriptions = topicDescriptions;
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
        Objects.equals(this.topicDescriptions, createCourse.topicDescriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, educationPlan, topics, topicDescriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCourse {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    educationPlan: ").append(toIndentedString(educationPlan)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
    sb.append("    topicDescriptions: ").append(toIndentedString(topicDescriptions)).append("\n");
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

