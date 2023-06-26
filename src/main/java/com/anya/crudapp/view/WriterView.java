package com.anya.crudapp.view;


import com.anya.crudapp.controller.WriterController;
import com.anya.crudapp.model.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView {
    Scanner scanner = new Scanner(System.in);
    public final static String ENTER_NAME = "Введите имя автора:";
    public final static String ENTER_LASTNAME = "Введите фамилию автора:";
    public final static String ENTER_ID = "Введите Id:";


    private final WriterController wcontroller = new WriterController();


    public void createWriter() {
        System.out.println(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.println(ENTER_LASTNAME);
        String lastname = scanner.nextLine();


        Writer wr = wcontroller.createWriter(name, lastname);
        System.out.println("Автор создан: " + wr);

    }

    public void changeWriter() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.println(ENTER_LASTNAME);
        String lastname = scanner.nextLine();
        System.out.println("Введите текст публикации: ");
        String content = scanner.nextLine();
        System.out.println("Укажите категорию публикации: ");
        String tag = scanner.nextLine();


        Writer wr = wcontroller.changeWriter(id, name, lastname, content, tag);
        System.out.println("Запись изменена: " + wr);

    }

    public void deleteWriter() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        wcontroller.deleteWriter(id);
    }

    public void getWriter() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        Writer writer = wcontroller.getWriter(id);
        System.out.println(writer);
    }

    public void getAll() {
        System.out.println(wcontroller.getAllWriters());
    }

    public void listOfDeleted() {
        System.out.println(wcontroller.getAllDeletedWriters());
    }

    public void totalCleaner() {
        wcontroller.totalCleaner();
    }


}
