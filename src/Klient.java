import java.io.Serializable;
import java.util.Collection;

public class Klient implements Serializable {
    private  String nazwisko;
    private  String imie;
    private  String email;
    private String telefon;
    private Seans seans;
    private Collection<String> miejsca;

    public Klient(String nazwisko, String imie, String email, String telefon, Seans seans, Collection<String> miejsca) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.email = email;
        this.telefon = telefon;
        this.seans = seans;
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

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public Collection<String> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(Collection<String> miejsca) {
        this.miejsca = miejsca;
    }
}
