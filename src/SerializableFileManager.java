import java.io.*;
import java.util.ArrayList;

public class SerializableFileManager {

    public static void writeToFile(ArrayList<Movie> movies)throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("movies.dat"));
        for(Movie movie:movies){
            out.writeObject(movie);
        }
        out.close();
    }
    public static ArrayList<Movie> readFromFile() throws IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("movies.dat"));
        ArrayList<Movie> movies = new ArrayList<>();
        while (true){
            try {
                Movie movie = (Movie) in.readObject();
                movies.add(movie);
            }catch (IOException e){
                break;
            }
            }
        return movies;
    }
}
