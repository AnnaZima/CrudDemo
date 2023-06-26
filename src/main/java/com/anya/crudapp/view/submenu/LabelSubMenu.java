package com.anya.crudapp.view.submenu;

import com.anya.crudapp.view.LabelView;

import java.util.Scanner;

public class LabelSubMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final LabelView labelView = new LabelView();
    private final String subMenuMessage = "Выберете комманду:\n" +
            " 1. Создать тег\n" +
            " 2. Редактировать тег\n" +
            " 3. Найти тег\n" +
            " 4. Удалить тег\n" +
            " 5. Вывести список тегов\n" +
            " 6. Выйти из меню";

    public void runner() {
        boolean isExit = false;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println(subMenuMessage);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            String response = scanner.next();

            switch (response) {
                case "1":
                    labelView.createLabel();
                    break;
                case "2":
                    labelView.changeLabel();
                    break;
                case "3":
                   labelView.getLabel();
                    break;
                case "4":
                    labelView.deleteLabel();
                    break;
                case "5":
                    labelView.getAll();
                    break;
                case "6":
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
