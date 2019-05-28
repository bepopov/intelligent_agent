package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.*;

import java.util.UUID;

public interface TopicsApiService {

    DidacticUnit createDidacticUnitForTopic(UUID topicUuid, DidacticUnit didacticUnit);

    Topic createTopic(Topic topic);

    DidacticUnitGroup getDidacticUnits(UUID topicUuid);

    ResultListTopic getNextTopics(UUID topicUuid);

    ResultListTopic getTopics(String searchText);

}
