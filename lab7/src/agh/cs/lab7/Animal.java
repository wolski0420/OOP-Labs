package agh.cs.lab7;

import java.util.ArrayList;

public class Animal implements IWorldMapElement {
    private Vector2d position;
    private MapDirection direction;
    private IWorldMap fields;
    protected ArrayList<IPositionChangeObserver> listOfObservers;

    /** konstruktory */

    public Animal(IWorldMap fields){
        this.listOfObservers = new ArrayList<>();
        this.position =new Vector2d(0,0);
        this.direction=MapDirection.NORTH;
        this.fields = fields;
    }

    public Animal(IWorldMap fields, Vector2d initialPosition){
        this.listOfObservers = new ArrayList<>();
        this.position =initialPosition;
        this.direction=MapDirection.NORTH;
        this.fields = fields;
    }

    public Animal(IWorldMap fields, Vector2d initialPosition, MapDirection direction){
        this.listOfObservers = new ArrayList<>();
        this.position =initialPosition;
        this.direction=direction;
        this.fields = fields;
    }

    /** metody */

    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return this.direction.toString();
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    public void move (MoveDirection direction){
        if(direction==MoveDirection.LEFT) {
            this.direction=this.direction.previous();
            //System.out.println("Obrot w lewo");

        }
        if(direction==MoveDirection.RIGHT){
            this.direction=this.direction.next();
            //System.out.println("Obrot w prawo");
        }

        if(direction==MoveDirection.FORWARD) {
            Vector2d checkPosition = this.position.add(this.direction.toUnitVector());
            if (this.fields.canMoveTo(checkPosition)) {
                Vector2d oldPosition=this.getPosition();
                this.position = checkPosition;
                this.positionChanged(oldPosition);
                //System.out.println("Ruch do przodu");
            }
        }

        if(direction==MoveDirection.BACKWARD) {
            Vector2d checkPosition = this.position.subtract(this.direction.toUnitVector());
            if (this.fields.canMoveTo(checkPosition)) {
                Vector2d oldPosition=this.getPosition();
                this.position = checkPosition;
                this.positionChanged(oldPosition);
                //System.out.println("Ruch do tylu");
            }
        }

        //System.out.println(this.position);
        //System.out.println(this.direction);
    }

    public void positionChanged(Vector2d lastPosition){
        for(IPositionChangeObserver observer : this.listOfObservers){
            observer.positionChanged(lastPosition,this.getPosition());
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.listOfObservers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.listOfObservers.remove(observer);
    }
}