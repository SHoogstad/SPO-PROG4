package Part1;

import Part2.Kade;

import java.util.List;


public class Douane extends Thread {
    private List<Vrachtwagen> wachtrij;
    private Kade kade;

    public Douane(List<Vrachtwagen> wachtrij, Kade kade) {
        this.wachtrij = wachtrij;
        this.kade = kade;
    }

    @Override
    public void run() {
        for (Vrachtwagen vrachtwagen : wachtrij) {
            Container container = vrachtwagen.getContainer();
            if (checkContainer(container)) {
                    System.out.println("❌ Container " + container.getID() + " inhoud: " + container.getInhoud());
            }else{
                kade.addContainer(container);
            }
        }
    }

    public boolean checkContainer(Container c) {
        String inhoud = c.getInhoud();
        int som = 0;
        for (char ch : inhoud.toCharArray()) {
            som += (int) ch;
        }
        return (som % 17 < 2); // All hail the magic numbers
    }
}
