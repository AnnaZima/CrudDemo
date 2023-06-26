package com.anya.crudapp.controller;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Post;
import com.anya.crudapp.repository.PostRepository;
import com.anya.crudapp.repository.json.PostRepositoryImpl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostController {


    PostRepositoryImpl postRepository = new PostRepositoryImpl();

    public Post getPost(Integer id) {
        return postRepository.get(id);
    }

    public Post createPost(String content, Label tag) {
        Post post = new Post();
        LocalDateTime created = LocalDateTime.now();
        post.setContent(content);
        post.setCreated(created);
        List<Label> labels = new ArrayList<>();
        labels.add(tag);
        post.setLabels(labels);
        return postRepository.insert(post);

    }

    public Post changePost(Integer id, String content, Label tag) {
        Post post = getPost(id);
        LocalDateTime updated = LocalDateTime.now();
        post.setUpdated(updated);
        List<Label> listTags = post.getLabels();
        listTags.add(tag);
        post.setLabels(listTags);
        post.setId(id);
        post.setContent(content);
        return postRepository.update(post);
    }

    public void deletePost(Integer id) {
        postRepository.delete(id);

    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();

    }

    public List<Post> getAllDeletedPosts() {
        return postRepository.getAllDeleted();
    }
}
