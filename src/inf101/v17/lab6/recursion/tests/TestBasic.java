package inf101.v17.lab6.recursion.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import inf101.v17.lab6.recursion.Basic;

public class TestBasic {
    
    /**
     * Simple test for sumOfDigits()
     */
    @Test
    public void testSumOfDigitsSmall() {
        assertEquals(Basic.sumOfDigits(129), 12);
        assertEquals(Basic.sumOfDigits(-12), 3);
        assertEquals(Basic.sumOfDigits(100), 1);
    }
    
    /**
     * Simple test for pyramidBlocks()
     */
    @Test
    public void testPyramidBlocksSmall() {
        assertEquals(Basic.pyramidBlocks(0), 0);
        assertEquals(Basic.pyramidBlocks(1), 1);
        assertEquals(Basic.pyramidBlocks(2), 5);
        assertEquals(Basic.pyramidBlocks(-2), -5);
    }
    
    /**
     * Simple test for nCr()
     */
    @Test
    public void testnCrSmall() {
        assertEquals(Basic.nCr(3, 2), 3);
        assertEquals(Basic.nCr(2, 1), 2);
        assertEquals(Basic.nCr(1, 0), 1);
        assertEquals(Basic.nCr(2, 3), 0);
        assertEquals(Basic.nCr(5, -2), 0);
    }

}
