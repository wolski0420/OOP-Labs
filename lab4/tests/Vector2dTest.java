import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab4.Vector2d;

public class Vector2dTest {
    @Test
    public void toStringTest(){
        Vector2d vector=new Vector2d(1,2);
        Assert.assertEquals("(1,2)", vector.toString() );
    }

    @Test
    public void precedesTest(){
        Vector2d firstVector=new Vector2d(3,4);
        Vector2d secondVector=new Vector2d(4,4);
        Assert.assertTrue(firstVector.precedes(secondVector));
        Assert.assertFalse(secondVector.precedes(firstVector));
    }

    @Test
    public void followsTest(){
        Vector2d firstVector=new Vector2d(3,4);
        Vector2d secondVector=new Vector2d(3,3);
        Assert.assertTrue(firstVector.follows(secondVector));
        Assert.assertFalse(secondVector.follows(firstVector));
    }

    @Test
    public void upperRightTest(){
        Vector2d firstVector=new Vector2d(3,4);
        Vector2d secondVector=new Vector2d(4,3);
        Vector2d thirdVector=new Vector2d(4,4);
        Vector2d fourthVector=new Vector2d(3,3);
        Assert.assertEquals(thirdVector,firstVector.upperRight(secondVector));
        Assert.assertNotEquals(fourthVector,firstVector.upperRight(secondVector));
    }

    @Test
    public void lowerLeftTest(){
        Vector2d firstVector=new Vector2d(3,4);
        Vector2d secondVector=new Vector2d(4,3);
        Vector2d thirdVector=new Vector2d(3,3);
        Vector2d fourthVector=new Vector2d(4,4);
        Assert.assertEquals(thirdVector,firstVector.lowerLeft(secondVector));
        Assert.assertNotEquals(fourthVector,firstVector.lowerLeft(secondVector));
    }

    @Test
    public void addTest(){
        Vector2d firstVector=new Vector2d(1,5);
        Vector2d secondVector=new Vector2d(6,2);
        Vector2d thirdVector=new Vector2d(7,7);
        Assert.assertEquals(thirdVector,firstVector.add(secondVector));
        Assert.assertNotEquals(firstVector,firstVector.add(secondVector));
    }

    @Test
    public void subtractTest(){
        Vector2d firstVector=new Vector2d(6,5);
        Vector2d secondVector=new Vector2d(1,2);
        Vector2d thirdVector=new Vector2d(5,3);
        Assert.assertEquals(thirdVector,firstVector.subtract(secondVector));
        Assert.assertNotEquals(firstVector,firstVector.subtract(secondVector));
    }

    @Test
    public void equalsTest(){
        Vector2d firstVector=new Vector2d(1,3);
        Vector2d secondVector=new Vector2d(1,3);

        Assert.assertFalse(firstVector.equals(null));
        Assert.assertTrue(firstVector.equals(firstVector));
        Assert.assertFalse(firstVector.equals("Test: GivingTheObjectOtherThanRequired"));
        Assert.assertTrue(firstVector.equals(secondVector));
    }

    @Test
    public void oppositeTest(){
        Vector2d firstVector=new Vector2d(4,7);
        Vector2d secondVector=new Vector2d(-4,-7);
        Assert.assertEquals(firstVector,secondVector.opposite());
        Assert.assertNotEquals(firstVector,firstVector.opposite());
    }

    @Test
    public void isInRange(){
        Vector2d firstVector=new Vector2d(6,6);
        Vector2d secondVector=new Vector2d(2,2);
        Vector2d thirdVector=new Vector2d(-2,-2);
        Vector2d leftLowerCorner=new Vector2d(0,0);
        Vector2d rightUpperCorner=new Vector2d(4,4);
        Assert.assertFalse(firstVector.isInRange(leftLowerCorner,rightUpperCorner));
        Assert.assertTrue(secondVector.isInRange(leftLowerCorner,rightUpperCorner));
        Assert.assertFalse(thirdVector.isInRange(leftLowerCorner,rightUpperCorner));
    }
}