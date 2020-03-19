import org.junit.Test;
import org.junit.Assert;
import java.util.HashMap;
import java.lang.Math;
import agh.cs.lab6.*;

public class GrassFieldTest {
    // zakladam poprawnosc samego konstruktora i gettera

    @Test
    public void plantGrassTest(){
        GrassField fields=new GrassField(5);
        HashMap<Vector2d,Grass> mapOfGrass=fields.getMapOfGrass();
        Vector2d maxRightUpperCorner=new Vector2d((int)Math.sqrt(5*10),(int)Math.sqrt(5*10));

        Assert.assertNotNull(mapOfGrass);
        Assert.assertEquals(5,mapOfGrass.size());

        for(Vector2d iterated : mapOfGrass.keySet()){
            Assert.assertEquals(iterated,mapOfGrass.get(iterated).getPosition());
            Assert.assertTrue(iterated.precedes(maxRightUpperCorner));
        }
    }

    @Test
    public void isOccupiedByAnimalTest(){
        GrassField fields=new GrassField(5);
        Animal animal=new Animal(fields, new Vector2d(0,0));

        fields.place(animal);
        Assert.assertTrue(fields.isOccupiedByAnimal(new Vector2d(0,0)));
        Assert.assertFalse(fields.isOccupiedByAnimal(new Vector2d(1,1)));
    }

    @Test
    public void isOccupied(){
        GrassField fields=new GrassField(5);
        HashMap<Vector2d,Grass> mapOfGrass=fields.getMapOfGrass();
        Animal animal=new Animal(fields, new Vector2d(0,0));

        fields.place(animal);
        Assert.assertTrue(fields.isOccupied(new Vector2d(0,0)));

        for(Vector2d iterated : mapOfGrass.keySet()){
            Assert.assertTrue(fields.isOccupied(iterated));
        }
    }

    @Test
    public void objectAt(){
        GrassField fields=new GrassField(5);
        HashMap<Vector2d,Grass> mapOfGrass=fields.getMapOfGrass();

        for(Vector2d iterated : mapOfGrass.keySet()){
            Assert.assertEquals(iterated,mapOfGrass.get(iterated).getPosition());
            Animal animal=new Animal(fields, iterated);
            fields.place(animal);
            Assert.assertEquals(animal,fields.objectAt(iterated));
        }
    }

    @Test
    public void canMoveToTest(){
        GrassField fields=new GrassField(5);
        HashMap<Vector2d,Grass> mapOfGrass=fields.getMapOfGrass();

        for(Vector2d iterated : mapOfGrass.keySet()){
            Assert.assertTrue(fields.canMoveTo(iterated));
        }

        Animal animal=new Animal(fields, new Vector2d(0,0));

        fields.place(animal);
        Assert.assertFalse(fields.canMoveTo(new Vector2d(0,0)));
    }

    @Test
    public void placeTest(){
        GrassField fields=new GrassField(5);
        Animal animal=new Animal(fields);                                           // wstawia na 0,0
        fields.place(animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(0,0)),animal);

        animal=new Animal(fields,new Vector2d(1,1));                           // wstawia na 1,1
        fields.place(animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(1,1)),animal);

        animal=new Animal(fields,new Vector2d(1,0));                           // proboje na 1,0
        fields.place(animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(1,0)),animal);

        animal=new Animal(fields,new Vector2d(0,1));                           // wstawia na 0,1
        fields.place(animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(0,1)),animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void placeTest2(){
        GrassField fields=new GrassField(5);
        Animal animal=new Animal(fields,new Vector2d(0,0));                           // wstawia na 0,0
        fields.place(animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(0,0)),animal);

        animal=new Animal(fields);                                                  // proboje wstawic na 0,0
        fields.place(animal);
    }

    @Test
    public void runTest() {
        String[] words = {"b", "f", "r", "l", "f", "b", "l", "r", "b", "f"};                  // dla poprawnych danych
        MoveDirection[] directions = new OptionsParser().parser(words);
        GrassField fields = new GrassField(25);
        Animal animal = new Animal(fields, new Vector2d(0, 1));
        Animal animal2 = new Animal(fields, new Vector2d(2, 2));

        fields.place(animal);
        fields.place(animal2);

        fields.run(directions);                                                     // poruszanie sie dwóch na raz

        Assert.assertEquals(fields.objectAt(new Vector2d(1, -1)), animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(3, 4)), animal2);

        Animal animal3 = new Animal(fields, new Vector2d(1, 1));
        fields.place(animal3);
        String[] words2 = {"f"};                                                     // proba wjechania na zajete pole
        MoveDirection[] directions2 = new OptionsParser().parser(words2);
        fields.run(directions2);

        Assert.assertNotEquals(fields.objectAt(new Vector2d(1, 0)), animal3);
        Assert.assertEquals(fields.objectAt(new Vector2d(1, 0)), animal);
        Assert.assertNotEquals(fields.objectAt(new Vector2d(1, 1)), animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(1, 1)), animal3);

        String[] words4 = {"f", "b", "f", "f", "b"};                                     // kiedy jest za malo argumentow
        MoveDirection[] directions4 = new OptionsParser().parser(words4);
        fields.run(directions4);

        Assert.assertEquals(fields.objectAt(new Vector2d(1, 1)), animal);
        Assert.assertEquals(fields.objectAt(new Vector2d(3, 2)), animal2);
        Assert.assertEquals(fields.objectAt(new Vector2d(1, 2)), animal3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void runTest2(){
        GrassField fields = new GrassField(25);
        String[] words3 = {"lf", "rb", "sprawdzenie", "czy", "bierze", "smieci"};       // sprawdzenie czy bierze smieci
        MoveDirection[] directions3 = new OptionsParser().parser(words3);
        fields.run(directions3);
    }
}
