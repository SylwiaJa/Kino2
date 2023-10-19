import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Cinema {

    Menu menu = new Menu();

    public Cinema() throws IOException, ClassNotFoundException {
    }


    public void getMenu() throws IOException, ClassNotFoundException {
        menu.mainMenu();
    }
}
