package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-30T10:32:20.922+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.intelligentAgent.base-path:}")
public class TopicDescriptionsApiController implements TopicDescriptionsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TopicDescriptionsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
