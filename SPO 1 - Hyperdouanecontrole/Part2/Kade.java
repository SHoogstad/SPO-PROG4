package Part2;

import Part1.Container;

import java.util.List;

public class Kade {
    private static List<Container> kade = new java.util.LinkedList<Container>();

    synchronized public static void addContainer(Container c){
        kade.add(c);
    }

    synchronized public static Container getContainer(){
        if(kade.isEmpty()){
            return null;
        }
        Container container = kade.getFirst();
        kade.removeFirst();
        return container;
    }

    synchronized public static int getSize(){
        return kade.size();
    }

    public void print(){
        System.out.println(kade);
    }
}
