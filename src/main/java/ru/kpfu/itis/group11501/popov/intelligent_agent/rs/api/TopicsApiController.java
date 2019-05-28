package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.TopicsApiService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T16:59:09.247+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.intelligentAgent.base-path:}")
public class TopicsApiController implements TopicsApi {

    private final NativeWebRequest request;
    @Autowired
    private TopicsApiService apiService;

    @org.springframework.beans.factory.annotation.Autowired
    public TopicsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<DidacticUnit> createDidacticUnitForTopic(UUID topicUuid, @Valid DidacticUnit didacticUnit) {
        return ResponseEntity.ok().body(apiService.createDidacticUnitForTopic(topicUuid, didacticUnit));
    }

    @Override
    public ResponseEntity<Topic> createTopic(@Valid Topic topic) {
        return ResponseEntity.ok().body(apiService.createTopic(topic));
    }

    @Override
    public ResponseEntity<DidacticUnitGroup> getDidacticUnits(UUID topicUuid) {
        return ResponseEntity.ok().body(apiService.getDidacticUnits(topicUuid));
    }

    @Override
    public ResponseEntity<ResultListTopic> getNextTopics(UUID topicUuid) {
        return ResponseEntity.ok().body(apiService.getNextTopics(topicUuid));
    }

    @Override
    public ResponseEntity<ResultListTopic> getTopics(@Valid String searchText) {
        return ResponseEntity.ok().body(apiService.getTopics(searchText));
    }
}
