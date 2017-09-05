/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inf323
 */
public class MotorTest {
    
    public MotorTest() {
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
     * Test of isLigado method, of class Motor.
     */
    @Test
    public void testIsLigado() {
        System.out.println("isLigado");
        Motor instance = new Motor();
        boolean expResult = false;
        boolean result = instance.isLigado();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ligar method, of class Motor.
     */
    @Test
    public void testLigar() {
        System.out.println("ligar");
        Motor instance = new Motor();
        instance.ligar();
        boolean expResult = true;
        boolean result = instance.isLigado();
        assertEquals(expResult, result);
    }

    /**
     * Test of desligar method, of class Motor.
     */
    @Test
    public void testDesligar() {
        System.out.println("desligar");
        Motor instance = new Motor();
        instance.ligar();
        instance.desligar();
        boolean expResult = false;
        boolean result = instance.isLigado();
        assertEquals(expResult, result);
    }
    
}
