package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.entity.Topic;
import ru.job4j.forum.service.StatusTopicService;
import ru.job4j.forum.service.TopicService;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class TopicControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topics;

    @MockBean
    private StatusTopicService statuses;

    @Test
    @WithMockUser
    public void shouldReturnCreateTopicPage() throws Exception {
        Mockito.doReturn(List.of()).when(statuses).getAllStatuses();
        this.mockMvc.perform(get("/topic/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic/createTopic"));
    }

    @Test
    @WithMockUser
    public void shouldReturnUpdateTopicPage() throws Exception {
        this.mockMvc.perform(get("/topic/update?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic/updateTopic"));
    }

    @Test
    @WithMockUser
    public void shouldReturnHomePageAfterSaveTopic() throws Exception {
        this.mockMvc.perform(post("/topic/save")
                .param("id", "1")
                .param("name", "Test Topic"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Topic> argument = ArgumentCaptor.forClass(Topic.class);
        verify(topics).save(argument.capture());
        assertThat(argument.getValue().getId(), is(1));
        assertThat(argument.getValue().getName(), is("Test Topic"));
    }

    @Test
    @WithMockUser
    public void shouldReturnHomePageAfterUpdateTopic() throws Exception {
        this.mockMvc.perform(post("/topic/saveUpdate")
                .param("id", "1")
                .param("name", "Update test Topic"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Topic> argument = ArgumentCaptor.forClass(Topic.class);
        verify(topics).update(argument.capture(), anyInt());
        assertThat(argument.getValue().getName(), is("Update test Topic"));
    }

    @Test
    @WithMockUser
    public void shouldReturnHomePageAfterDeleteTopic() throws Exception {
        this.mockMvc.perform(get("/topic/delete")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
    }
}
