package com.anya.crudapp.view;

import com.anya.crudapp.controller.LabelController;
import com.anya.crudapp.controller.PostController;
import com.anya.crudapp.model.Post;

import java.util.Scanner;

public class PostView {
    Scanner scanner = new Scanner(System.in);
    PostController pcontroller = new PostController();
    LabelController labelController = new LabelController();


    public void createPost (){
        System.out.println("Введите текст публикации ");
        String content = scanner.nextLine();
        System.out.println("Укажите категорию публикации ");
        String tag = scanner.nextLine();
        Post post = pcontroller.createPost(content,labelController.createLabel(tag));

        System.out.println("Публикация создана " + post);
    }

    public void changePost (){
        System.out.println("Введите ID");
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Измените текст публикации ");
        String content = scanner.nextLine();
        System.out.println("Укажите категорию публикации ");
        String tag = scanner.nextLine();

        Post post = pcontroller.changePost(id, content, labelController.createLabel(tag));
        System.out.println("Публикация изменена " + post);

    }

    public void deletePost (){
        System.out.println("Введите ID");
        int id = scanner.nextInt();
        pcontroller.deletePost(id);
        System.out.println("Операция выполнена успешно");

    }

    public void readPost (){
        System.out.println("Введите ID");
        int id = scanner.nextInt();
        System.out.println(pcontroller.getPost(id));
    }

    public void getAll() {
        System.out.println(pcontroller.getAllPosts());
    }

    public void listOfDeleted() {
        System.out.println(pcontroller.getAllDeletedPosts());
    }






}
