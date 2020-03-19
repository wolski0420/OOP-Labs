package agh.cs.lab6;
import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection [] parser(String[] strings) throws IllegalArgumentException{

        ArrayList<MoveDirection> directions=new ArrayList<MoveDirection>();

        for(int i=0; i<strings.length; i++) {
            if(strings[i].equals("f") || strings[i].equals("forward")) directions.add(MoveDirection.FORWARD);
            else if(strings[i].equals("b") || strings[i].equals("backward")) directions.add(MoveDirection.BACKWARD);
            else if(strings[i].equals("l") || strings[i].equals("left")) directions.add(MoveDirection.LEFT);
            else if(strings[i].equals("r") || strings[i].equals("right")) directions.add(MoveDirection.RIGHT);
            else throw new IllegalArgumentException(strings[i] + "is not legal move specification");
        }

        if(directions.size()==0) return null;

        MoveDirection[] directionsToReturn=new MoveDirection[directions.size()];
        for(int i=0; i<directions.size(); i++)
            directionsToReturn[i]=directions.get(i);


        directions.clear();
        directions=null;

        return directionsToReturn;
    }
}
