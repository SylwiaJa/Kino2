import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Movie implements Serializable {
    private  String tytul;
    private LocalDate dzien;
    private LocalTime godzina;
    private  Integer ograniczeniaWiekowe;
    private HashMap<Character, HashMap<Integer,Boolean>> liczbaMiejsc;

    public Movie(String tytul, LocalDate dzien, LocalTime godzina, Integer ograniczeniaWiekowe, HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public LocalDate getDzien() {
        return dzien;
    }

    public void setDzien(LocalDate dzien) {
        this.dzien = dzien;
    }

    public LocalTime getGodzina() {
        return godzina;
    }

    public void setGodzina(LocalTime godzina) {
        this.godzina = godzina;
    }

    public Integer getOgraniczeniaWiekowe() {
        return ograniczeniaWiekowe;
    }

    public void setOgraniczeniaWiekowe(Integer ograniczeniaWiekowe) {
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    @Override
    public String toString() {
        return tytul + ";"+
              dzien +";"+
                godzina +";"+
                 ograniczeniaWiekowe +";"+
                liczbaMiejsc;

    }
    public String toDisplay(){
        return
                "Tytul: " + tytul + '\n' +
                        "Data: " + dzien + '\n'+
                        "Godzina: " + godzina +'\n'+
                        "Ograniczenia wiekowe: " + ograniczeniaWiekowe +'\n';
    }
    public void displayCinemaRoom(){
        System.out.println("Tytuł: "+tytul+"   Data: "+dzien+"   Godzina: "+godzina+"   Wiek: "+ograniczeniaWiekowe);
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (Map.Entry<Character,HashMap<Integer,Boolean>> row:liczbaMiejsc.entrySet()) {
            char keyRow=row.getKey();
            System.out.print(keyRow);
            HashMap<Integer,Boolean> seats=row.getValue();
            for (Map.Entry<Integer,Boolean> seat:seats.entrySet()) {
                int keySeat= seat.getKey();
                boolean valueSeat=seat.getValue();
                if (valueSeat)
                    System.out.print(" *");
                else
                    System.out.print(" X");
            }
            System.out.println();
        }

    }
  //  public void reservation(char row, int seat) {
   //     HashMap<Integer, Boolean> rowMap = new HashMap<>(liczbaMiejsc.get(row)); // Tworzenie kopii rowMap
    //    rowMap.put(seat, false);
   //     liczbaMiejsc.put(row, rowMap);
   // }

}
