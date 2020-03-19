import agh.cs.lab6.MoveDirection;
import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab6.OptionsParser;

public class OptionsParserTest {
    @Test
    public void parserTest(){
        MoveDirection [] arrayTest=new MoveDirection[4];
        arrayTest[0]=MoveDirection.FORWARD;
        arrayTest[1]=MoveDirection.LEFT;
        arrayTest[2]=MoveDirection.BACKWARD;
        arrayTest[3]=MoveDirection.RIGHT;

        String[] stringsTest={"f","l","b","r"};

        Assert.assertArrayEquals(arrayTest,new OptionsParser().parser(stringsTest));        // dla poprawnych danych

        arrayTest[0]=MoveDirection.BACKWARD;
        arrayTest[1]=MoveDirection.RIGHT;
        arrayTest[2]=MoveDirection.FORWARD;
        arrayTest[3]=MoveDirection.LEFT;

        Assert.assertNotEquals(arrayTest,new OptionsParser().parser(stringsTest));          // dla niepoprawnych danych
    }

    @Test(expected=IllegalArgumentException.class)
    public void parserTest2(){
        MoveDirection [] arrayTest=new MoveDirection[4];
        String[] stringsTest={"b","ee","bla","r","pf","f","jo","left"};                     // dla wymieszanych
        arrayTest=new OptionsParser().parser(stringsTest);
    }

    @Test(expected=IllegalArgumentException.class)
    public void parserTest3(){
        MoveDirection [] arrayTest=new MoveDirection[4];
        String[] stringsTest={"ee","bla","pf","jo"};                                       // dla pustej
        arrayTest=new OptionsParser().parser(stringsTest);
    }
}
