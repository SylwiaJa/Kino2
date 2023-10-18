import java.util.HashMap;

public class CinemaHall {
    public HashMap<Character, HashMap<Integer, Boolean>> numberOfSeats() {
        HashMap<Character, HashMap<Integer, Boolean>> seats = new HashMap<>();
        HashMap<Integer, Boolean> row = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            row.put(i, true);
        }
        for (int j = 0; j < 5; j++) {
            seats.put((char) (65 + j), row);
        }
        return seats;
    }
}
