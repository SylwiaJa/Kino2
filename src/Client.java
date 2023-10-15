import java.io.Serializable;
import java.util.Collection;

public class Client implements Serializable {
    private  String nazwisko;
    private  String imie;
    private  String email;
    private String telefon;
    private Movie movie;
    private Collection<String> miejsca;

    public Client(String nazwisko, String imie, String email, String telefon, Movie movie, Collection<String> miejsca) {
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

    public Collection<String> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(Collection<String> miejsca) {
        this.miejsca = miejsca;
    }
}
