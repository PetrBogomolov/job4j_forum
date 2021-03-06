package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final TopicService topicService;

    public PostController(PostService service, TopicService topicService) {
        this.postService = service;
        this.topicService = topicService;
    }

    @GetMapping("/discussion")
    public String getAllPostsOfTopic(@RequestParam("topicId") int id, Model model) {
        model.addAttribute("posts", postService.getAllPostsOfTopic(id));
        model.addAttribute("topicId", id);
        model.addAttribute("topicName", topicService.findById(id).getName());
        return "post/posts";
    }

    @GetMapping("/create")
    public String createPost(@RequestParam("topicId") int id, Model model) {
        model.addAttribute("topicId", id);
        return "post/createPost";
    }

    @PostMapping("/save")
    public String savePost(@RequestParam("topicId") int id,
                           @ModelAttribute Post post) {
        postService.save(post, id);
        return String.format("redirect:/post/discussion?topicId=%d", id);
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam("postId") int postId,
                             @RequestParam("topicId") int topicId) {
        postService.deleteById(postId);
        return String.format("redirect:/post/discussion?topicId=%d", topicId);
    }

    @GetMapping("/update")
    public String updateTopic(@RequestParam("postId") int postId, Model model) {
        model.addAttribute("post", postService.findById(postId));
        return "post/updatePost";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdateTopic(@RequestParam("postId") int postId,
                                  @RequestParam("topicId") int topicId,
                                  @ModelAttribute Post post) {
        postService.update(post, postId);
        return String.format("redirect:/post/discussion?topicId=%d", topicId);
    }
}
