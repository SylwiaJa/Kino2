import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Movie implements Serializable {
    private String title;
    private LocalDate day;
    private LocalTime hour;
    private Integer ageRestriction;
    private HashMap<Character, HashMap<Integer, Boolean>> numberOfSeats;

    public Movie(String title, LocalDate day, LocalTime hour, Integer ageRestriction, HashMap<Character, HashMap<Integer, Boolean>> numberOfSeats) {
        this.title = title;
        this.day = day;
        this.hour = hour;
        this.ageRestriction = ageRestriction;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Tytul: " + title + ", Data: " + day + ", Godzina: " + hour + ", Wiek: " + ageRestriction;

    }

    public void displayCinemaRoom() {
        System.out.println("Tytuł: " + title + "   Data: " + day + "   Godzina: " + hour + "   Wiek: " + ageRestriction);
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (Map.Entry<Character, HashMap<Integer, Boolean>> row : numberOfSeats.entrySet()) {
            char keyRow = row.getKey();
            System.out.print(keyRow);
            HashMap<Integer, Boolean> seats = row.getValue();
            for (Map.Entry<Integer, Boolean> seat : seats.entrySet()) {
                int keySeat = seat.getKey();
                boolean valueSeat = seat.getValue();
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
