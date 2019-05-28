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
 * DidacticUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T12:04:30.405+03:00[Europe/Moscow]")

public class DidacticUnit   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  public DidacticUnit id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * URI дидактической единицы = [URI онтологии]#didactical_unit[UUID]
   * @return id
  */
  @ApiModelProperty(example = "4daa9121-a1cb-416c-840a-7d793e12101f", value = "URI дидактической единицы = [URI онтологии]#didactical_unit[UUID]")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DidacticUnit name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название дидактической единицы
   * @return name
  */
  @ApiModelProperty(example = "Бла-бла-бла", value = "Название дидактической единицы")


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
    DidacticUnit didacticUnit = (DidacticUnit) o;
    return Objects.equals(this.id, didacticUnit.id) &&
        Objects.equals(this.name, didacticUnit.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DidacticUnit {\n");
    
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

