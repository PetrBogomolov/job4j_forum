package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.entity.Topic;
import ru.job4j.forum.service.StatusTopicService;
import ru.job4j.forum.service.TopicService;


@Controller
public class TopicControl {
    private final TopicService topicService;
    private final StatusTopicService statusTopicService;

    public TopicControl(TopicService topicService, StatusTopicService statusTopicService) {
        this.topicService = topicService;
        this.statusTopicService = statusTopicService;
    }

    @GetMapping("/createTopic")
    public String homePage(Model model) {
        model.addAttribute("statuses", statusTopicService.getAllStatuses());
        return "topic/createTopic";
    }

    @PostMapping("/saveTopic")
    public String addTopicInDB(@ModelAttribute Topic topic) {
        topicService.save(topic);
        return "redirect:/index";
    }

    @GetMapping("/deleteTopic")
    public String deleteTopic(@RequestParam("id") int id) {
        topicService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/updateTopic")
    public String updateTopic(@RequestParam("id") int id, Model model) {
        model.addAttribute("statuses", statusTopicService.getAllStatuses());
        model.addAttribute("topic", topicService.findById(id));
        return "topic/updateTopic";
    }

    @PostMapping("/saveUpdateTopic")
    public String saveUpdateTopic(@RequestParam("id") int id, @ModelAttribute Topic topic) {
        topicService.update(topic, id);
        return "redirect:/index";
    }
}
