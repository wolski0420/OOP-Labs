import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab3.Animal;
import agh.cs.lab3.MoveDirection;

public class AnimalTest {
    @Test
    public void moveTest(){
        Animal animalTest=new Animal();

        //sprawdzam poczatkowa lokalizacje i zwrot
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());

        //sprawdzam pokolei skrecanie w prawo WSCHOD,POLUDNIE,ZACHOD,POLNOC
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,2)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,2)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,2)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());

        //sprawdzam pokolei skrecanie w lewo ZACHOD,POLUDNIE,WSCHOD,POLNOC
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,2)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,2)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,2)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());

        //sprawdzam ruch do przodu
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,3)  Direction: Polnoc", animalTest.toString());

        //sprawdzam ruch do tylu
        animalTest.move(MoveDirection.BACKWARD);
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());

        //sprawdzam prawidlowa zmiane pol
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,2)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (3,2)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (3,2)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (3,1)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (3,1)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,1)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,1)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,3)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,3)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (1,3)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (1,3)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (1,2)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (1,2)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,2)  Direction: Wschod", animalTest.toString());

        //sprawdzam wyjezdzanie po za pola
        animalTest.move(MoveDirection.LEFT);
        Assert.assertEquals("Location: (2,2)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,3)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,4)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,4)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (2,4)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (3,4)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,4)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,4)  Direction: Wschod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (4,4)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,3)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,2)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,1)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,0)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (4,0)  Direction: Poludnie", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (4,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (3,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (2,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (1,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,0)  Direction: Zachod", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (0,0)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,1)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,2)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,3)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,4)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("Location: (0,4)  Direction: Polnoc", animalTest.toString());
        animalTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("Location: (0,4)  Direction: Wschod", animalTest.toString());
    }

}
