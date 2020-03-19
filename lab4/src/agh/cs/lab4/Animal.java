package agh.cs.lab4;

import java.util.Map;

public class Animal {
    private MapDirection direction;
    private Vector2d location;
    private IWorldMap map;

    /** konstruktory */

    public Animal(){
        this.location=new Vector2d(2,2);
        this.direction=MapDirection.NORTH;
        this.map=null;
    }

    public Animal(IWorldMap map){
        this.location=null;
        this.direction=MapDirection.NORTH;
        this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.location=initialPosition;
        this.direction=MapDirection.NORTH;
        this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection direction){
        this.location=initialPosition;
        this.direction=direction;
        this.map=map;
    }

    /** metody */

    public void setPosition(Vector2d position) { this.location=position; }

    public Vector2d getPosition(){
        return this.location;
    }

    public MapDirection getDirection(){ return this.direction; }

    public String toString(){
        return new String(this.direction.toString());
    }

    public void move (MoveDirection direction){
        if(direction==MoveDirection.LEFT) {
            this.direction=this.direction.previous();
            System.out.println("Obrot w lewo");

        }
        if(direction==MoveDirection.RIGHT){
            this.direction=this.direction.next();
            System.out.println("Obrot w prawo");
        }

        if(direction==MoveDirection.FORWARD)
            if (this.map.canMoveTo(this.location.add(this.direction.toUnitVector()))){
                this.location=this.location.add(this.direction.toUnitVector());
                System.out.println("Ruch do przodu");
            }

        if(direction==MoveDirection.BACKWARD)
            if (this.map.canMoveTo(this.location.subtract(this.direction.toUnitVector()))){
                this.location=this.location.subtract(this.direction.toUnitVector());
                System.out.println("Ruch do tylu");
            }

        System.out.println(this.location);
        System.out.println(this.direction);
    }
}