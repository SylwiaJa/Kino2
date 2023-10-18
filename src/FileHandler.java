import java.io.*;

public class FileHandler {
    public static void addToFile(Object object, File fileName) throws IOException {
        FileWriter f = new FileWriter(fileName, true);
        try (BufferedWriter out = new BufferedWriter(f)) {
            out.write(object.toString());
            out.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void readFromFile(File fileName) {
        try {
            FileInputStream f = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(f);
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int i = 1;
            while ((strLine = r.readLine()) != null)
                System.out.println(i++ + ". " + strLine);
            in.close();
        } catch (IOException e) {
            System.out.println("Błąd dostępu do pliku");
        }
    }
}
