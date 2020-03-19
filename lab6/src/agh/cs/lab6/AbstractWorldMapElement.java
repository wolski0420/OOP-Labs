package agh.cs.lab6;

public abstract class AbstractWorldMapElement {
    protected Vector2d position;

    public Vector2d getPosition(){
        return this.position;
    }

    public abstract String toString();
}
