package agh.cs.lab6;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    /** konstruktory */

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** metody */

    public String toString() { return "(" + this.x + "," + this.y + ")"; }

    public boolean precedes(Vector2d other) { return ((this.x <= other.x) && (this.y <= other.y)); }

    public boolean follows(Vector2d other) { return ((this.x >= other.x) && (this.y >= other.y)); }

    public Vector2d upperRight(Vector2d other) { return new Vector2d(this.x > other.x ? this.x : other.x, this.y > other.y ? this.y : other.y); }

    public Vector2d lowerLeft(Vector2d other){ return new Vector2d(this.x < other.x ? this.x : other.x , this.y < other.y ? this.y : other.y); }

    public Vector2d add(Vector2d other){ return new Vector2d (this.x+other.x , this.y+other.y); }

    public Vector2d subtract(Vector2d other) { return new Vector2d(this.x - other.x , this.y - other.y); }

    public boolean equals(Object other){
        if(other==null) return false;
        if(other==this) return true;
        if(!(other instanceof Vector2d)) return false;

        Vector2d toEqual=(Vector2d)other;
        return ((this.x==toEqual.x) && (this.y==toEqual.y));
    }

    public Vector2d opposite(){ return new Vector2d(-this.x, -this.y); }

    public boolean isInRange(Vector2d start, Vector2d end){ return this.precedes(end) && this.follows(start); }

    @Override
    public int hashCode(){ return Objects.hash(x,y); }
}