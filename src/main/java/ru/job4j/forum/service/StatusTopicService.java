package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.entity.StatusTopic;
import ru.job4j.forum.repository.StatusRepository;

import java.util.List;

@Service
public class StatusTopicService {
    private final StatusRepository statuses;

    public StatusTopicService(StatusRepository statuses) {
        this.statuses = statuses;
    }

    public List<StatusTopic> getAllStatuses() {
        return (List<StatusTopic>) statuses.findAll();
    }
}
