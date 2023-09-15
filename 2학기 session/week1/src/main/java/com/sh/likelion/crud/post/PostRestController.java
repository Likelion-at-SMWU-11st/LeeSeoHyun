package com.sh.likelion.crud.post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController{
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postList;

    public PostRestController(){
        this.postList = new ArrayList<>();
    }

    //http://localhost;8080/post

    @PostMapping()
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postList.get(id);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        PostDto targetPost = this.postList.get(id);
        if(postDto.getTitle()!=null){
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent()!=null){
            targetPost.setContent(postDto.getContent());
        }
        if(postDto.getWriter()!=null){
            targetPost.setWriter(postDto.getWriter());
        }
        this.postList.set(id, targetPost);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        this.postList.remove(id);
    }
}