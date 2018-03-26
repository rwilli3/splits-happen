/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitshappenrachaelwilliams;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachael
 */
public class BowlingScoreTest {
    //validation test cases- input converted to int arrays as done in controller
    int[] testArray1 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    int[] testArray2 = {9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};
    int[] testArray3 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    int[] testArray4 = {10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1};
    
    public BowlingScoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    //validation test case 1
    @Test
    public void testCalculateScoreAllStrikes() {
        System.out.println("calculateScoreAllStrikes");
        BowlingScore tester = new BowlingScore(testArray1);
        int expResult = 300;
        int result = tester.calculateScore();
        assertEquals(expResult, result);
    }
    
    //validation test case 2
    @Test
    public void testCalculateScoreRepeatedNineMiss() {
        System.out.println("calculateScoreRepeatedNineMiss");
        BowlingScore tester = new BowlingScore(testArray2);
        int expResult = 90;
        int result = tester.calculateScore();
        assertEquals(expResult, result);
    }
    
    //validation test case 3
    @Test
    public void testCalculateScoreRepeatedFiveSpare() {
        System.out.println("calculateScoreRepeatedFiveSquare");
        BowlingScore tester = new BowlingScore(testArray3);
        int expResult = 150;
        int result = tester.calculateScore();
        assertEquals(expResult, result);
    }
    
    //validation test case 4
    @Test
    public void testCalculateScoreMixedInput() {
        System.out.println("calculateScoreMixedInput");
        BowlingScore tester = new BowlingScore(testArray4);
        int expResult = 167;
        int result = tester.calculateScore();
        assertEquals(expResult, result);
    }
}
