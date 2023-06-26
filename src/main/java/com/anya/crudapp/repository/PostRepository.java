package com.anya.crudapp.repository;

import com.anya.crudapp.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, Integer>{

    List<Post> getAllDeleted();

}
