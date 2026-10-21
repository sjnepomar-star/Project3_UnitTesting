import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoresTest {
    /**
     * Constructor tests using numScores() and get()
     **/
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
    public void manyInt(){
        String manyInts ="";
        for(int i=0;i<100;i++){
            Integer num =i;
            manyInts = manyInts.concat(num.toString());
            manyInts =manyInts.concat(" ");
        }
        Scores test = new Scores(manyInts);
        assertEquals(100,test.getNumScores());
    }

    @Test
    public void tabDelimited(){
        String twoInt ="5   6";
        Scores test = new Scores(twoInt);
        assertEquals(test.getNumScores(),2);
        assertEquals(test.get(0),5);
        assertEquals(test.get(1),6);
    }

    @Test
    public void zeroInts(){
        Scores test = new Scores("");
        assertEquals(0,test.getNumScores());
    }

    @Test
    public void newLineDelimited(){
        String twoInt ="5\n6";
        Scores test = new Scores(twoInt);
        assertEquals(test.getNumScores(),2);
        assertEquals(5,test.get(0));
        assertEquals(6,test.get(1));
    }

    @Test
    public void spaceNewlineTabDelimited(){
        String fourInt = "5 7   8\n9";
        Scores test =new Scores(fourInt);
        assertEquals(4,test.getNumScores());
        assertEquals(5,test.get(0));
        assertEquals(7,test.get(1));
        assertEquals(8,test.get(2));
        assertEquals(9,test.get(3));


    }

    @Test
    public void positiveandNegitiveInts(){
        String positiveAndNegitive = ("-5 4 -6   9 0");
        Scores test =new Scores(positiveAndNegitive);
        assertEquals(5,test.getNumScores());
        assertEquals(-5,test.get(0));
        assertEquals(4,test.get(1));
        assertEquals(-6,test.get(2));
        assertEquals(9,test.get(3));
        assertEquals(0,test.get(4));
    }

    @Test
    public void nonIntString(){
        String noInts = "HEllo Hi! Mooo";
        //Scores test =new Scores(noInts);

        assertThrows(IllegalArgumentException.class,() -> {
                    Scores test = new Scores(noInts);});

    }


    @Test
    public void nullString(){
        String nullString =null;
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test = new Scores(nullString);});
    }

    @Test
    public void stringsAndInts(){
        String mix = "5 moo 6 MooButLouder 9 10  5 eee\n9";
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test = new Scores(mix);});
    }

    @Test
    public void floats(){
        String floats = "9.5 11.1 6.7\n67.67 9.09";
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test = new Scores(floats);});
    }

    @Test
    public void floatsAndInts(){
        String mix = "9 0.6  5\n9.999 8";
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test = new Scores(mix);});
    }

    @Test
    public void csvList(){
        String csv = "5,6,7,8,9,10";
        assertThrows(IllegalArgumentException.class,() -> {
            Scores test = new Scores(csv);});
    }





    /**
     * getMax() tests
     **/
    @Test
    public void noElementsTest(){
        String noElement = " ";
        Scores test = new Scores(noElement);
        assertThrows(NoSuchElementException.class, test::getMax);
    }

    @Test
    public void firstIsMaxAndNotIn(){
        int firstElement = 4;
        String elements =  "4 2 3 2 1 2 3";
        Scores test1 = new Scores(elements);

        assertEquals(firstElement, test1.getMax());


        firstElement = 986;
        elements = "986 764 34 7 254 865 933 143 985";
        Scores test2 = new Scores(elements);

        assertEquals(firstElement, test2.getMax());
    }

    @Test
    public void lastIsMaxAndNotIn(){
        int lastElement = 7;
        String elements = "2 3 2 1 2 3 7";
        Scores test1 = new Scores(elements);

        assertEquals(lastElement, test1.getMax());


        lastElement = 986;
        elements = "764 34 7 254 865 933 143 986";
        Scores test2 = new Scores(elements);

        assertEquals(lastElement, test2.getMax());
    }

    @Test
    public void allElements(){
        String elements = "6 2 7 1 5 3 8 4";
        Scores test = new Scores(elements);

        assertEquals(8, test.getMax());
    }
}
