package multithreading_and_concurrency.program_countdownlatch_race;

import java.io.IOException;

public class CDLApp {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Prepping...");
        Race race = new Race(
                "Beverly",
                "Rocker",
                "Phineas",
                "Ferb",
                "Tin",
                "Monkey",
                "Glue"
        );

        System.out.println("It's a race of " + race.getDistance() + " lengths");
        System.out.println("Press Enter to run the race....");
        System.in.read();

        race.run();
    }
}
