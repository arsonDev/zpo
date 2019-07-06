import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.*;
import Cyclist;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Logger logger = null;
        try {
            Handler fh = new FileHandler("race.log", false);
            logger = Logger.getLogger(Main.class.getName());
            logger.addHandler(fh);
            logger.setLevel(Level.FINE);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        ArrayList<Cyclist> list = GetCyclistName();

        System.out.println(list);

        System.out.println("Start race");
        logger.fine("Start race");

        Race race = new Race(list, list.size());

        System.out.println("End race");
        logger.fine("End race");

        race.showRaceResults(false);
        System.out.println(race.raceResults);
    }

    private static ArrayList<Cyclist> GetCyclistName() throws IOException {
        HashSet<String> list = new HashSet<>();
        URL surnameUrl = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt");
        BufferedReader readSurnames = new BufferedReader(new InputStreamReader(surnameUrl.openStream()));

        String surnameFromFile;
        while ((surnameFromFile = readSurnames.readLine()) != null) {
            list.add(surnameFromFile);
        }
        readSurnames.close();

        ArrayList<Cyclist> endList = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < 15; i++) {
            int j = 0;
            int index = generator.nextInt(list.size());
            for (String item : list) {
                if (j == index)
                    endList.add(new Cyclist(item));
                j++;
            }
        }

        return endList;
    }
}