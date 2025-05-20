package Part2;

import Part1.Container;

import java.util.List;

public class Schip {
    private static List<Container> schip;

    public static void addContainer(Container c){
        schip.add(c);
    }

    public static Container getContainer(){
        if(schip.isEmpty()){
            return null;
        }
        return schip.getFirst();
    }

    public static int getSize(){
        return schip.size();
    }

    public void print(){
        System.out.println(schip);
    }
}
