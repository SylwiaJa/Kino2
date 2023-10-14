import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Kino {
    Scanner sc = new Scanner(System.in);
    File filename = new File("dane.txt");
    FileWriter f = new FileWriter(filename, true);
    BufferedWriter out = new BufferedWriter(f);
    FileInputStream g = new FileInputStream(filename);
    DataInputStream in = new DataInputStream(g);
    BufferedReader r = new BufferedReader(new InputStreamReader(in));
    public Kino() throws IOException {
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
                    out.close();
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
    private void addMoveMenu() throws IOException {
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
        Seans seans = new Seans(tytul, LocalDate.parse(data), LocalTime.parse(godzina), ograniczenieWiekowe, liczbaMiejsc());
        System.out.println("Dodano film");


        out.write(seans.toString());
        out.newLine();


    }




    private void displayMove() throws IOException {
        String strLine;
int i=1;
        while ((strLine = r.readLine()) != null) {
            String[] split = strLine.split(";");

            System.out.println(i);
            System.out.println("Tytuł: "+split[0]);
            System.out.println("Data: "+split[1]);
            System.out.println("Godzina: "+split[2]);
            System.out.println("Ograniczenie wiekowe: "+split[3]);
            System.out.println();
    i++;
        }
    }
    private void  error(){

    }
}
