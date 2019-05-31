package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.TopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.TopicDescriptionsApiService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TopicDescriptionsApiServiceImpl implements TopicDescriptionsApiService {

    private SearchService searchService;

    public TopicDescriptionsApiServiceImpl(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public ResultListTopicDescription getDidacticUnits(String searchText) {
        List<TopicDescription> didacticUnits = searchService
                .searchGrouped(searchText,
                        ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription.class,
                        TopicDescriptionGroup.class)
                .stream().map(doc -> {
                    TopicDescription didacticUnit = new TopicDescription();
                    didacticUnit.setName(doc.getContent());
                    didacticUnit.setId(UUID.fromString(doc.getId()));
                    return didacticUnit;
                }).collect(Collectors.toList());
        ResultListTopicDescription resultList = new ResultListTopicDescription();
        resultList.setItems(didacticUnits);
        return resultList;
    }
}
