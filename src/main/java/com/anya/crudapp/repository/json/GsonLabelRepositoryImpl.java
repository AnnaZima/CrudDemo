package com.anya.crudapp.repository.json;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.LableReposytori;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class GsonLabelRepositoryImpl implements LableReposytori {
    private static final File file = new File("C:\\Users\\Заяц\\Downloads\\CrudDemo\\src\\main\\resources\\labels.json");

    @Override
    public Label get(Integer id) {
        return readLabelFromFile().stream().filter(el -> el.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        List<Label> currentList = readLabelFromFile()
                .stream().peek(el -> {
                    if (el.getId().equals(id)) {
                        el.setStatus(Status.DELETED);
                    }
                }).collect(Collectors.toList());
        writeLabelToFile(currentList);
    }

    @Override
    public Label update(Label labelToUpdate) {
        List<Label> currentList = readLabelFromFile()
                .stream().map(currentLabel -> {
                    if (currentLabel.getId().equals(labelToUpdate.getId())) {
                        return labelToUpdate;
                    }
                    return currentLabel;
                }).collect(Collectors.toList());
        writeLabelToFile(currentList);
        return labelToUpdate;
    }

    public Integer generateID(List<Label> labelList) {
        return labelList.stream().mapToInt(Label::getId).max().orElse(0) + 1;

    }

    @Override
    public Label insert(Label labelToFile) {
        List<Label> currentListLabels = readLabelFromFile();
        labelToFile.setId(generateID(currentListLabels));
        currentListLabels.add(labelToFile);
        writeLabelToFile(currentListLabels);
        return labelToFile;
    }


    @Override
    public List<Label> getAll() {
        return readLabelFromFile().stream().filter(el -> el.getStatus().equals(Status.ACTIVE)).collect(Collectors.toList());
    }


     public void writeLabelToFile(List<Label> labels) {
        try (BufferedWriter recorder = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(labels, recorder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Label> readLabelFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Type targetClassType = new TypeToken<List<Label>>() {
            }.getType();
            return new Gson().fromJson(reader, targetClassType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
