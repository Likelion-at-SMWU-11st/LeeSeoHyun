package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private PostService postService;

    @Test
    void readPost() {
    }

    @Test
    void readPostAll() {
    }
}