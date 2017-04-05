package inf101.v17.lab6.recursion;

public class Basic {

    /**
     * Returns the sum of the digits of the number (decimal notation)
     * 
     * Examples:
     * <ul>
     * <li>sumOfDigits(129) == 12
     * <li>sumOfDigits(-12) == 3
     * <li>sumOfDigits(100) == 1
     * </ul>
     * 
     * Write this function without using any form of loop (for, while etc.)
     * 
     * Hint: The modulo operator % can be used to extract the last digit of a
     * positive number, e.g. 234 % 10 == 4.
     * 
     * @param num
     *            the number
     * @return sum of digits of num
     */
    public static int sumOfDigits(int num) {
        // TODO
        return 0;
    }

    /**
     * Returns the number of building blocks in a pyramid of given height
     * 
     * Consider a pyramid built of perfect square blocks. Each floor of the
     * pyramid consists of a square grid of blocks, starting with a single block
     * on the top floor, then a 2x2 grid of blocks on the second floor from the
     * top, a 3x3 grid of blocks on the third floor from the top and so forth.
     * 
     * Our job is to return the total number of blocks in such a pyramid of a
     * given height. Solve the exercise recursively without using loops of any
     * kind (for, while etc.)
     * 
     * If the height of the pyramid is negative, then instead of building the
     * pyramid upwards, the engineers want to dig a pyramid-shaped hole
     * downwards. This will yield blocks to spare rather than blocks spent, so
     * the answer should be negative.
     * 
     * Examples:
     * <ul>
     * <li>pyramidBlocks(0) == 0
     * <li>pyramidBlocks(1) == 1
     * <li>pyramidBlocks(2) == 5
     * <li>pyramidBlocks(-2) == -5
     * </ul>
     * 
     * @param height
     *            non-negative number
     * @return the number of blocks in the pyramid
     */
    public static int pyramidBlocks(int height) {
        // TODO
        return 0;
    }
    
    

    /**
     * N choose R.
     * 
     * The function nCr(n, r) returns how many possible combinations of r
     * elements can be made out of a collection of size n. For example, given
     * three (n=3) fruits, say an apple, an orange and a pear, there are three
     * combinations of two (r=2) that can be drawn from this set: an apple and a
     * pear; an apple and an orange; or a pear and an orange. Thus, nCr(3,
     * 2)==3.
     * 
     * Examples:
     * <ul>
     * <li>nCr(3, 2) == 3
     * <li>nCr(2, 1) == 2
     * <li>nCr(1, 0) == 1
     * <li>nCr(2, 3) == 0
     * <li>nCr(5, -1) == 0
     * <li>nCr(-2, 1) == 0
     * </ul>
     * 
     * Try writing the function without calculating the factorial, and without
     * using loops of any form (for, while, etc.)
     * 
     * Hint 1: By the definition, what happens when r>n? r==n? r==0?
     * 
     * Hint 2: Suppose there are n different types of fruit, and that apples are
     * one of them. Some of the possible combinations of fruit that can be made
     * include apples, say x. Some combinations of fruit does __not__ contain
     * apples, say y. Notice that then the total number of combinations is x+y.
     * Can we calculate x and y recursively?
     * 
     * Hint 3: If you are still stuck, look up the recurrence relation here:
     * https://en.wikipedia.org/wiki/Binomial_coefficient#Recursive_formula
     * 
     * 
     * If you test the function and find that it is very slow on big inputs, that
     * is to be expected. Is there something we can do to speed it up?
     * 
     * @param n
     *            the size of the collection
     * @param r
     *            the size of the combination
     * @return the number of ways to pick r items from a collection of n items.
     */
    public static int nCr(int n, int r) {
        // TODO
        return 0;
    }

}
