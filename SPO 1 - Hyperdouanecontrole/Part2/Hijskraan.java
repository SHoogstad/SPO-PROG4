package Part2;

import Part1.Container;
import Part2.Kade.*;

import static Part2.Schip.addContainer;
import Part2.Kade;
public class Hijskraan extends Thread {
    private String naam;
    private Kade kade;

    public Hijskraan(String naam, Kade kade) {
        this.naam = naam;
        this.kade = kade;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simuleer het hijsen van een container
                int sleepTime = (1000 + (int) (Math.random() * 6000)); // Willekeurige tijd tussen 1 en 3 seconden

                Container container = kade.getContainer(); // container ophalen van de kade

                /*if(container == null){
                    throw new InterruptedException();
                }*/

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
