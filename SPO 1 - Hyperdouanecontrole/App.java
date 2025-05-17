/**
 * TINPRO04-4 Les 5
 * SPO 1 - Hyperdouanecontrole
 * 20240426 // m.skelo@hr.nl
 */

import Part1.Container;
import Part1.Douane;
import Part1.Vrachtwagen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        List<String> lines;
        List<Vrachtwagen> kade = new ArrayList<>();

        // Input lezen uit bestand
        try {
            lines = Files.readAllLines(Paths.get("SPO 1 - Hyperdouanecontrole/Part1/input.txt"));
        } catch (IOException e) {
            System.out.println("Fout bij lezen van input.txt");
            e.printStackTrace();
            return;
        }

        // Regels parsen naar Vrachtwagens
        for (String line : lines) {
            String[] delen = line.split(" / ");
            if (delen.length == 3) {
                String kenteken = delen[0];
                int id = Integer.parseInt(delen[1]);
                String inhoud = delen[2];
                Container container = new Container(id, inhoud);
                Vrachtwagen vrachtwagen = new Vrachtwagen(kenteken, container);
                kade.add(vrachtwagen);
            }
        }

        // Instellingen voor verdeling
        final int MAX_VRACHTWAGENS_PER_RIJ = 5;
        final int AANTAL_VRACHTWAGENS = kade.size();
        final int RIJSTROKEN = (int) Math.ceil((double) AANTAL_VRACHTWAGENS / MAX_VRACHTWAGENS_PER_RIJ);

        // Threads aanmaken en starten
        List<Thread> douanes = new ArrayList<>();

        for (int i = 0; i < RIJSTROKEN; i++) {
            int begin = i * MAX_VRACHTWAGENS_PER_RIJ;
            int eind = Math.min(begin + MAX_VRACHTWAGENS_PER_RIJ, kade.size());
            List<Vrachtwagen> deel = kade.subList(begin, eind);
            Douane d = new Douane(deel);
            douanes.add(d);
        }

        // Wachten op alle douanes
        for (Thread d : douanes) {
            try {
                d.start();
                d.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("✅ Alle vrachtwagens zijn gecontroleerd.");
    }
}
