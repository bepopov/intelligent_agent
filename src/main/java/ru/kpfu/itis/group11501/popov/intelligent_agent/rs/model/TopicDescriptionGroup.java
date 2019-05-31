package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopicDescription;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TopicDescriptionGroup
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-30T10:32:20.922+03:00[Europe/Moscow]")

public class TopicDescriptionGroup   {
  @JsonProperty("topicDescriptions")
  private ResultListTopicDescription topicDescriptions = null;

  public TopicDescriptionGroup topicDescriptions(ResultListTopicDescription topicDescriptions) {
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
    TopicDescriptionGroup topicDescriptionGroup = (TopicDescriptionGroup) o;
    return Objects.equals(this.topicDescriptions, topicDescriptionGroup.topicDescriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topicDescriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopicDescriptionGroup {\n");
    
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

