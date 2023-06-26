package com.anya.crudapp.view;

import com.anya.crudapp.view.submenu.LabelSubMenu;
import com.anya.crudapp.view.submenu.PostSubMenu;
import com.anya.crudapp.view.submenu.WriterSubMenu;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    LabelSubMenu labelMenu = new LabelSubMenu();
    WriterSubMenu writerMenu = new WriterSubMenu();
    PostSubMenu postMenu = new PostSubMenu();


    String menu = "1 - Управление публикациями\n" +
            "2 - Управление авторами\n" +
            "3 - Управление тегами\n" +
            "4 - Выход";

    public void start() {
        System.out.println();
        boolean isExit = false;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println(menu);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            String response = scanner.next();

            switch (response) {
                case "1":
                    postMenu.runner();
                    break;
                case "2":
                    writerMenu.runner();
                    break;
                case "3":
                   labelMenu.runner();
                    break;
                case "4":
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

