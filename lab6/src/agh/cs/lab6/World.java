package agh.cs.lab6;

public class World {
    public static void main(String[] args) {
        try{
            MoveDirection[] directions;
            IWorldMap map = new GrassField(10);
            directions = new OptionsParser().parser(args);
            map.place(new Animal(map));
            map.place(new Animal(map,new Vector2d(2,3)));
            map.run(directions);
            System.out.println(map);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}

