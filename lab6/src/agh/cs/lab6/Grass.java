package agh.cs.lab6;

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