package agh.cs.lab5;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap{
    protected Vector2d leftLowerCorner;
    protected Vector2d rightUpperCorner;

    protected ArrayList<Animal> listOfAnimals;
    protected HashMap<Vector2d,Animal> mapOfAnimals;

    /** metody */

    public String toString(){
        return new MapVisualizer(this).draw(leftLowerCorner, rightUpperCorner);
    }

    public boolean canMoveTo(Vector2d position){
        return position.follows(leftLowerCorner) && position.precedes(rightUpperCorner) && !isOccupied(position);
    }

    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            mapOfAnimals.put(animal.getPosition(),animal);
            listOfAnimals.add(animal);
            return true;
        }
        return false;
    }

    public void run (MoveDirection[] directions){
        if (directions==null) {
            System.out.println("Brak ruchow!");
            return;
        }

        for(int i=0; i<directions.length; i++){
            int size=listOfAnimals.size();
            Vector2d animalPosition=listOfAnimals.get(i%size).getPosition();
            mapOfAnimals.remove(animalPosition);
            listOfAnimals.get(i%size).move(directions[i]);
            animalPosition=listOfAnimals.get(i%size).getPosition();
            mapOfAnimals.put(animalPosition,listOfAnimals.get(i%size));
        }
    }

    public boolean isOccupied(Vector2d position){
        return this.mapOfAnimals.containsKey(position);
    }

    public Object objectAt(Vector2d position){
        return this.mapOfAnimals.get(position);
    }
}
