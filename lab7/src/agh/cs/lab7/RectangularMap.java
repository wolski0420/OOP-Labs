package agh.cs.lab7;
import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap{
    private Vector2d leftLowerCorner;
    private Vector2d rightUpperCorner;

    /** konstruktory */

    public RectangularMap(){                                        // z poprzednich labow
        this.mapOfAnimals =new HashMap<>();
        this.listOfAnimals=new ArrayList<>();
        this.leftLowerCorner=new Vector2d(0,0);
        this.rightUpperCorner =new Vector2d(4,4);              // przykladowe dane dla zwyklego konstruktora
    }

    public RectangularMap(int width, int height){
        this.mapOfAnimals =new HashMap<>();
        this.listOfAnimals=new ArrayList<>();
        this.leftLowerCorner=new Vector2d(0,0);
        this.rightUpperCorner =new Vector2d(width,height);
    }

    /** metody */

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(this.leftLowerCorner) && position.precedes(this.rightUpperCorner) && !isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position){
        return this.mapOfAnimals.get(position);
    }

    @Override
    public String toString(){
        return new MapVisualizer(this).draw(this.leftLowerCorner, this.rightUpperCorner);
    }

}


