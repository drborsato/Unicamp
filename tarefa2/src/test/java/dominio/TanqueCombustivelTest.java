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
public class TanqueCombustivelTest {
    
    public TanqueCombustivelTest() {
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
     * Test of getCapacidadeTotal method, of class TanqueCombustivel.
     */
    @Test
    public void testGetCapacidadeTotal() {
        System.out.println("getCapacidadeTotal");
        TanqueCombustivel instance = new TanqueCombustivel();
        double expResult = 1000;
        double result = instance.getCapacidadeTotal();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getQntAtual method, of class TanqueCombustivel.
     */
    @Test
    public void testGetQntAtual() {
        System.out.println("getQntAtual");
        TanqueCombustivel instance = new TanqueCombustivel();
        double expResult1 = 0;
        double result1 = instance.getQntAtual();
        assertEquals(expResult1, result1, 0.0);
        double expResult2 = 10;
        instance.abastecer(10);
        double result2 = instance.getQntAtual();
        assertEquals(expResult2, result2, 0.0);
        //
        double expResult3 = 20;
        instance.abastecer(10);
        double result3 = instance.getQntAtual();
        assertEquals(expResult3, result3, 0.0);
        //
        double expResult4 = 1000;
        instance.abastecer(2000);
        double result4 = instance.getQntAtual();
        assertEquals(expResult4, result4, 0.0);
    }

    /**
     * Test of abastecer method, of class TanqueCombustivel.
     */
    @Test
    public void testAbastecer() {
        System.out.println("abastecer");
        double value = 2000;
        TanqueCombustivel instance = new TanqueCombustivel();
        boolean expResult = false;
        boolean result = instance.abastecer(value);
        assertEquals(expResult, result);
        assertEquals(instance.getCapacidadeTotal(), instance.getQntAtual(), 0.0);
        
    }
    
}
