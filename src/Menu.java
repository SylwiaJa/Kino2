import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ArrayList<Movie> movies = new ArrayList<>();
    private File fileName = new File("movie.txt");

    public void mainMenu() throws IOException {
        int input = 9;
        do {
            System.out.println("Witamy w naszsym kinie");
            System.out.println("Wybierz opcje;");
            System.out.println("1 - Wyświetl dostepne filmy");
            System.out.println("2 - Dodaj film");
            System.out.println("0 - Koniec");
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawne dane");
            }
            sc.nextLine();
            switch (input) {
                case 0 -> {
                    SerializableFileManager.writeToFile(movies);
                    return;
                }
                case 1 -> displayMovie();
                case 2 -> addMovieMenu();
            }
        } while (true);
    }

    private void addMovieMenu() throws IOException {
        String title;
        String date;
        String hour;
        int ageLimit;

        System.out.println("Dodaj nowy film:");
        System.out.println("Tytuł: ");
        title = sc.nextLine();
        System.out.println("Data: (YYYY-MM-DD)");
        date = sc.nextLine();
        System.out.println("Godzina: (HH:MM)");
        hour = sc.nextLine();
        System.out.println("Ograniczenie wiekowe:");
        try {
            ageLimit = sc.nextInt();
            sc.nextLine();
            Movie movie = new Movie(title, LocalDate.parse(date), LocalTime.parse(hour), ageLimit, new CinemaHall().numberOfSeats());
            FileHandler.addToFile(movie, fileName);
            System.out.println("Dodano film");
        } catch (InputMismatchException | DateTimeParseException e) {
            System.out.println("Niepoprawne dane");
        }
    }

    private void displayMovie() throws IOException {
        FileHandler.readFromFile(fileName);
        selectMovie();
    }

    private void selectMovie() {
//        System.out.println("wybierz flim który chcesz zarezerwować:");
//        int chose = sc.nextInt();
//        sc.nextLine();
//        movies.get(chose - 1).displayCinemaRoom();
//        char row = sc.nextLine().charAt(0);
//        int seat = sc.nextInt();
//        sc.nextLine();
//        movies.get(chose - 1).reservation(row, seat);
    }
}
