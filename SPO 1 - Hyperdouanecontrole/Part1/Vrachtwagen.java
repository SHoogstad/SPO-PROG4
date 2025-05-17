package Part1;

/**
 * TINPRO04-4 Les 5
 * SPO 1 - Hyperdouanecontrole
 * 20240422 // m.skelo@hr.nl
 */

public class Vrachtwagen {
    private String kenteken;
    private Container container;

    public Vrachtwagen(String kenteken, Container container) {
        this.kenteken = kenteken;
        this.container = container;
    }

    public String getKenteken() {
        return this.kenteken;
    }
    public Container getContainer() {
        return this.container;
    }
}
