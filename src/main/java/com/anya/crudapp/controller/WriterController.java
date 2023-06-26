package com.anya.crudapp.controller;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Post;
import com.anya.crudapp.model.Writer;
import com.anya.crudapp.repository.WriterRepository;
import com.anya.crudapp.repository.json.GsonWriterRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WriterController {
    WriterRepository writerRepository = new GsonWriterRepositoryImpl();
    PostController postController = new PostController();
    LabelController labelController = new LabelController();

    public Writer getWriter(Integer id) {
        return writerRepository.get(id);
    }

    public Writer createWriter(String name, String lastname) {
        Writer writer = new Writer(name, lastname);
        return writerRepository.insert(writer);
    }

    public Writer changeWriter(Integer id, String name, String lastname, String content, String tagOfPost) {
        Writer writer = getWriter(id);
        writer.setFirstName(name);
        writer.setLastName(lastname);
        Label tag = labelController.createLabel(tagOfPost);
        Post post = postController.createPost(content, tag);
        List<Post> posts = Optional.ofNullable(writer.getPosts()).orElse(new ArrayList<>());
        posts.add(post);
        writer.setPosts(posts);
        return writerRepository.update(writer);
    }


    public void deleteWriter(Integer id) {
        writerRepository.delete(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public List<Writer> getAllDeletedWriters() {
        return writerRepository.getAllDeleted();
    }

    public void totalCleaner() {
        writerRepository.totalClean();
    }


}
