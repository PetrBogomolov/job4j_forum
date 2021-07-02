package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.entity.StatusTopic;

public interface StatusRepository extends CrudRepository<StatusTopic, Integer> {

    StatusTopic findByName(String name);
}
