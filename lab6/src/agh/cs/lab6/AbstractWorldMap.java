package agh.cs.lab6;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<Animal> listOfAnimals;
    protected HashMap<Vector2d,Animal> mapOfAnimals;

    /** metody */

    abstract public String toString();

    abstract public boolean canMoveTo(Vector2d position);

    abstract public Object objectAt(Vector2d position);

    public boolean isOccupied(Vector2d position){
        return this.objectAt(position)!=null;
    };

    public void place(Animal animal) throws IllegalArgumentException{
        if (this.canMoveTo(animal.getPosition())){
            this.mapOfAnimals.put(animal.getPosition(),animal);
            this.listOfAnimals.add(animal);
        }
        else throw new IllegalArgumentException(animal.getPosition().toString() + " is now occupied!");
    }

    public void run (MoveDirection[] directions){
        if (directions==null) {
            System.out.println("Brak ruchow!");
            return;
        }

        for(int i=0; i<directions.length; i++){
            int size=this.listOfAnimals.size();
            Animal animalToRun=this.listOfAnimals.get(i%size);
            Vector2d animalPosition=animalToRun.getPosition();

            this.mapOfAnimals.remove(animalPosition);
            animalToRun.move(directions[i]);
            animalPosition=animalToRun.getPosition();
            this.mapOfAnimals.put(animalPosition,animalToRun);
        }
    }
}
