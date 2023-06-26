package com.anya.crudapp.view.submenu;

import com.anya.crudapp.view.WriterView;

import java.util.Scanner;

public class WriterSubMenu {
    Scanner scanner = new Scanner(System.in);
    WriterView writerView = new WriterView();
   private final String subMenuMessage = "Выберете действие над авторами:\n" +
            " 1. Создать автора\n" +
            " 2. Редактировать автора\n" +
            " 3. Найти автора по ID\n" +
            " 4. Переместить автора в корзину\n" +
            " 5. Вывести список авторов\n" +
            " 6. Вывести список авторов, отправленных в корзину\n" +
            " 7. Очистить корзину\n" +
            " 8. Выйти из меню";

    public void runner() {

        boolean isExit = false;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println(subMenuMessage);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            String response = scanner.next();

            switch (response) {
                case "1":
                    writerView.createWriter();
                    break;
                case "2":
                    writerView.changeWriter();
                    break;
                case "3":
                    writerView.getWriter();
                    break;
                case "4":
                    writerView.deleteWriter();
                    break;
                case "5":
                    writerView.getAll();
                    break;
                case "6":
                    writerView.listOfDeleted();
                    break;
                case "7":
                    writerView.totalCleaner();
                    break;
                case "8":
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
