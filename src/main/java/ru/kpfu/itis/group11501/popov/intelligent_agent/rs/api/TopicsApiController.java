package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T12:04:30.405+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.intelligentAgent.base-path:}")
public class TopicsApiController implements TopicsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TopicsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
