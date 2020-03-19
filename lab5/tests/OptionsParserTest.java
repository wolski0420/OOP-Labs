import agh.cs.lab5.MoveDirection;
import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab5.OptionsParser;

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

        String[] stringsTest2={"b","ee","bla","r","pf","f","jo","left"};

        Assert.assertArrayEquals(arrayTest,new OptionsParser().parser(stringsTest2));       // dla wymieszanych

        String[] stringsTest3={"ee","bla","pf","jo"};

        Assert.assertNull(new OptionsParser().parser(stringsTest3));                        // dla pustej
    }
}
