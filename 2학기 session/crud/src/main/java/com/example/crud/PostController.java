package com.example.crud;

import com.example.crud.aspect.LogExecutionTime;
import com.example.crud.aspect.LogArguments;
import com.example.crud.aspect.LogReturn;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("Post")
    public class PostController {
    private static final Logger logger =  LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final Gson gson;

    public PostController(
            @Autowired PostService postService,
            @Autowired Gson gson
//            @Autowired GsonComponent gson
    ){
        this.postService=postService;
        logger.info(gson.toString());
//        this.gson = gson.getGson();
    }

    @LogArguments
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostDto postDto){
        this.postService.createPost(postDto);
    }
//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createPost(
//            @RequestBody PostDto dto
//    ){
//        logger.info("start processing");
//        this.postService.createPost(dto);
//        logger.info("Finish processing");
//    }


    @LogReturn
    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        return this.postService.readPost(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        this.postService.updatePost(id,postDto);
    }

    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @DeleteMapping("{id}")

    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        // 어떤 값을 가지고 있는지 확인을 하는 용도
        //System.out.println(id);
        //logger.info("deletePost, id: {}", id);
        this.postService.deletePost(id);
    }

    @GetMapping("test-log")
    public void testLog(){
        logger.trace("A TRACE Log Message");
        logger.debug("A DEBUG Log Message");
        logger.info("An INFO Log Message");
        logger.warn("A WARN Log Message");
        logger.error("An ERROR Log Message");
    }
    @PostMapping("test-valid")
    public void testValue(@Valid @RequestBody ValidTestDto dto){
        logger.info(dto.toString());
    }


}

