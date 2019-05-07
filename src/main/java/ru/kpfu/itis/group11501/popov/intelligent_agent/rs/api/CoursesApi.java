/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListCourse;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopic;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-07T14:49:56.665+03:00[Europe/Moscow]")

@Validated
@Api(value = "courses", description = "the courses API")
public interface CoursesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "getAllCourses", notes = "Получить все курсы с подходящим названием", response = ResultListCourse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Курсы успешно получены", response = ResultListCourse.class) })
    @RequestMapping(value = "/courses",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ResultListCourse> getAllCourses(@ApiParam(value = "Текст, который должен содержаться в названии курса") @Valid @RequestParam(value = "searchText", required = false) String searchText) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"items\" : [ {    \"name\" : \"Философия\",    \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"  }, {    \"name\" : \"Философия\",    \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"  } ]}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getAllTopics", notes = "Получить все темы существующего курса", response = ResultListTopic.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Темы курса успешно получены", response = ResultListTopic.class) })
    @RequestMapping(value = "/courses/{course_uuid}/topics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ResultListTopic> getAllTopics(@ApiParam(value = "UUID курса",required=true) @PathVariable("course_uuid") UUID courseUuid) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"items\" : [ {    \"name\" : \"Тема 1. Философия в ряду других форм духовного освоения мира человеком\",    \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"  }, {    \"name\" : \"Тема 1. Философия в ряду других форм духовного освоения мира человеком\",    \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"  } ]}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
