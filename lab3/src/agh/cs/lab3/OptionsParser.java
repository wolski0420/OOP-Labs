package agh.cs.lab3;
import java.util.ArrayList;

public class OptionsParser {
    public ArrayList<MoveDirection> parser(String[] strings){

        ArrayList<MoveDirection> directions=new ArrayList<MoveDirection>();

        for(int i=0; i<strings.length; i++) {
            if(strings[i].equals("f") || strings[i].equals("forward")) directions.add(MoveDirection.FORWARD);
            if(strings[i].equals("b") || strings[i].equals("backward")) directions.add(MoveDirection.BACKWARD);
            if(strings[i].equals("l") || strings[i].equals("left")) directions.add(MoveDirection.LEFT);
            if(strings[i].equals("r") || strings[i].equals("right")) directions.add(MoveDirection.RIGHT);
        }

        return directions;
    }
}
