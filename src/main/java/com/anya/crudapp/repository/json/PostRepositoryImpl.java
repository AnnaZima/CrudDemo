package com.anya.crudapp.repository.json;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Post;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.PostRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepositoryImpl implements PostRepository {

    private static final File file = new File("C:\\Users\\Заяц\\Downloads\\CrudDemo\\src\\main\\resources\\posts.json");

    @Override
    public Post get(Integer id) {
        return readFromFile().stream().
                filter(post -> post.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        List<Post> posts = readFromFile().stream().peek(post -> {
            if (post.getId().equals(id)) {
                post.setStatus(Status.DELETED);
            }
        }).collect(Collectors.toList());
        writeToFile(posts);
    }

    @Override
    public Post update(Post newPost) {
        List<Post> postList = readFromFile().stream().map(post -> {
            if (post.getId().equals(newPost.getId())) {
                return newPost;
            }
            return post;
        }).collect(Collectors.toList());
        writeToFile(postList);
        return newPost;
    }

    @Override
    public Post insert(Post newPost) {
        List<Post> postList = readFromFile();
        newPost.setId(generateID(postList));
        postList.add(newPost);
        writeToFile(postList);
        return newPost;
    }

    @Override
    public List<Post> getAll() {
        return readFromFile().stream().filter(p -> p.getStatus().equals(Status.ACTIVE)).collect(Collectors.toList());
    }

    @Override
    public List<Post> getAllDeleted() {
        return readFromFile().stream().filter(p -> p.getStatus().equals(Status.DELETED)).collect(Collectors.toList());
    }

    @Override
    public Integer generateID(List<Post> listT) {
        return listT.stream().mapToInt(Post::getId).max().orElse(0) + 1;
    }

    private void writeToFile(List<Post> posts) {
        try (BufferedWriter recorder = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(posts, recorder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Post> readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Type targetClassType = new TypeToken<List<Post>>() {
            }.getType();
            return new Gson().fromJson(reader, targetClassType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
