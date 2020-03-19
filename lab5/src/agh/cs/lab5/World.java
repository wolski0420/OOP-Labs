package agh.cs.lab5;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parser(args);
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}

