package agh.cs.lab2;

public class World {
    public static void main(String[] args){
        //sprawdzenie wedlug instrukcji
        Vector2d position1=new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2=new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));


        //wlasne sprawdzenie metod MapDirection
        MapDirection direction=MapDirection.NORTH;
        System.out.println(direction.toString());
        System.out.println(direction.next());
        System.out.println(direction.previous());
        Vector2d position3=direction.toUnitVector();
        System.out.println(position3.toString());
    }
}
