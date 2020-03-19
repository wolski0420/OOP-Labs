import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab6.MapDirection;
import agh.cs.lab6.Vector2d;

public class MapDirectionTest{
    @Test
    public void toStringTest(){
        Assert.assertEquals("E",MapDirection.EAST.toString());
        Assert.assertEquals("W",MapDirection.WEST.toString());
        Assert.assertEquals("N",MapDirection.NORTH.toString());
        Assert.assertEquals("S",MapDirection.SOUTH.toString());
        Assert.assertNotEquals("E",MapDirection.WEST.toString());
        Assert.assertNotEquals("W",MapDirection.NORTH.toString());
        Assert.assertNotEquals("N",MapDirection.SOUTH.toString());
        Assert.assertNotEquals("S",MapDirection.EAST.toString());
    }

    @Test
    public void nextTest(){
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assert.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        Assert.assertNotEquals(MapDirection.EAST,MapDirection.SOUTH.next());
        Assert.assertNotEquals(MapDirection.SOUTH,MapDirection.WEST.next());
        Assert.assertNotEquals(MapDirection.WEST,MapDirection.NORTH.next());
        Assert.assertNotEquals(MapDirection.NORTH,MapDirection.EAST.next());
    }

    @Test
    public void previousTest(){
        Assert.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        Assert.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        Assert.assertNotEquals(MapDirection.EAST,MapDirection.NORTH.previous());
        Assert.assertNotEquals(MapDirection.SOUTH,MapDirection.EAST.previous());
        Assert.assertNotEquals(MapDirection.WEST,MapDirection.SOUTH.previous());
        Assert.assertNotEquals(MapDirection.NORTH,MapDirection.WEST.previous());
    }

    @Test
    public void toUnitVector(){
        Assert.assertEquals(new Vector2d(1,0),MapDirection.EAST.toUnitVector());
        Assert.assertEquals(new Vector2d(0,1),MapDirection.NORTH.toUnitVector());
        Assert.assertEquals(new Vector2d(-1,0),MapDirection.WEST.toUnitVector());
        Assert.assertEquals(new Vector2d(0,-1),MapDirection.SOUTH.toUnitVector());

        Assert.assertNotEquals(new Vector2d(1,0),MapDirection.WEST.toUnitVector());
        Assert.assertNotEquals(new Vector2d(0,1),MapDirection.SOUTH.toUnitVector());
        Assert.assertNotEquals(new Vector2d(-1,0),MapDirection.EAST.toUnitVector());
        Assert.assertNotEquals(new Vector2d(0,-1),MapDirection.NORTH.toUnitVector());
    }
}