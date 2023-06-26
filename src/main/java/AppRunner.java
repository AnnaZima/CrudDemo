import com.anya.crudapp.view.MainView;

import java.io.IOException;


public class AppRunner {
    public static void main(String[] args) throws IOException {
        MainView mainView = new MainView();
        mainView.start();
    }
}
