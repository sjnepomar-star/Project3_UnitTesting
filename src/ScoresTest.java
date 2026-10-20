import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        assertEquals(1,test.getNumScores());
        assertEquals(5,test.get(0));

    }

    @Test
    public void twoInt(){
        String twoInt ="5 6";
        Scores test =new Scores(twoInt);
        assertEquals(2,test.getNumScores());
        assertEquals(5,test.get(0));
        assertEquals(6,test.get(1));

    }

    @Test
    public void tabDelimited(){
        String twoInt ="5   6";
        Scores test =new Scores(twoInt);
        assertEquals(test.getNumScores(),2);
        assertEquals(test.get(0),5);
        assertEquals(test.get(1),6);
    }

    @Test
    public void zeroInts(){
        Scores test =new Scores("");
        assertEquals(0,test.getNumScores());
    }

    @Test
    public void newLineDelimited(){
        String twoInt ="5\n6";
        Scores test =new Scores(twoInt);
        assertEquals(test.getNumScores(),2);
        assertEquals(5,test.get(0));
        assertEquals(6,test.get(1));
    }

    @Test
    public void spaceNewlineTabDelimited(){
        String fourInt ="5 7   8\n9";
        Scores test =new Scores(fourInt);
        assertEquals(4,test.getNumScores());
        assertEquals(5,test.get(0));
        assertEquals(7,test.get(1));
        assertEquals(8,test.get(2));
        assertEquals(9,test.get(3));


    }

    @Test
    public void nonIntString(){
        String noInts ="HEllo Hi! Mooo";
        //Scores test =new Scores(noInts);

        assertThrows(IllegalArgumentException.class,() -> {
                    Scores test =new Scores(noInts);});

    }


    @Test
    public void nullString(){
        String nullString =null;
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test =new Scores(nullString);});
    }









    /*
     * getMax() tests
     */
    @Test
    public void improperReturn(){
        String noInt = " ";
        Scores test = new Scores(noInt);
        assertEquals(test.getMax(), -1);
    }
}
