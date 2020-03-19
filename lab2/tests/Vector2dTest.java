import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab2.Vector2d;

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
        Vector2d thirdVector=firstVector.upperRight(secondVector);
        Assert.assertEquals("(4,4)",thirdVector.toString());
    }

    @Test
    public void lowerLeftTest(){
        Vector2d firstVector=new Vector2d(3,4);
        Vector2d secondVector=new Vector2d(4,3);
        Vector2d thirdVector=firstVector.lowerLeft(secondVector);
        Assert.assertEquals("(3,3)",thirdVector.toString());
    }

    @Test
    public void addTest(){
        Vector2d firstVector=new Vector2d(1,5);
        Vector2d secondVector=new Vector2d(6,2);
        Vector2d thirdVector=firstVector.add(secondVector);
        Assert.assertEquals("(7,7)",thirdVector.toString());
    }

    @Test
    public void subtractTest(){
        Vector2d firstVector=new Vector2d(6,5);
        Vector2d secondVector=new Vector2d(1,2);
        Vector2d thirdVector=firstVector.subtract(secondVector);
        Assert.assertEquals("(5,3)",thirdVector.toString());
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
        Vector2d secondVector=firstVector.opposite();
        Assert.assertEquals("(-4,-7)",secondVector.toString());
    }
}
