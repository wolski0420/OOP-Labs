import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab7.*;

public class RectangularMapTest {
    @Test
    public void canMoveTo(){
        RectangularMap square=new RectangularMap(5,5);

        Assert.assertTrue(square.canMoveTo(new Vector2d(3,4)));             // wykraczanie po za mape
        Assert.assertFalse(square.canMoveTo(new Vector2d(6,4)));
        Assert.assertFalse(square.canMoveTo(new Vector2d(4,6)));
        Assert.assertFalse(square.canMoveTo(new Vector2d(1,-2)));
        Assert.assertFalse(square.canMoveTo(new Vector2d(-1,2)));
        Assert.assertFalse(square.canMoveTo(new Vector2d(6,6)));
        Assert.assertFalse(square.canMoveTo(new Vector2d(-1,-1)));

        Animal animal=new Animal(square,new Vector2d(2,4));
        square.place(animal);                                                    // na zajete pola
        Assert.assertFalse(square.canMoveTo(new Vector2d(2,4)));
        Assert.assertTrue(square.canMoveTo(new Vector2d(3,5)));
    }

    @Test
    public void isOccupiedTest(){
        RectangularMap square=new RectangularMap(5,5);
        Animal animal=new Animal(square,new Vector2d(2,4));
        square.place(animal);
        Assert.assertTrue(square.isOccupied(new Vector2d(2,4)));
        Assert.assertFalse(square.isOccupied(new Vector2d(3,3)));
    }

    @Test
    public void objectAtTest(){
        RectangularMap square=new RectangularMap(5,5);
        Animal animal=new Animal(square,new Vector2d(2,4));
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(2,4)),animal);
    }

    @Test
    public void placeTest(){
        RectangularMap square=new RectangularMap(1,1);
        Animal animal=new Animal(square);                                           // wstawia na 0,0
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(0,0)),animal);

        animal=new Animal(square,new Vector2d(1,1));                           // wstawia na 1,1
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(1,1)),animal);

        animal=new Animal(square,new Vector2d(1,0));                           // proboje na 1,0
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal);

        animal=new Animal(square,new Vector2d(0,1));                           // wstawia na 0,1
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(0,1)),animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void placeTest2(){
        RectangularMap square=new RectangularMap(1,1);
        Animal animal=new Animal(square,new Vector2d(0,0));                           // wstawia na 0,0
        square.place(animal);
        Assert.assertEquals(square.objectAt(new Vector2d(0,0)),animal);

        animal=new Animal(square);                                                  // proboje wstawic na 0,0
        square.place(animal);
    }

    @Test
    public void runTest(){
        String [] words={"b","f","r","l","f","b","l","r","b","f"};                  // dla poprawnych danych
        MoveDirection[] directions = new OptionsParser().parser(words);
        RectangularMap square=new RectangularMap(3,3);
        Animal animal=new Animal(square,new Vector2d(0,1));
        Animal animal2=new Animal(square,new Vector2d(2,2));

        square.place(animal);
        square.place(animal2);
        animal.addObserver(square);
        animal2.addObserver(square);

        square.run(directions);                                                     // poruszanie sie dwóch na raz

        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal);
        Assert.assertEquals(square.objectAt(new Vector2d(3,3)),animal2);

        Animal animal3=new Animal(square,new Vector2d(1,1));
        square.place(animal3);
        animal3.addObserver(square);
        String [] words2={"f"};                                                     // proba wjechania na zajete pole
        MoveDirection[] directions2=new OptionsParser().parser(words2);
        square.run(directions2);

        Assert.assertNotEquals(square.objectAt(new Vector2d(1,0)),animal3);
        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal);
        Assert.assertNotEquals(square.objectAt(new Vector2d(1,1)),animal);
        Assert.assertEquals(square.objectAt(new Vector2d(1,1)),animal3);

        String [] words4={"f","b","f","f","b"};                                     // kiedy jest za malo argumentow
        MoveDirection[] directions4=new OptionsParser().parser(words4);
        square.run(directions4);

        Assert.assertEquals(square.objectAt(new Vector2d(1,1)),animal);
        Assert.assertEquals(square.objectAt(new Vector2d(3,1)),animal2);
        Assert.assertEquals(square.objectAt(new Vector2d(1,2)),animal3);

        String [] words5={"l","f","f","f","f","l","l","r","f","f","l","r"};         // wyjezdzanie po za pole
        MoveDirection[] directions5=new OptionsParser().parser(words5);
        square.run(directions5);

        Assert.assertEquals(square.objectAt(new Vector2d(0,0)),animal);
        Assert.assertEquals(square.objectAt(new Vector2d(3,3)),animal2);
        Assert.assertEquals(square.objectAt(new Vector2d(0,3)),animal3);

        Animal animal4=new Animal(square,new Vector2d(3,0),MapDirection.SOUTH);
        square.place(animal4);
        animal4.addObserver(square);

        String [] words6={"f","f","f","f","r","r","l","l","f","f","f","f"};
        MoveDirection[] directions6=new OptionsParser().parser(words6);
        square.run(directions6);

        Assert.assertEquals(square.objectAt(new Vector2d(0,0)),animal);
        Assert.assertEquals(square.objectAt(new Vector2d(3,3)),animal2);
        Assert.assertEquals(square.objectAt(new Vector2d(0,3)),animal3);
        Assert.assertEquals(square.objectAt(new Vector2d(3,0)),animal4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void runTest2(){
        RectangularMap square=new RectangularMap(3,3);
        String [] words3={"lf", "rb", "sprawdzenie","czy","bierze","smieci"};       // sprawdzenie czy bierze smieci
        MoveDirection[] directions3=new OptionsParser().parser(words3);
        square.run(directions3);
    }
}
