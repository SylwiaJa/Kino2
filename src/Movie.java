import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

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
}
