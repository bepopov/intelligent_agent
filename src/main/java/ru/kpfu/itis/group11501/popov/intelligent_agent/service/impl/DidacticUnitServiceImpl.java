package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitGroupRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.DidacticUnitService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DidacticUnitServiceImpl implements DidacticUnitService {

    private DidacticUnitRepository didacticUnitRepository;
    private DidacticUnitGroupRepository didacticUnitGroupRepository;
    private TermService termService;

    public DidacticUnitServiceImpl(DidacticUnitRepository didacticUnitRepository,
                                   DidacticUnitGroupRepository didacticUnitGroupRepository,
                                   TermService termService) {
        this.didacticUnitRepository = didacticUnitRepository;
        this.didacticUnitGroupRepository = didacticUnitGroupRepository;
        this.termService = termService;
    }

    @Override
    public void add(List<DidacticUnitGroup> didacticUnitGroups) {
        didacticUnitGroups.stream().peek(this::createNewDidacticUnit).close();
    }

    @Override
    public void add(DidacticUnitGroup didacticUnitGroup) {
        createNewDidacticUnit(didacticUnitGroup);
    }

    @Override
    public void add(DidacticUnit didacticUnit) {
        didacticUnit.setId(UUID.randomUUID().toString());
        didacticUnitRepository.add(didacticUnit);
    }

    @Override
    public List<DidacticUnitGroup> getNext(String id) {
        List<DidacticUnitGroup> groups = didacticUnitGroupRepository.findNext(id);
        groups = groups.stream().peek(g -> {
            List<DidacticUnit> units = didacticUnitRepository.findByGroup(g.getId());
            g.setDidacticUnits(units);
        }).collect(Collectors.toList());
        return groups;
    }

    @Override
    public List<DidacticUnit> getByTopic(String topicId) {
        return didacticUnitRepository.findByTopic(topicId);
    }

    private void createNewDidacticUnit(DidacticUnitGroup didacticUnitGroup) {
        didacticUnitGroup.setId(UUID.randomUUID().toString());
        didacticUnitGroupRepository.add(didacticUnitGroup);
        List<DidacticUnit> didacticUnits = didacticUnitGroup.getDidacticUnits();
        String text = didacticUnits.stream()
                .map(du -> du.getName() + " ")
                .collect(Collectors.joining());
        termService.extractAndSaveTerms(text, didacticUnitGroup);
    }
}
