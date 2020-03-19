package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String coordinates="(" + this.x + "," + this.y + ")";
        return coordinates;
    }

    public boolean precedes(Vector2d other) {
        return ((this.x <= other.x) && (this.y <= other.y));
    }

    public boolean follows(Vector2d other) { return ((this.x >= other.x) && (this.y >= other.y)); }

    public Vector2d upperRight(Vector2d other) {
        Vector2d upper= new Vector2d(this.x > other.x ? this.x : other.x, this.y > other.y ? this.y : other.y);
        return upper;
    }

    public Vector2d lowerLeft(Vector2d other){
        Vector2d lower= new Vector2d(this.x < other.x ? this.x : other.x , this.y < other.y ? this.y : other.y);
        return lower;
    }

    public Vector2d add(Vector2d other){
        Vector2d sum=new Vector2d (this.x+other.x , this.y+other.y);
        return sum;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d subtraction=new Vector2d(this.x - other.x , this.y - other.y);
        return subtraction;
    }

    public boolean equals(Vector2d other){
        if(other==null) return false;
        if(other==this) return true;
        if(!(other instanceof Vector2d)) return false;

        Vector2d toEqual=(Vector2d)other;
        return ((this.x==toEqual.x) && (this.y==toEqual.y));
    }

    public Vector2d opposite(){
        Vector2d oppVector= new Vector2d(-this.x, -this.y);
        return oppVector;
    }
}
