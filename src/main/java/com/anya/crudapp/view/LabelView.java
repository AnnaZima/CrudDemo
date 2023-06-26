package com.anya.crudapp.view;

import com.anya.crudapp.controller.LabelController;
import com.anya.crudapp.model.Label;

import java.util.Scanner;

public class LabelView {
    LabelController labelController = new LabelController();
    Scanner scanner = new Scanner(System.in);
    public final String ENTER_ID = "Введите ID";

    public void createLabel() {
        System.out.println("Введите название категории");
        String nameLabel = scanner.nextLine();
        Label label = labelController.createLabel(nameLabel);

        System.out.println("Категория создана" + label);
    }

    public void changeLabel() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Измените название категории");
        String nameLabel = scanner.nextLine();
        Label label = labelController.changeLabel(id, nameLabel);
        System.out.println("Категория успешно изменена" + label);
    }

    public void getLabel() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        System.out.println(labelController.getLabel(id));

    }

    public void deleteLabel() {
        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        labelController.deleteLabel(id);
        System.out.println("Успешная операция");
    }

    public void getAll() {
        System.out.println(labelController.getAllLabels());

    }


}
