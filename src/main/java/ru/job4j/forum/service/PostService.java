package ru.job4j.forum.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.TopicRepository;
import ru.job4j.forum.repository.UserRepository;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, TopicRepository topicRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Post save(Post post, int topicId) {
        Post db = Post.of(post.getName(), post.getDescription());
        db.setTopic(topicRepository.findById(topicId).get());
        db.setUser(userRepository.findByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        ));
        postRepository.save(db);
        return db;
    }

    @Transactional
    public void deleteById(int id) {
      postRepository.deleteById(id);
    }

    @Transactional
    public void update(Post post, int postid) {
        Post current = postRepository.findById(postid).get();
        current.setName(post.getName());
        current.setDescription(post.getDescription());
        postRepository.save(current);
    }

    public Post findById(int id) {
        return postRepository.findById(id).get();
    }

    public List<Post> getAllPostsOfTopic(int topicId) {
        return (List<Post>) postRepository.findByTopicId(topicId);
    }
}
