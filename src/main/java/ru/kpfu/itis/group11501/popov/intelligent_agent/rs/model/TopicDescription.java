package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TopicDescription
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-30T10:32:20.922+03:00[Europe/Moscow]")

public class TopicDescription   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  public TopicDescription id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * URI описания темы = [URI онтологии]#td[UUID]
   * @return id
  */
  @ApiModelProperty(example = "4daa9121-a1cb-416c-840a-7d793e12101f", value = "URI описания темы = [URI онтологии]#td[UUID]")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public TopicDescription name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Описание темы
   * @return name
  */
  @ApiModelProperty(example = "Бла-бла-бла", value = "Описание темы")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopicDescription topicDescription = (TopicDescription) o;
    return Objects.equals(this.id, topicDescription.id) &&
        Objects.equals(this.name, topicDescription.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopicDescription {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

