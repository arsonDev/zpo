import java.util.Random;

public class Cyclist implements Comparable<Cyclist> {
    String cyclistSurname;
    int cyclistTime;
    int maxRaceTime = 370;
    int minRaceTime = 250;

    public Cyclist(String cyclistSurname) {
        this.cyclistSurname = cyclistSurname;
        this.cyclistTime = raceTime();
    }

    public String startRace() {
        return this.cyclistSurname + " rozpoczyna swoja jazde";
    }

    public String stopRace() {
        return this.cyclistSurname + " zakonczy wyscig z czasem " + this.cyclistTime + "s";
    }

    private int raceTime() {
        Random czasWyscigu = new Random();
        int time = czasWyscigu.nextInt(500) + 1;
        if (time < this.minRaceTime) {
            return this.minRaceTime;
        } else if (time > this.maxRaceTime) {
            return this.maxRaceTime;
        } else {
            return time;
        }
    }

    public int getCyclistTime() {
        return this.cyclistTime;
    }

    @Override
    public String toString() {
        return this.cyclistSurname + " - " + this.cyclistTime;
    }

    @Override
    public int compareTo(Cyclist cyclist) {
        return this.cyclistTime - cyclist.cyclistTime;
    }
}
