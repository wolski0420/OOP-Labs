import agh.cs.lab7.*;
import org.junit.Test;
import org.junit.Assert;

public class AnimalTest {
    @Test
    public void getPositionTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal animalTest = new Animal(map, new Vector2d(7,2));

        Assert.assertEquals(animalTest.getPosition(),new Vector2d(7, 2));
        Assert.assertNotEquals(animalTest.getPosition(),new Vector2d(1,8));
    }

    @Test
    public void getDirectionTest(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal animalTest = new Animal(map, new Vector2d(7,2));

        Assert.assertEquals(animalTest.getDirection(), MapDirection.NORTH);
        Assert.assertNotEquals(animalTest.getDirection(), MapDirection.SOUTH);
        Assert.assertNotEquals(animalTest.getDirection(), MapDirection.WEST);
        Assert.assertNotEquals(animalTest.getDirection(), MapDirection.EAST);
    }

    @Test
    public void toStringTest(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal animalTest = new Animal(map, new Vector2d(7,2));

        Assert.assertEquals("N",animalTest.toString());
        Assert.assertNotEquals("S",animalTest.toString());
    }

    @Test
    public void moveTest(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map, new Vector2d(7,2), MapDirection.NORTH);

        Assert.assertEquals(animal.getDirection(),MapDirection.NORTH);

        // orientacja, skret w prawo
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getDirection(),MapDirection.EAST);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.WEST);
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getDirection(),MapDirection.SOUTH);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.NORTH);
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getDirection(),MapDirection.WEST);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.EAST);
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getDirection(),MapDirection.NORTH);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.SOUTH);

        // orientacja, skret w lewo
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getDirection(),MapDirection.WEST);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.EAST);
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getDirection(),MapDirection.SOUTH);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.NORTH);
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getDirection(),MapDirection.EAST);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.WEST);
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getDirection(),MapDirection.NORTH);
        Assert.assertNotEquals(animal.getDirection(),MapDirection.SOUTH);

        // przemieszczanie sie
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,1));
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,1));
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(6,3));
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(6,3));
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,2));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,4));
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,3));
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,3));
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(9,1));
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(9,1));
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,2));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,0));

        // wstecz
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,3));
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,3));
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(6,1));
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,1));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(6,1));
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,2));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,0));
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,1));
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(8,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(8,1));
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(9,3));
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,3));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(9,3));
        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(animal.getPosition(),new Vector2d(7,2));
        Assert.assertNotEquals(animal.getPosition(),new Vector2d(7,4));

        // wychodzenie po za mape
        Animal leftLower=new Animal(map,new Vector2d(0,0),MapDirection.SOUTH);      // ustawiam na rogach
        Animal leftUpper=new Animal(map,new Vector2d(0,5),MapDirection.NORTH);
        Animal rightUpper=new Animal(map,new Vector2d(10,5),MapDirection.NORTH);
        Animal rightLower=new Animal(map,new Vector2d(10,0),MapDirection.SOUTH);

        leftLower.move(MoveDirection.FORWARD);                                           // w dol i gore
        leftUpper.move(MoveDirection.FORWARD);
        rightUpper.move(MoveDirection.FORWARD);
        rightLower.move(MoveDirection.FORWARD);
        Assert.assertEquals(leftLower.getPosition(),new Vector2d(0,0));
        Assert.assertNotEquals(leftLower.getPosition(),new Vector2d(0,-1));
        Assert.assertEquals(leftUpper.getPosition(),new Vector2d(0,5));
        Assert.assertNotEquals(leftUpper.getPosition(),new Vector2d(0,6));
        Assert.assertEquals(rightUpper.getPosition(),new Vector2d(10,5));
        Assert.assertNotEquals(rightUpper.getPosition(),new Vector2d(10,6));
        Assert.assertEquals(rightLower.getPosition(),new Vector2d(10,0));
        Assert.assertNotEquals(rightLower.getPosition(),new Vector2d(10,-1));

        leftLower.move(MoveDirection.RIGHT);                                            // w lewo i prawo
        leftUpper.move(MoveDirection.LEFT);
        rightUpper.move(MoveDirection.RIGHT);
        rightLower.move(MoveDirection.LEFT);
        leftLower.move(MoveDirection.FORWARD);
        leftUpper.move(MoveDirection.FORWARD);
        rightUpper.move(MoveDirection.FORWARD);
        rightLower.move(MoveDirection.FORWARD);
        Assert.assertEquals(leftLower.getPosition(),new Vector2d(0,0));
        Assert.assertNotEquals(leftLower.getPosition(),new Vector2d(-1,0));
        Assert.assertEquals(leftUpper.getPosition(),new Vector2d(0,5));
        Assert.assertNotEquals(leftUpper.getPosition(),new Vector2d(-1,5));
        Assert.assertEquals(rightUpper.getPosition(),new Vector2d(10,5));
        Assert.assertNotEquals(rightUpper.getPosition(),new Vector2d(11,5));
        Assert.assertEquals(rightLower.getPosition(),new Vector2d(10,0));
        Assert.assertNotEquals(rightLower.getPosition(),new Vector2d(11,0));
    }
}
