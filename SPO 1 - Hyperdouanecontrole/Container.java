/**
 * TINPRO04-4 Les 5
 * SPO 1 - Hyperdouanecontrole
 * 20240422 // m.skelo@hr.nl
 */

public class Container {
    private int id;
    private String inhoud;
    public Container(int id, String inhoud) {
        this.id = id;
        this.inhoud = inhoud;
    }
    public int getID() {
        return this.id;
    }
    public String getInhoud() {
        return this.inhoud;
    }
}

