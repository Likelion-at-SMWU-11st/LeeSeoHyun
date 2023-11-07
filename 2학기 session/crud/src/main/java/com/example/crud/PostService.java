package com.example.crud;

import com.example.crud.Entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostDao postDao;

    public PostService(
            @Autowired PostDao postDao
    ){
        this.postDao=postDao;
    }
    public void createPost(PostDto postDto){
        this.postDao.createPost(postDto);
    }

    public PostDto readPost(int id) {
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter()
                );



    }
    public List<PostDto> readPostAll(){
        Iterator<PostEntity> iterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();

        while(iterator.hasNext()){
            PostEntity postEntity=iterator.next();
            postDtoList.add(new PostDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter()
            ));
        }
        return postDtoList;

    }
    public void updatePost(int id, PostDto postDto){
        this.postDao.updatePost(id, postDto);

    }
    public void deletePost(int id){
        this.postDao.deletePost(id);
    }

}
