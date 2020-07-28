/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.angram;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class StringAngramTest {
    
    public StringAngramTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class StringAngram.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StringAngram.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of areAnagram method, of class StringAngram.
     */
    @Test
    public void testAreAnagram() {
        System.out.println("areAnagram");
        char[] str1 = null;
        char[] str2 = null;
        boolean expResult = false;
        boolean result = StringAngram.areAnagram(str1, str2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
