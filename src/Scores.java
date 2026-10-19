import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Scores {
    private final ArrayList<Integer> nums;

    /**
     * @param numbers should be a String with zero or more whitespace-delimited integers.
     *                Each integer is a score. This class holds the list of scores parsed from the String.
     * @throws IllegalArgumentException if numbers is not a whitespace-delimited list of zero or more integers.
     */
    public Scores(String numbers) throws IllegalArgumentException {
        // This is a stub; it is not complete.
		nums = new ArrayList<>();


        Scanner stringScan = new Scanner(numbers);
        while (stringScan.hasNext()){
            nums.add(Integer.parseInt(stringScan.next()));
        }
        if(nums.size() == 1){//could be enhanced(I just couldn't think of a better way to handle a nonwhitespace-delimited string)
            throw new IllegalArgumentException("The list of numbers are not a whitespace-delimited.\n Try again");
        }
    }

    /**
     * @return the number of scores in this object i.e. the number of integers in the String given to the constructor
	 *
	 *	NOTE: You do *NOT* need to test this method! Trivial getters are simple enough that we can just
	 *	assume they work. (It'd be hard to test them in isolation anyway!)
     */
    public int getNumScores() {
        return -1;
    }

    /**
     * @param index An integer index in the range [0, getNumScores())
     * @return The score at the specified index. For example, the first score in the String is at index 0.
	 * @throws IndexOutOfBoundsException if index is outside the range [0, getNumScores()).
	 *
	 *	NOTE: You do *NOT* need to test this method!
     */
    public int get(int index) { return -1; }

    /**
     * @return the maximum score stored in this object
     * @throws java.util.NoSuchElementException if there are no scores
     */
    public int getMax() throws NoSuchElementException { return -1; }
}
