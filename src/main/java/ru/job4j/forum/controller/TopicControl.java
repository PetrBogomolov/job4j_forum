package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.Topic;
import ru.job4j.forum.service.StatusTopicService;
import ru.job4j.forum.service.TopicService;


@Controller
@RequestMapping("/topic")
public class TopicControl {
    private final TopicService topicService;
    private final StatusTopicService statusTopicService;

    public TopicControl(TopicService topicService,
                        StatusTopicService statusTopicService) {
        this.topicService = topicService;
        this.statusTopicService = statusTopicService;
    }

    @GetMapping("/create")
    public String homePage(Model model) {
        model.addAttribute("statuses", statusTopicService.getAllStatuses());
        return "topic/createTopic";
    }

    @PostMapping("/save")
    public String addTopicInDB(@ModelAttribute Topic topic) {
        topicService.save(topic);
        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String deleteTopic(@RequestParam("id") int id) {
        topicService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/update")
    public String updateTopic(@RequestParam("id") int id,
                              Model model) {
        model.addAttribute("statuses", statusTopicService.getAllStatuses());
        model.addAttribute("topic", topicService.findById(id));
        return "topic/updateTopic";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdateTopic(@RequestParam("id") int id,
                                  @ModelAttribute Topic topic) {
        topicService.update(topic, id);
        return "redirect:/index";
    }
}
