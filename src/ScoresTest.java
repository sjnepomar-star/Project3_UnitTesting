import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoresTest {
    /*
     * Constructor tests using numScores() and get()
     */
    @Test
    public void oneInt(){
        String oneInt ="5";
        Scores test =new Scores(oneInt);
        assertEquals(test.getNumScores(),1);
        assertEquals(test.get(0),5);

    }

    @Test
    public void twoInt(){
        String twoInt ="5 6";
        Scores test =new Scores(twoInt);
        assertEquals(test.getNumScores(),2);
        assertEquals(test.get(0),5);
        assertEquals(test.get(1),6);

    }
    /*
     * getMax() tests
     */

}
