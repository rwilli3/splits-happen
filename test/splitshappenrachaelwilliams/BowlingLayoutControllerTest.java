/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitshappenrachaelwilliams;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachael
 */
public class BowlingLayoutControllerTest {
    
    public BowlingLayoutControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    //convert validation test 1 input
    @Test
    public void testRollsToArrayAllStrikes() {
        System.out.println("rollsToArrayAllStrikes");
        String rolls = "XXXXXXXXXXXX";
        BowlingLayoutController instance = new BowlingLayoutController();
        int[] expResult = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] result = instance.rollsToArray(rolls);
        assertArrayEquals(expResult, result);
    }
    
    //convert validation test 2 input
    @Test
    public void testRollsToArrayRepeatedNineMiss() {
        System.out.println("rollsToArrayRepeatedNineMiss");
        String rolls = "9-9-9-9-9-9-9-9-9-9-";
        BowlingLayoutController instance = new BowlingLayoutController();
        int[] expResult = {9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};
        int[] result = instance.rollsToArray(rolls);
        assertArrayEquals(expResult, result);
    }
    
    //convert validation test 3 input
    @Test
    public void testRollsToArrayRepeatedFiveSpare() {
        System.out.println("rollsToArrayRepeatedFiveSpare");
        String rolls = "5/5/5/5/5/5/5/5/5/5/5";
        BowlingLayoutController instance = new BowlingLayoutController();
        int[] expResult = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] result = instance.rollsToArray(rolls);
        assertArrayEquals(expResult, result);
    }
    
    //convert validation test 4 input
    @Test
    public void testRollsToArrayMixedInput() {
        System.out.println("rollsToArrayMixedInput");
        String rolls = "X7/9-X-88/-6XXX81";
        BowlingLayoutController instance = new BowlingLayoutController();
        int[] expResult = {10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1};
        int[] result = instance.rollsToArray(rolls);
        assertArrayEquals(expResult, result);
    }
    
}
