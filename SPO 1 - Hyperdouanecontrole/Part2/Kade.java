package Part2;

import Part1.Container;

import java.util.List;

public class Kade {
    private static List<Container> kade = new java.util.LinkedList<Container>();

    synchronized public void addContainer(Container c){
        try {
            notify();
        }catch (Exception e) {
            System.out.println("Fout bij het toevoegen van de container: " + e.getMessage());
        }
        System.out.println("Het toevoegen van de container: " + c);
        kade.add(c);
    }

    synchronized public Container getContainer(){
        while (kade.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
            }
        }
        Container container = kade.getFirst();
        kade.removeFirst();
        notifyAll();
        return container;
    }

    synchronized public static int getSize(){
        return kade.size();
    }

    public void print(){
        System.out.println(kade);
    }
}
