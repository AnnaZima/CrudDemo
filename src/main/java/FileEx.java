import com.google.gson.Gson;

import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        Gson gson = new Gson();
        File file = new File("writers.json");
        System.out.println(file.getAbsolutePath());

    }
}
