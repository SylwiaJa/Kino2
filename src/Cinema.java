import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Cinema {
    Scanner sc = new Scanner(System.in);
    ArrayList<Movie> movies = new ArrayList<>();

    public Cinema() throws IOException, ClassNotFoundException {
        try {
            movies = SerializableFileManager.readFromFile();
        }catch (FileNotFoundException e){
            System.out.println("nowa baza");
        }
    }

    void  menu() throws IOException {
        int input=0;
        do {
            System.out.println("Witamy w naszsym kinie");
            System.out.println("Wybierz opcje;");
            System.out.println("1 - Wyświetl dostepne filmy" );
            System.out.println("2 - Dodaj film");
            System.out.println("0 - Koniec");
            input = sc.nextInt();
            sc.nextLine();
            switch (input){
                case 0-> {
                 SerializableFileManager.writeToFile(movies);
                    return;
                }
                case 1->{displayMove();}
                case 2->{addMoveMenu();}
                default ->{ error();}
            }
        }while(true);
    }
    private HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc(){
        HashMap<Character, HashMap<Integer, Boolean>> miejsca = new HashMap<>();
        HashMap<Integer,Boolean> rzad = new HashMap<>();
        for (int i=1; i<=10; i++){
            rzad.put(i,true);
        }
        for (int j=0; j<5; j++) {
            miejsca.put((char) (65 + j), rzad);
        }
        return miejsca;
    }
    private void addMoveMenu()  {
        String tytul;
        String data;
        String godzina;
        int ograniczenieWiekowe;
        System.out.println("Dodaj mowy film:");
        System.out.println("Tytuł: ");
        tytul = sc.nextLine();
        System.out.println("Data: (YYYY-MM-DD)");
        data = sc.nextLine();
        System.out.println("Godzina: (HH:MM)");
        godzina = sc.nextLine();
        System.out.println("Ograniczenie wiekowe:");
        ograniczenieWiekowe = sc.nextInt();
        sc.nextLine();
        Movie movie = new Movie(tytul, LocalDate.parse(data), LocalTime.parse(godzina), ograniczenieWiekowe, liczbaMiejsc());
        movies.add(movie);
        System.out.println("Dodano film");

    }




    private void displayMove() {
        int i =0;
        for (Movie movie:movies) {
            ++i;
            System.out.println(i);
            System.out.println( movie.toDisplay());
        }
    }
    private void  error(){

    }
}
