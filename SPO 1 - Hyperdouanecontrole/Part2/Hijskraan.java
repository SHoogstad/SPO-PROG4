package Part2;

import Part1.Container;

import static Part2.Kade.getContainer;
import static Part2.Schip.addContainer;

public class Hijskraan extends Thread {
    private String naam;

    public Hijskraan(String naam) {
        this.naam = naam;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simuleer het hijsen van een container
                int sleepTime = (1000 + (int) (Math.random() * 6000)); // Willekeurige tijd tussen 1 en 3 seconden

                Container container = getContainer(); // container ophalen van de kade
                System.out.println(naam + " heeft een container " + container.getID() + " gehesen.");
                Thread.sleep(sleepTime); // sleep 1 tot 6 seconden

                addContainer(container); // container toevoegen aan schip
                System.out.println(naam + " heeft een container " + container.getID() + " op schip geplaatst.");

            } catch (InterruptedException e) {
                System.out.println(naam + " is gestopt.");
                break;
            }
        }
    }
}
