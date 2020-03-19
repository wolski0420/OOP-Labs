package agh.cs.lab7;

public class Grass implements IWorldMapElement {
    private Vector2d position;

    /** konstruktory */

    public Grass(Vector2d position){
        this.position=position;
    }

    /** metody */

    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return "*";
    }
}