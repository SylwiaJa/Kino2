
import java.io.IOException;


public class Cinema {

    Menu menu = new Menu();

    public Cinema() throws IOException, ClassNotFoundException {
    }


    public void getMenu() throws IOException {
        menu.mainMenu();
    }
}
