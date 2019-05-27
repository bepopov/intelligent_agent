package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;

import java.util.List;

public interface DidacticUnitGroupRepository {

    void add(DidacticUnitGroup didacticUnitGroup);

    List<DidacticUnitGroup> findNext(String id);

}
