package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.PostStatus;
import model.Writer;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Optional;

public class GsonWriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer get(Integer id) throws IOException {
        Writer writer = null;
        Optional<ArrayList<Writer>> writers = Optional.ofNullable(writerDeSerializator());
        if (writers.isPresent()) {
            ArrayList<Writer> arrWriters = writers.get();
            for (Writer object : arrWriters) {
                Integer i = object.getId();
                if (i.equals(id) & object.getStatus().equals(PostStatus.ACTIVE)) {
                    writer = object;
                }
            }
        } else {
            System.out.println("Файл пуст");
        }
        return writer;
    }

    @Override
    public void delete(Integer id) throws IOException {
        Writer writer = get(id);
        writer.setStatus(PostStatus.DELETED);
        writerSerializator(writer);
    }

    @Override
    public void update(Integer id, Writer newObject) throws IOException {
        newObject.setId(id);
        writerSerializator(newObject);

    }

    @Override
    public void insert(Writer obj) throws IOException {
        writerSerializator(obj);
    }

    @Override
    public ArrayList <Writer> getAll() throws IOException {
        ArrayList<Writer> writers = null;
       Optional<ArrayList<Writer>> optwriters = Optional.ofNullable(writerDeSerializator());
        optwriters.ifPresent(writerArrayList -> writerArrayList.removeIf(obj -> obj.getStatus().equals(PostStatus.DELETED)));
       writers = optwriters.get();
        return writers;
    }

    public void writerSerializator(Writer writer) throws IOException {
        ArrayList<Writer> writers = Optional.ofNullable(writerDeSerializator()).orElse(new ArrayList<>());

        int id = writer.getId();
        writers.removeIf(obj -> obj.getId() == id);
        writers.add(writer);

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(writers, fw);
        }
    }

    public ArrayList<Writer> writerDeSerializator() throws IOException {

        try (FileReader fr = new FileReader(file)) {
            Type targetClassType = new TypeToken<ArrayList<Writer>>() {
            }.getType();
            return new Gson().fromJson(fr, targetClassType);
        }
    }


}
