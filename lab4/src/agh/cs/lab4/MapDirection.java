package agh.cs.lab4;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString(){
        if(this==EAST) return "E";
        if(this==WEST) return "W";
        if(this==NORTH) return "N";
        if(this==SOUTH) return "S";
        return null;
    }

    public MapDirection next(){
        if(this==EAST) return MapDirection.SOUTH;
        if(this==SOUTH) return MapDirection.WEST;
        if(this==WEST) return MapDirection.NORTH;
        if(this==NORTH) return MapDirection.EAST;
        return null;
    }

    public MapDirection previous(){
        if(this==EAST) return MapDirection.NORTH;
        if(this==SOUTH) return MapDirection.EAST;
        if(this==WEST) return MapDirection.SOUTH;
        if(this==NORTH) return MapDirection.WEST;
        return null;
    }

    public Vector2d toUnitVector(){
        Vector2d versor=null;
        if(this==EAST) versor=new Vector2d(1,0);
        if(this==SOUTH) versor=new Vector2d(0,-1);
        if(this==WEST) versor=new Vector2d(-1,0);
        if(this==NORTH) versor=new Vector2d(0,1);
        return versor;
    }
}