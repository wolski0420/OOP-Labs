package agh.cs.lab7;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private SortedSet<Vector2d> setOrderX;
    private SortedSet<Vector2d> setOrderY;

    public MapBoundary(){
        this.setOrderX=new TreeSet<Vector2d>(new ComparatorX());
        this.setOrderY=new TreeSet<Vector2d>(new ComparatorY());
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        setOrderX.remove(oldPosition);
        setOrderY.remove(oldPosition);
        setOrderX.add(newPosition);
        setOrderY.add(newPosition);
    }

    public void addElement(IWorldMapElement element){
        this.setOrderY.add(element.getPosition());
        this.setOrderX.add(element.getPosition());
    }

    public Vector2d getLowerLeftBoundary(){
        return new Vector2d(this.setOrderX.first().x,this.setOrderY.first().y);
    }

    public Vector2d getUpperRightBoundary(){
        return new Vector2d(this.setOrderX.last().x,this.setOrderY.last().y);
    }
}
