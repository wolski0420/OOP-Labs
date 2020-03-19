package agh.cs.lab5;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;


public class GrassField extends AbstractWorldMap {
    private int numberOfFields;

    private HashMap<Vector2d,Grass> mapOfGrass;

    /** konstruktory */

    public GrassField(int numberOfFields){
        this.numberOfFields=numberOfFields;
        this.listOfAnimals=new ArrayList<>();
        this.mapOfAnimals=new HashMap<>();
        this.mapOfGrass=new HashMap<>();
        this.leftLowerCorner=new Vector2d(0,0);
        this.plantGrass();
    }

    /** metody */

    private void plantGrass(){                                          // sadzi losowo trawe
        int planted=0;
        int boundary=(int)Math.sqrt(this.numberOfFields*10);
        this.rightUpperCorner=this.leftLowerCorner;

        while(planted<this.numberOfFields) {                            // petla sadzi tak dlugo ile jest kepek

            Random randFunction = new Random();
            int posX = randFunction.nextInt(boundary + 1);
            int posY = randFunction.nextInt(boundary + 1);
            Vector2d positionToPlant = new Vector2d(posX, posY);

            if (!isOccupied(positionToPlant)) {
                Grass grassToPlant = new Grass(positionToPlant);
                mapOfGrass.put(positionToPlant, grassToPlant);          // sadzi kepki trawy
                planted++;

                this.rightUpperCorner=this.rightUpperCorner.upperRight(positionToPlant);  // dynamiczne szukanie granicy
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
    public boolean canMoveTo(Vector2d position){                        // nadpisuje aby sprawdzalo tez dla trawy
        return position.follows(leftLowerCorner)
                && position.precedes(rightUpperCorner)
                && !isOccupiedByAnimal(position);
    }

    @Override
    public boolean isOccupied(Vector2d position){                       // nadpisuje aby sprawdzalo tez dla trawy
        return this.mapOfAnimals.containsKey(position)
                || this.mapOfGrass.containsKey(position);
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
}