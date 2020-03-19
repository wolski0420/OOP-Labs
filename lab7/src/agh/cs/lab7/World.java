package agh.cs.lab7;

public class World {
    public static void main(String[] args) {
        try{
            MoveDirection[] directions;
            GrassField map = new GrassField(10);
            directions = new OptionsParser().parser(args);
            Animal animal1=new Animal(map);
            Animal animal2=new Animal(map,new Vector2d(2,3));

            map.place(animal1);
            map.place(animal2);
            animal1.addObserver(map);
            animal2.addObserver(map);

            map.run(directions);
            System.out.println(map);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}

