package agh.cs.lab1;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class World {
    private static void writer(Direction way){
        if(way==Direction.FORWARD) System.out.println("The animal is going forward");
        else if(way==Direction.BACK) System.out.println("The animal is going back");
        else if(way==Direction.LEFT) System.out.println("The animal is going left");
        else if(way==Direction.RIGHT) System.out.println("The animal is going right");
    }

    private static Direction convertion(String way){
        if(way.equals("f")) return Direction.FORWARD;
        if(way.equals("b")) return Direction.BACK;
        if(way.equals("l")) return Direction.LEFT;
        if(way.equals("r")) return Direction.RIGHT;
        return null;
    }

    private static List<Direction> stringToEnum(Direction[] directions, String[] args){
        return Arrays.stream(args).map(e->convertion(e)).collect(Collectors.toList());
    }

    private static void run(List<Direction> directions){
        directions.stream().forEach(d->{if(d!=null){writer(d);}});
    }

    public static void main(String[] args){
        System.out.println("Start");
        Direction[] directions=new Direction[args.length];
        run(stringToEnum(directions,args));
        System.out.println("End");
    }
}
