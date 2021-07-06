package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnPostsPage() throws Exception {
        this.mockMvc.perform(get("/post/discussion").param("topicId", "13"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/posts"));
    }

    @Test
    @WithMockUser
    public void shouldReturnPostCreatePage() throws Exception {
        this.mockMvc.perform(get("/post/create").param("topicId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/createPost"));
    }

    @Test
    @WithMockUser
    public void shouldReturnUpdatePage() throws Exception {
        this.mockMvc.perform(get("/post/update").param("postId", "39"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/updatePost"));
    }
}
