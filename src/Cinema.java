import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Cinema {
    ArrayList<Movie> movies = new ArrayList<>();
    Menu menu = new Menu();

    public Cinema() throws IOException, ClassNotFoundException {
        try {
            movies = SerializableFileManager.readFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("nowa baza");
        }
    }

    public void getMenu() throws IOException {
        menu.mainMenu();
    }
}
