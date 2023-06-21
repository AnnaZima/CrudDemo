package model;
import repository.GsonWriterRepositoryImpl;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        model.Writer writer = new model.Writer();
        writer.setFirstName("Аня");
        writer.setLastName("Анина");
        writer.setId(123);

        model.Writer writer1 = new Writer();
        writer1.setFirstName("Оля");
        writer1.setLastName("Олина");
        writer1.setId(124);

        model.Writer writer2 = new Writer();
        writer2.setFirstName("Лена");
        writer2.setLastName("Ленина");
        writer2.setId(126);

        model.Writer writer3 = new Writer();
        writer3.setFirstName("Петр");
        writer3.setLastName("Петров");
        writer3.setId(126);

        GsonWriterRepositoryImpl gs = new GsonWriterRepositoryImpl();

       gs.update(124, writer3);










    }
}
