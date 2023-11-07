package com.example.crud;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.Assert.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostRestController.class)
public class PostRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void readPostAll() throws Exception {
        //given
        PostDto post1 = new PostDto();
        post1.setTitle("title1");
        post1.setContent("content1");
        post1.setWriter("writer1");

        PostDto post2 = new PostDto();
        post2.setTitle("title2");
        post2.setContent("content2");
        post2.setWriter("writer2");

        PostDto post3 = new PostDto();
        post3.setTitle("title3");
        post3.setContent("content3");
        post3.setWriter("writer3");

        List<PostDto> readAllPost = Arrays.asList(post1, post2, post3);
        given(postService.readPostAll()).willReturn(readAllPost);

        //when
        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$", hasSize(readAllPost.size()))
        );
    }

    @Test
    public void readPost() throws Exception {
        //given
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit title");
        testDto.setContent("Unit content");
        testDto.setWriter("Unit writer");

        given(postService.readPost(id)).willReturn(testDto);

        //when
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().isOk(),
                jsonPath("$.id", is(id)),
                jsonPath("$.title", is(testDto.getTitle())),
                jsonPath("$.content", is(testDto.getContent())),
                jsonPath("$.writer", is(testDto.getWriter()))
        );
    }
}