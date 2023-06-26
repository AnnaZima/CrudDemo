package com.anya.crudapp.repository.json;

import com.anya.crudapp.model.Label;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.WriterRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.anya.crudapp.model.Writer;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private static final File file = new File("C:\\Users\\Заяц\\Downloads\\CrudDemo\\src\\main\\resources\\writers.json");

    @Override
    public Writer get(Integer id) {
        return readFromFile().stream().
                filter(el -> el.getId().equals(id)).
                findFirst().orElse(null);

    }

    @Override
    public void delete(Integer id) {
        List<Writer> currentList = readFromFile().stream().peek(el -> {
            if (el.getId().equals(id)) {
                el.setStatus(Status.DELETED);
            }
        }).collect(Collectors.toList());
        writeToFile(currentList);
    }

    @Override
    public Writer update(Writer newWriter) {
        List<Writer> listWriters = readFromFile().
                stream().map(currentWriter -> {
                    if (currentWriter.getId().equals(newWriter.getId())) {
                        return newWriter;
                    }
                    return currentWriter;
                }).collect(Collectors.toList());
        writeToFile(listWriters);
        return newWriter;
    }

    @Override
    public Writer insert(Writer writer) {
        List<Writer> writerList = readFromFile();
        writer.setId(generateID(writerList));
        writerList.add(writer);
        writeToFile(writerList);
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        return readFromFile().stream().
                filter(el -> el.getStatus().equals(Status.ACTIVE)).
                collect(Collectors.toList());
    }

    @Override
    public Integer generateID(List<Writer> listT) {
        return listT.stream().mapToInt(Writer::getId).max().orElse(0) + 1;
    }


    @Override
    public List<Writer> getAllDeleted() {
        return readFromFile().stream().
                filter(el -> el.getStatus().equals(Status.DELETED)).
                collect(Collectors.toList());
    }

    @Override
    public void totalClean() {
        List<Writer> currentLabels = readFromFile();
        currentLabels.removeAll(getAllDeleted());
        writeToFile(currentLabels);

    }

    private void writeToFile(List<Writer> writers) {
        try (BufferedWriter recorder = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(writers, recorder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Writer> readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Type targetClassType = new TypeToken<List<Writer>>() {
            }.getType();
            return new Gson().fromJson(reader, targetClassType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
