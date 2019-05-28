package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;

import java.util.List;

public interface DidacticUnitService {

    void add(List<DidacticUnitGroup> didacticUnitGroups);

    void add(DidacticUnitGroup didacticUnit);

    void add(DidacticUnit didacticUnit);

    List<DidacticUnitGroup> getNext(String id);

}
