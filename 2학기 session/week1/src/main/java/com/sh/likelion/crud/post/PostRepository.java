package com.sh.likelion.crud.post;

import com.sh.likelion.crud.post.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    //<t, id>
    //t: 어떤 엔티티를 위한 레포이냐
    //id : id의 데이터 타입이 무엇이냐
}