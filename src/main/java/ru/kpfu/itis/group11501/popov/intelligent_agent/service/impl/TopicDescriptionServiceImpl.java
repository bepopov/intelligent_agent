package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicDescriptionGroupRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicDescriptionRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicDescriptionService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TopicDescriptionServiceImpl implements TopicDescriptionService {

    private TopicDescriptionRepository didacticUnitRepository;
    private TopicDescriptionGroupRepository didacticUnitGroupRepository;
    private TermService termService;

    public TopicDescriptionServiceImpl(TopicDescriptionRepository didacticUnitRepository,
                                       TopicDescriptionGroupRepository didacticUnitGroupRepository,
                                       TermService termService) {
        this.didacticUnitRepository = didacticUnitRepository;
        this.didacticUnitGroupRepository = didacticUnitGroupRepository;
        this.termService = termService;
    }

    @Override
    public void add(List<TopicDescriptionGroup> didacticUnitGroups) {
        didacticUnitGroups.stream().peek(this::createNewDidacticUnit).close();
    }

    @Override
    public void add(TopicDescriptionGroup didacticUnitGroup) {
        createNewDidacticUnit(didacticUnitGroup);
    }

    @Override
    public void add(TopicDescription didacticUnit) {
        didacticUnit.setId(UUID.randomUUID().toString());
        didacticUnitRepository.add(didacticUnit);
    }

    @Override
    public List<TopicDescriptionGroup> getNext(String id) {
        List<TopicDescriptionGroup> groups = didacticUnitGroupRepository.findNext(id);
        groups = groups.stream().peek(g -> {
            List<TopicDescription> units = didacticUnitRepository.findByGroup(g.getId());
            g.setDidacticUnits(units);
        }).collect(Collectors.toList());
        return groups;
    }

    @Override
    public List<TopicDescription> getByTopic(String topicId) {
        return didacticUnitRepository.findByTopic(topicId);
    }

    private void createNewDidacticUnit(TopicDescriptionGroup didacticUnitGroup) {
        didacticUnitGroup.setId(UUID.randomUUID().toString());
        didacticUnitGroupRepository.add(didacticUnitGroup);
        List<TopicDescription> didacticUnits = didacticUnitGroup.getDidacticUnits();
        String text = didacticUnits.stream()
                .map(du -> du.getName() + " ")
                .collect(Collectors.joining());
        termService.extractAndSaveTerms(text, didacticUnitGroup);
    }
}
