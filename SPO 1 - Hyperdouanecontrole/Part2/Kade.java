package Part2;

import Part1.Container;

import java.util.List;

public class Kade {
    private static List<Container> kade;

    synchronized public static void addContainer(Container c){
        kade.add(c);
    }

    synchronized public static Container getContainer(){
        if(kade.isEmpty()){
            return null;
        }
       return kade.getFirst();
    }

    synchronized public static int getSize(){
        return kade.size();
    }

    public void print(){
        System.out.println(kade);
    }
}
