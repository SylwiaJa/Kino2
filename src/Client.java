import java.util.Map;

public class Client {
    private  String lastName;
    private  String name;
    private  String email;
    private String phone;
    private Movie movie;
    private Map<Character, Integer> clientSeats;

    public Client(String lastName, String name, String email, String phone, Movie movie, Map<Character, Integer> clientSeats) {
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.movie = movie;
        this.clientSeats = clientSeats;
    }

    @Override
    public String toString() {
        String seats="";
        for (Map.Entry<Character, Integer> clientSeat: clientSeats.entrySet()) {
            seats = seats + (clientSeat.getKey() + "/" + clientSeat.getValue() + " ");
        }
        return "Nazwisko i Imię: " + lastName+ "  "+name+" Email: "+ email+" Telefon: "+phone+"  -  Film:  Tytuł: "+movie.getTitle()+" Data: "+
        movie.getDay()+" Godzina: "+movie.getHour()+" Ograniczenie wiekowe: "+movie.getAgeRestriction()+" Zarezerwowane miejsca(Rząd/Miejsce): "+seats;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Movie getSeans() {
        return movie;
    }

    public void setSeans(Movie movie) {
        this.movie = movie;
    }


}
