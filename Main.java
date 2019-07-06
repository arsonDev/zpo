import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.HashSet;
import java.util.logging.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Logger logger = null;
        try {
            Handler fh = new FileHandler("./race.log", false);
            logger = Logger.getLogger(Main.class.getName());
            logger.addHandler(fh);
            logger.setLevel(Level.FINE);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        int cyclistCount = 15;

        CyclistName list = GetCyc
        CyclistList raceCyclists = new CyclistList(surnameList.surname, cyclistOnRace);

        System.out.println(raceCyclists.cyclists);

        System.out.println("Start race");
        logger.fine("Start race");

        Race race = new Race(raceCyclists, cyclistOnRace);

        System.out.println("End race");
        logger.fine("End race");

        race.showRaceResults(false);
        System.out.println(race.raceResults);
    }

    private static HashSet<String> GetCyclistName() throws IOException {
        HashSet<String> list = new HashSet<>();
        URL surnameUrl = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt");
        BufferedReader readSurnames = new BufferedReader(new InputStreamReader(surnameUrl.openStream()));

        String surnameFromFile;
        while ((surnameFromFile = readSurnames.readLine()) != null) {
            list.add(surnameFromFile);
        }
        readSurnames.close();
        return list;
    }
}