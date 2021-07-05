package ru.job4j.forum.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.entity.Topic;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.StatusRepository;
import ru.job4j.forum.repository.TopicRepository;
import ru.job4j.forum.repository.UserRepository;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public TopicService(TopicRepository topicRepository,
                        StatusRepository statusRepository,
                        UserRepository userRepository,
                        PostRepository postRepository) {
        this.topicRepository = topicRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Topic save(Topic topic) {
        Topic db = Topic.of(topic.getName());
        db.setUser(userRepository.findByUsername(
                SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        ));
        db.setStatus(statusRepository.findById(topic.getStatus().getId()).get());
        topicRepository.save(db);
        return db;
    }

    @Transactional
    public void update(Topic topic, int id) {
        Topic current = findById(id);
        current.setName(topic.getName());
        current.setStatus(statusRepository.findById(topic.getStatus().getId()).get());
        topicRepository.save(current);
    }

    @Transactional
    public void delete(int id) {
        Topic current = findById(id);
        List<Post> posts = current.getPosts();
        posts.forEach(postRepository::delete);
        topicRepository.deleteById(id);
    }

    public Topic findById(int id) {
       return topicRepository.findById(id).get();
    }

    public List<Topic> getAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }
}
