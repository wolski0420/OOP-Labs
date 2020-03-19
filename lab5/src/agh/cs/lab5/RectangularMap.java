package agh.cs.lab5;
import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap{

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
}


