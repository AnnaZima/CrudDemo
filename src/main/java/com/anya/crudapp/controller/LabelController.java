package com.anya.crudapp.controller;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.LableReposytori;
import com.anya.crudapp.repository.json.GsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {
    private final LableReposytori lableReposytori = new GsonLabelRepositoryImpl();

    public Label createLabel(String name) {
        Label label = new Label(name);
        return lableReposytori.insert(label);
    }

    public Label changeLabel (Integer id, String name) {
        Label label = getLabel(id);
        label.setName(name);
        return lableReposytori.update(label);
    }

    public Label getLabel (Integer id) {
        return lableReposytori.get(id);
    }

    public void deleteLabel (Integer id) {
        lableReposytori.delete(id);
    }

    public List<Label> getAllLabels() {
       return lableReposytori.getAll();
    }

}
