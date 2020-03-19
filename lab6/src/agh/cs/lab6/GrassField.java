package agh.cs.lab6;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.util.Set;


public class GrassField extends AbstractWorldMap {
    private int numberOfFields;
    private HashMap<Vector2d,Grass> mapOfGrass;

    /** konstruktory */

    public GrassField(int numberOfFields){
        this.numberOfFields=numberOfFields;
        this.listOfAnimals=new ArrayList<>();
        this.mapOfAnimals=new HashMap<>();
        this.mapOfGrass=new HashMap<>();
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
        Vector2d virtualLeftLowerCorner=null;
        Vector2d virtualRightUpperCorner=null;
        Set<Vector2d> keyGrassSet=this.mapOfGrass.keySet();
        Set<Vector2d> keyAnimalSet=this.mapOfAnimals.keySet();

        if(keyGrassSet==null || keyAnimalSet==null) return null;

        for(Vector2d actualPosition : keyGrassSet){
            if(virtualLeftLowerCorner==null && virtualRightUpperCorner==null){
                virtualLeftLowerCorner=actualPosition;
                virtualRightUpperCorner=actualPosition;
            }
            else{
                virtualLeftLowerCorner=virtualLeftLowerCorner.lowerLeft(actualPosition);
                virtualRightUpperCorner=virtualRightUpperCorner.upperRight(actualPosition);
            }
        }

        for(Vector2d actualPosition : keyAnimalSet){
            if(virtualLeftLowerCorner==null && virtualRightUpperCorner==null){
                virtualLeftLowerCorner=actualPosition;
                virtualRightUpperCorner=actualPosition;
            }
            else{
                virtualLeftLowerCorner=virtualLeftLowerCorner.lowerLeft(actualPosition);
                virtualRightUpperCorner=virtualRightUpperCorner.upperRight(actualPosition);
            }
        }

        return new MapVisualizer(this).draw(virtualLeftLowerCorner, virtualRightUpperCorner);
    }
}