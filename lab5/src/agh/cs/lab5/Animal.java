package agh.cs.lab5;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction;
    private IWorldMap fields;

    /** konstruktory */

    public Animal(IWorldMap fields){
        this.position =new Vector2d(0,0);
        this.direction=MapDirection.NORTH;
        this.fields = fields;
    }

    public Animal(IWorldMap fields, Vector2d initialPosition){
        this.position =initialPosition;
        this.direction=MapDirection.NORTH;
        this.fields = fields;
    }

    public Animal(IWorldMap fields, Vector2d initialPosition, MapDirection direction){
        this.position =initialPosition;
        this.direction=direction;
        this.fields = fields;
    }

    /** metody */

    public MapDirection getDirection(){
        return this.direction;
    }

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
            if (this.fields.canMoveTo(this.position.add(this.direction.toUnitVector()))){
                this.position =this.position.add(this.direction.toUnitVector());
                System.out.println("Ruch do przodu");
            }

        if(direction==MoveDirection.BACKWARD)
            if (this.fields.canMoveTo(this.position.subtract(this.direction.toUnitVector()))){
                this.position =this.position.subtract(this.direction.toUnitVector());
                System.out.println("Ruch do tylu");
            }

        System.out.println(this.position);
        System.out.println(this.direction);
    }
}