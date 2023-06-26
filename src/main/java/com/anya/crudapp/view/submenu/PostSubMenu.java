package com.anya.crudapp.view.submenu;

import com.anya.crudapp.view.PostView;

import java.util.Scanner;

public class PostSubMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PostView postView = new PostView();
    private final String subMenuMessage = "Выберете комманду:\n" +
            " 1. Создать публикацию\n" +
            " 2. Редактировать публикацию\n" +
            " 3. Найти публикацию\n" +
            " 4. Удалить публикацию\n" +
            " 5. Вывести список публикаций\n" +
            " 6. Вывести список удаленных публикация\n" +
            " 7. Выйти из меню";

    public void runner() {
        boolean isExit = false;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println(subMenuMessage);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            String response = scanner.next();

            switch (response) {
                case "1":
                    postView.createPost();
                    break;
                case "2":
                    postView.changePost();
                    break;
                case "3":
                    postView.readPost();
                    break;
                case "4":
                    postView.deletePost();
                    break;
                case "5":
                    postView.getAll();
                    break;
                case "6":
                    postView.listOfDeleted();
                    break;
                case "7":
                    isExit = true;
                    break;
                default:
                    System.out.println("Некорректное значение");
                    break;
            }

            if (isExit)
                break;
        }
    }
}