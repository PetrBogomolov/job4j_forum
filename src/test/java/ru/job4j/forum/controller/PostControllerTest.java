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
import ru.job4j.forum.entity.Post;
import ru.job4j.forum.entity.Topic;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @MockBean
    private TopicService topics;

    @Test
    @WithMockUser
    public void shouldReturnPostsPage() throws Exception {
        Mockito.doReturn(new Topic()).when(topics).findById(1);
        this.mockMvc.perform(get("/post/discussion?topicId=1"))
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


    @Test
    @WithMockUser
    public void shouldReturnPostsPageAfterSavePost() throws Exception {
        this.mockMvc.perform(post("/post/save")
                .param("topicId", "1")
                .param("name", "Test post"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post/discussion?topicId=1"));
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).save(argument.capture(), anyInt());
        assertThat(argument.getValue().getName(), is("Test post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnPostsPageAfterUpdatePost() throws Exception {
        this.mockMvc.perform(post("/post/saveUpdate")
                .param("postId", "1")
                .param("topicId", "1")
                .param("name", "Update test post"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post/discussion?topicId=1"));
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).update(argument.capture(), anyInt());
        assertThat(argument.getValue().getName(), is("Update test post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnPostsPageAfterDeletePost() throws Exception {
        this.mockMvc.perform(get("/post/delete")
                .param("postId", "1")
                .param("topicId", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post/discussion?topicId=1"));
    }
}
