import org.w3c.dom.html.HTMLTableCaptionElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ArrayList<Movie> movies;

    ArrayList<Client> clients = new ArrayList<>();


    public Menu() throws IOException, ClassNotFoundException {
        try {
            movies = SerializableFileManager.readFromFile();
        }catch (FileNotFoundException e){
             movies = new ArrayList<>();
            System.out.println("Stworzono nową baze");
        }
    }

    private File fileName = new File("clientsCinema.txt");

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
                    clients.forEach(client -> {
                        try {
                            FileHandler.addToFile(client,fileName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    SerializableFileManager.writeToFile(movies);
                    return;
                }
                case 1 -> displayMovie();
                case 2 -> addMovie();
            }
        } while (true);
    }

    private void addMovie()  {
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
            movies.add(movie);
            //  FileHandler.addToFile(movie, fileName);
            System.out.println("Dodano film");
        } catch (InputMismatchException | DateTimeParseException e) {
            System.out.println("Niepoprawne dane");
        }
    }

    private void displayMovie() {
        for(int i=0; i<movies.size();i++){
            System.out.print((i+1)+". ");
            System.out.println(movies.get(i).toString());
        }
        selectMovie();
    }

    private void selectMovie() {
        System.out.println("Wbierz flim który chcesz zarezerwować lub 0 - rezygnacja: ");
        try {
            int yourChose = sc.nextInt();
            sc.nextLine();
            if(yourChose==0)
                return;
            Movie yourMovie = movies.get(yourChose-1);
            createClient(yourMovie);
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("Niepoprawne dane!");
        }
    }
    private void createClient(Movie movie){
        HashMap<Character, Integer> clientSeats = new HashMap<>();
        System.out.println("Nazwisko: ");
        String lastName = sc.nextLine();
        System.out.println("Imię: ");
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String mail = sc.nextLine();
        System.out.println("Telefon: ");
        String phone = sc.nextLine();
        Movie chosenMovie = new Movie(movie.getTitle(), movie.getDay(), movie.getHour(), movie.getAgeRestriction());
        choseSeats(movie,clientSeats);
        Client client = new Client(lastName, name, mail, phone, chosenMovie, clientSeats);
        clients.add(client);
    }
    private void choseSeats(Movie movie, HashMap<Character, Integer> clientSeats) {
        boolean flag = false;
        do {
            System.out.println();
            System.out.println("Widok sali kinowej");
            movie.displayCinemaRoom();
            char row;
            int seat=0;
                System.out.println("Wybierz rząd: ");
                row = sc.nextLine().charAt(0);
                System.out.println("Wybierz miejsce: ");
                try {
                    seat = sc.nextInt();
                    sc.nextLine();
                    flag = movie.reservation(row, seat);
                } catch (InputMismatchException | NullPointerException e) {
                    System.out.println("Niepoprawne dane!");
                }
                if(flag)
                    clientSeats.put(row,seat);
            System.out.println("0 - koniec; 1 - zarezerwuj  miejsce");
            try {
                flag = !(sc.nextInt()!=0);
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Błędne dane!");
            }
        }while(!flag);
    }
}
