package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListDidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.DidacticUnitsApiService;

import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T16:59:09.247+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.intelligentAgent.base-path:}")
public class DidacticUnitsApiController implements DidacticUnitsApi {

    private final NativeWebRequest request;
    @Autowired
    private DidacticUnitsApiService apiService;

    @org.springframework.beans.factory.annotation.Autowired
    public DidacticUnitsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResultListDidacticUnit> getDidacticUnits(@Valid String searchText) {
        ResultListDidacticUnit result = apiService.getDidacticUnits(searchText);
        return ResponseEntity.ok().body(result);
    }
}
