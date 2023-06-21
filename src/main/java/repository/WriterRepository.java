package repository;

import model.Writer;
import repository.GenericRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface WriterRepository extends GenericRepository<Writer, Integer> {
    static final File file = new File("writer.json");
    void writerSerializator(Writer writer) throws IOException;
    ArrayList<Writer> writerDeSerializator() throws IOException;
}
