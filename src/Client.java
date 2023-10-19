import java.util.Collection;
import java.util.Map;

public class Client {
    private  String nazwisko;
    private  String imie;
    private  String email;
    private String telefon;
    private Movie movie;
    private Map<Character, Integer> miejsca;

    public Client(String nazwisko, String imie, String email, String telefon, Movie movie, Map<Character, Integer> miejsca) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.email = email;
        this.telefon = telefon;
        this.movie = movie;
        this.miejsca = miejsca;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Movie getSeans() {
        return movie;
    }

    public void setSeans(Movie movie) {
        this.movie = movie;
    }


}
