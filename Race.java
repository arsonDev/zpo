import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class Race {
    List<Cyclist> raceResults = new ArrayList<>();
    int currentCyclistOnRun = 0, currentCyclistEndRun = 0, currentWait = 0;
    boolean raceInProgress = true;

    public Race(CyclistList raceCyclists, int cyclistOnRace) throws InterruptedException {
        ScheduledExecutorService raceStart = Executors.newScheduledThreadPool(cyclistOnRace);
        ScheduledFuture<?> schedule1 = null;

        try {
            Runnable start = () -> {
                System.out.println(raceCyclists.cyclists.get(currentCyclistOnRun).startRace());
                Logger.getLogger(Main.class.getName()).fine(raceCyclists.cyclists.get(currentCyclistOnRun).startRace());
                currentCyclistOnRun++;

                try {
                    Thread.sleep((long) ((raceCyclists.cyclists.get(currentCyclistEndRun).cyclistTime / 25.00) * 1000));
                    currentWait++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(raceCyclists.cyclists.get(currentCyclistEndRun).stopRace());
                Logger.getLogger(Main.class.getName()).fine(raceCyclists.cyclists.get(currentCyclistEndRun).stopRace());
                raceResults.add(raceCyclists.cyclists.get(currentCyclistEndRun));
                this.showRaceResults(true);
                currentCyclistEndRun++;

                if (currentCyclistEndRun >= cyclistOnRace) {
                    raceInProgress = false;
                }
            };

            for (int i = 0; i < cyclistOnRace; i++) {
                schedule1 = raceStart.schedule(start, 0, TimeUnit.MILLISECONDS);
                try {
                    Thread.sleep((long) (60 / 25.00) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (true) {
                Thread.sleep(1000);
                if (raceInProgress == false) {
                    schedule1.cancel(true);
                    raceStart.shutdown();
                    break;
                }
            }

        } finally {
            schedule1.cancel(true);
            raceStart.shutdown();
        }
    }

    public synchronized void showRaceResults(boolean inline) {
        raceResults.sort(Comparator.comparing(Cyclist::getCyclistTime));
        Iterator value = raceResults.iterator();

        int position = 1;
        while (inline && value.hasNext() && position <= 3) {
            System.out.print(position + ". " + value.next() + " | ");
            position++;
        }
        while (!inline && value.hasNext()) {
            System.out.println(position + ". " + value.next());
            position++;
        }
        System.out.println();
    }
}
