package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
