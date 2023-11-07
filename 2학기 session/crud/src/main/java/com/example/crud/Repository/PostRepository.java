package com.example.crud.Repository;

import com.example.crud.Entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity,Long> {
}
