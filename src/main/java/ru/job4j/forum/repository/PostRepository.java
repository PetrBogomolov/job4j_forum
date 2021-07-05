package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.entity.Post;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findByTopicId(int topicId);
}
