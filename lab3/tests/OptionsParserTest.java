import agh.cs.lab3.MoveDirection;
import org.junit.Test;
import org.junit.Assert;
import agh.cs.lab3.OptionsParser;
import java.util.ArrayList;

public class OptionsParserTest {
    @Test
    public void parserTest(){
        ArrayList<MoveDirection> arrayTest=new ArrayList<MoveDirection>();
        arrayTest.add(MoveDirection.FORWARD);
        arrayTest.add(MoveDirection.BACKWARD);
        arrayTest.add(MoveDirection.LEFT);
        arrayTest.add(MoveDirection.RIGHT);

        String[] stringsTest={"f","b","l","r"};

        Assert.assertEquals(arrayTest,new OptionsParser().parser(stringsTest));
    }
}
