package agh.cs.lab5;

public class Grass extends AbstractWorldMapElement{

    /** konstruktory */

    public Grass(Vector2d position){
        this.position=position;
    }

    /** metody */

    public String toString(){
        return "*";
    }
}