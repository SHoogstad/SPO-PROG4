package Part2;

import Part1.Container;

import java.util.List;

public class Schip {
    private static List<Container> schip = new java.util.LinkedList<Container>();

    public static void addContainer(Container c){
        schip.add(c);
    }

    public Container getContainer(){
        while (schip.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e) {
            }
        }
        Container container = schip.getFirst();
        schip.removeFirst();
        return container;
    }

    public static int getSize(){
        return schip.size();
    }

    public void print(){
        System.out.println(schip);
    }
}
