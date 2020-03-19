import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab4.*;

import java.util.Vector;

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
        Assert.assertTrue(square.place(animal));                                 // na zajete pola
        Assert.assertFalse(square.canMoveTo(new Vector2d(2,4)));
        Assert.assertTrue(square.canMoveTo(new Vector2d(3,5)));
    }

    @Test
    public void isOccupiedTest(){
        RectangularMap square=new RectangularMap(5,5);
        Animal animal=new Animal(square,new Vector2d(2,4));
        Assert.assertTrue(square.place(animal));
        Assert.assertTrue(square.isOccupied(new Vector2d(2,4)));
        Assert.assertFalse(square.isOccupied(new Vector2d(3,3)));
    }

    @Test
    public void objectAtTest(){
        RectangularMap square=new RectangularMap(5,5);
        Animal animal=new Animal(square,new Vector2d(2,4));
        Assert.assertTrue(square.place(animal));
        Assert.assertEquals(square.objectAt(new Vector2d(2,4)),animal);
    }

    @Test
    public void placeTest(){
        RectangularMap square=new RectangularMap(1,1);
        Animal animal=new Animal(square);                                           // wstawia na pierwsze lepsze
        Assert.assertTrue(square.place(animal));
        Assert.assertNotNull(square.objectAt(new Vector2d(0,0)));
        Assert.assertEquals(square.objectAt(new Vector2d(0,0)),animal);

        animal=new Animal(square,new Vector2d(1,1));                           // wstawia na wybrane 1,1
        Assert.assertTrue(square.place(animal));
        Assert.assertNotNull(square.objectAt(new Vector2d(1,1)));
        Assert.assertEquals(square.objectAt(new Vector2d(1,1)),animal);

        animal=new Animal(square);                                                  // wstawia na pierwsze lepsze
        Assert.assertTrue(square.place(animal));
        Assert.assertNotNull(square.objectAt(new Vector2d(1,0)));
        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal);

        animal=new Animal(square,new Vector2d(1,0));                           // proboje wstawic na wybrane
        Assert.assertFalse(square.place(animal));

        animal=new Animal(square);                                                  // wstawia na pierwsze lepsze
        Assert.assertTrue(square.place(animal));
        Assert.assertNotNull(square.objectAt(new Vector2d(0,1)));
        Assert.assertEquals(square.objectAt(new Vector2d(0,1)),animal);
    }

    @Test
    public void runTest(){
        String [] words={"f","b","l","r","b","f","r","l","f","b"};                  // dla poprawnych danych
        MoveDirection[] directions = new OptionsParser().parser(words);
        RectangularMap square=new RectangularMap(3,3);
        Animal animal=new Animal(square,new Vector2d(2,2));
        Animal animal2=new Animal(square,new Vector2d(0,1));

        Assert.assertTrue(square.place(animal));
        Assert.assertTrue(square.place(animal2));

        square.run(directions);                                                     // poruszanie sie dwóch na raz

        Assert.assertNotNull(square.objectAt(new Vector2d(1,0)));
        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal2);
        Assert.assertNotNull(square.objectAt(new Vector2d(3,3)));
        Assert.assertEquals(square.objectAt(new Vector2d(3,3)),animal);

        Animal animal3=new Animal(square,new Vector2d(0,2),MapDirection.SOUTH);
        Assert.assertTrue(square.place(animal3));
        String [] words2={"f"};                                                     // proba wjechania na zajete pole
        MoveDirection[] directions2=new OptionsParser().parser(words2);
        square.run(directions2);

        Assert.assertNotNull(square.objectAt(new Vector2d(0,2)));
        Assert.assertEquals(square.objectAt(new Vector2d(0,2)),animal3);

        String [] words3={"lf", "rb", "sprawdzenie","czy","bierze","smieci"};       // sprawdzenie czy bierze smieci
        MoveDirection[] directions3=new OptionsParser().parser(words3);
        square.run(directions3);

        Assert.assertNotNull(square.objectAt(new Vector2d(1,0)));
        Assert.assertEquals(square.objectAt(new Vector2d(1,0)),animal2);
        Assert.assertNotNull(square.objectAt(new Vector2d(3,3)));
        Assert.assertEquals(square.objectAt(new Vector2d(3,3)),animal);
        Assert.assertNotNull(square.objectAt(new Vector2d(0,2)));
        Assert.assertEquals(square.objectAt(new Vector2d(0,2)),animal3);

        String [] words4={"b","f","b","b","f"};                                     // kiedy jest za malo argumentow
        MoveDirection[] directions4=new OptionsParser().parser(words4);
        square.run(directions4);

        Assert.assertNotNull(square.objectAt(new Vector2d(1,2)));
        Assert.assertEquals(square.objectAt(new Vector2d(1,2)),animal2);
        Assert.assertNotNull(square.objectAt(new Vector2d(3,1)));
        Assert.assertEquals(square.objectAt(new Vector2d(3,1)),animal);
        Assert.assertNotNull(square.objectAt(new Vector2d(0,3)));
        Assert.assertEquals(square.objectAt(new Vector2d(0,3)),animal3);
    }
}
