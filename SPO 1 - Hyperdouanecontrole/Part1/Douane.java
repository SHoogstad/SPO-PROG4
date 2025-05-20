package Part1;

import Part2.Kade;

import java.util.List;

import static Part2.Kade.addContainer;

public class Douane extends Thread {
    private List<Vrachtwagen> wachtrij;

    public Douane(List<Vrachtwagen> wachtrij) {
        this.wachtrij = wachtrij;
    }

    @Override
    public void run() {
        for (Vrachtwagen vrachtwagen : wachtrij) {
            Container container = vrachtwagen.getContainer();
            if (!checkContainer(container)) {
                synchronized (System.out) {
                    System.out.println("❌ Container " + container.getID() + " inhoud: " + container.getInhoud());
                }
            }else{
                addContainer(container);
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
