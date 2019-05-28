package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit;

import java.util.List;

public interface DidacticUnitRepository {

    void add(DidacticUnit didacticUnit);

    List<DidacticUnit> findByGroup(String groupId);

    List<DidacticUnit> findByTopic(String topicId);
}
