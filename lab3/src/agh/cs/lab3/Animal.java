package agh.cs.lab3;

public class Animal {
    private MapDirection direction;
    private Vector2d location;

    public Animal(){
        this.direction=MapDirection.NORTH;
        this.location=new Vector2d(2,2);
    }

    public String toString(){
        String information=new String("Location: " + this.location.toString() + "  Direction: " + this.direction.toString());
        return information;
    }

    public void move(MoveDirection direction){
        if(direction==MoveDirection.LEFT) this.direction=this.direction.previous();
        if(direction==MoveDirection.RIGHT) this.direction=this.direction.next();
        Vector2d leftLowerCorner=new Vector2d(0,0);
        Vector2d rightUpperCorner=new Vector2d(4,4);
        if(direction==MoveDirection.FORWARD)
            if (this.location.add(this.direction.toUnitVector()).isInRange(leftLowerCorner,rightUpperCorner))
                this.location=this.location.add(this.direction.toUnitVector());
        if(direction==MoveDirection.BACKWARD)
            if (this.location.subtract(this.direction.toUnitVector()).isInRange(leftLowerCorner,rightUpperCorner))
                this.location=this.location.subtract(this.direction.toUnitVector());
    }
}