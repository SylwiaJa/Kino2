import java.util.List;


public class Client {
    private final String lastName;
    private final String name;
    private final String email;
    private final String phone;
    private final Movie movie;
    private final List<String> clientSeats;

    public Client(String lastName, String name, String email, String phone, Movie movie, List<String> clientSeats) {
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.movie = movie;
        this.clientSeats = clientSeats;
    }

    @Override
    public String toString() {
        String seats = "";
        for (String value : clientSeats) {
            seats += value + " ";
        }
        return "Nazwisko i Imię: " + lastName + "  " + name + ", Email: " + email + ", Telefon: " + phone + ";Film:  Tytuł: " + movie.getTitle() + ", Data: " +
                movie.getDay() + ", Godzina: " + movie.getHour() + ", Ograniczenie wiekowe: " + movie.getAgeRestriction() + ";Zarezerwowane miejsca(Rząd/Miejsce): " + seats;
    }
}
