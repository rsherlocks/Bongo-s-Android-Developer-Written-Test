/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inerface.car.and.plane;

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
public class VehicleTest {
    
    public VehicleTest() {
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
     * Test of set_num_of_wheels method, of class Vehicle.
     */
    @Test
    public void testSet_num_of_wheels() {
        System.out.println("set_num_of_wheels");
        Vehicle instance = new VehicleImpl();
        int expResult = 0;
        int result = instance.set_num_of_wheels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_num_of_passengers method, of class Vehicle.
     */
    @Test
    public void testSet_num_of_passengers() {
        System.out.println("set_num_of_passengers");
        Vehicle instance = new VehicleImpl();
        int expResult = 0;
        int result = instance.set_num_of_passengers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of has_gas method, of class Vehicle.
     */
    @Test
    public void testHas_gas() {
        System.out.println("has_gas");
        Vehicle instance = new VehicleImpl();
        boolean expResult = false;
        boolean result = instance.has_gas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VehicleImpl implements Vehicle {

        public int set_num_of_wheels() {
            return 0;
        }

        public int set_num_of_passengers() {
            return 0;
        }

        public boolean has_gas() {
            return false;
        }
    }
    
}
