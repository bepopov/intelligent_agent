/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.Topic;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T16:59:09.247+03:00[Europe/Moscow]")

@Validated
@Api(value = "topics", description = "the topics API")
public interface TopicsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "createDidacticUnitForTopic", notes = "Создать дидактическую единицу для темы", response = DidacticUnit.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Дидактическая единица успешно создана", response = DidacticUnit.class) })
    @RequestMapping(value = "/topics/{topic_uuid}/didactic_units",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<DidacticUnit> createDidacticUnitForTopic(@ApiParam(value = "UUID темы",required=true) @PathVariable("topic_uuid") UUID topicUuid,@ApiParam(value = ""  )  @Valid @RequestBody DidacticUnit didacticUnit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"name\" : \"Бла-бла-бла\",  \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "createTopic", notes = "Создать тему", response = Topic.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Тема успешно создана", response = Topic.class) })
    @RequestMapping(value = "/topics",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Topic> createTopic(@ApiParam(value = ""  )  @Valid @RequestBody Topic topic) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"name\" : \"Тема 1. Философия в ряду других форм духовного освоения мира человеком\",  \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getDidacticUnits", notes = "Получить все дидактические единицы выбранной темы", response = DidacticUnitGroup.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Дидактические единицы темы успешно получены", response = DidacticUnitGroup.class) })
    @RequestMapping(value = "/topics/{topic_uuid}/didactic_units",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<DidacticUnitGroup> getDidacticUnits(@ApiParam(value = "UUID темы",required=true) @PathVariable("topic_uuid") UUID topicUuid) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"didacticUnits\" : {    \"items\" : [ {      \"name\" : \"Бла-бла-бла\",      \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"    }, {      \"name\" : \"Бла-бла-бла\",      \"id\" : \"4daa9121-a1cb-416c-840a-7d793e12101f\"    } ]  }}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getNextTopics", notes = "Получить все темы, идущие после указанной", response = ResultListTopic.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Похожие темы успешно получены", response = ResultListTopic.class) })
    @RequestMapping(value = "/topics/{topic_uuid}/next",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ResultListTopic> getNextTopics(@ApiParam(value = "UUID темы",required=true) @PathVariable("topic_uuid") UUID topicUuid) {
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


    @ApiOperation(value = "", nickname = "getTopics", notes = "Получить все темы, похожие на введенную. Если текст не введен, вывести все темы", response = ResultListTopic.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Похожие темы успешно получены", response = ResultListTopic.class) })
    @RequestMapping(value = "/topics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ResultListTopic> getTopics(@ApiParam(value = "Название темы") @Valid @RequestParam(value = "searchText", required = false) String searchText) {
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
