package agh.cs.lab7;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
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

            animalToRun.move(directions[i]);
        }
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animalToChange=this.mapOfAnimals.get(oldPosition);
        this.mapOfAnimals.remove(oldPosition);
        this.mapOfAnimals.put(newPosition,animalToChange);
    };
}
