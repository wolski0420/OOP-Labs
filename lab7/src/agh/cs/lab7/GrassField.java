package agh.cs.lab7;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.util.Set;


public class GrassField extends AbstractWorldMap {
    private int numberOfFields;
    private HashMap<Vector2d,Grass> mapOfGrass;
    private MapBoundary boundaries;

    /** konstruktory */

    public GrassField(int numberOfFields){
        this.numberOfFields=numberOfFields;
        this.listOfAnimals=new ArrayList<>();
        this.mapOfAnimals=new HashMap<>();
        this.mapOfGrass=new HashMap<>();
        this.boundaries=new MapBoundary();
        this.plantGrass();
    }

    /** metody */

    private void plantGrass(){                                          // sadzi losowo trawe
        int planted=0;
        int boundary=(int)Math.sqrt(this.numberOfFields*10);

        while(planted<this.numberOfFields) {                            // petla sadzi tak dlugo ile jest kepek

            Random randFunction = new Random();
            int posX = randFunction.nextInt(boundary + 1);
            int posY = randFunction.nextInt(boundary + 1);
            Vector2d positionToPlant = new Vector2d(posX, posY);

            if (!isOccupied(positionToPlant)) {
                Grass grassToPlant = new Grass(positionToPlant);
                mapOfGrass.put(positionToPlant, grassToPlant);          // sadzi kepki trawy
                this.boundaries.addElement(grassToPlant);
                planted++;
            }
        }
    }

    public boolean isOccupiedByAnimal(Vector2d position){              // sprawdza tylko czy na pozycji jest zwierze
        return this.mapOfAnimals.containsKey(position);
    }

    public HashMap<Vector2d,Grass> getMapOfGrass(){                     // zwraca mape m.in. na cele testow
        return this.mapOfGrass;
    }

    @Override
    public boolean canMoveTo(Vector2d position){                        // nadpisuje aby nie sprawdzalo dla trawy
        return !isOccupiedByAnimal(position);
    }

    @Override
    public Object objectAt(Vector2d position){                          // nadpisuje aby sprawdzalo tez dla trawy
        Animal animalToReturn=this.mapOfAnimals.get(position);
        Grass grassToReturn=this.mapOfGrass.get(position);              // mniejsza liczba wywolan

        if(animalToReturn!=null)
            return animalToReturn;
        if(grassToReturn!=null)
            return grassToReturn;
        return null;
    }

    @Override
    public String toString(){
        return new MapVisualizer(this).
                draw(this.boundaries.getLowerLeftBoundary(), this.boundaries.getUpperRightBoundary());
    }

    @Override
    public void place(Animal animal){
        super.place(animal);
        this.boundaries.addElement(animal);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        this.boundaries.positionChanged(oldPosition, newPosition);
    }
}