package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListTopicDescription;

public interface TopicDescriptionsApiService {

    ResultListTopicDescription getDidacticUnits(String searchText);
}
