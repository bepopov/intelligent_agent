package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TermService termService;
    private TopicRepository topicRepository;
    private TaskScheduler taskScheduler;

    public TopicServiceImpl(TermService termService, TopicRepository topicRepository, TaskScheduler taskScheduler) {
        this.termService = termService;
        this.topicRepository = topicRepository;
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void add(Topic topic) {
        Runnable task = () -> {
            topicRepository.add(topic);
            List<Term> terms = termService.extractAndSaveTerms(topic.getName(), topic);
        };
        taskScheduler.schedule(task, new Date());
    }

    @Override
    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    @Override
    public void delete(Topic topic) {
        topicRepository.remove(topic);
    }
}
