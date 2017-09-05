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
public class CompartimentoCargaTest {
    
    public CompartimentoCargaTest() {
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
     * Test of getCapacidadeTotal method, of class CompartimentoCarga.
     */
    @Test
    public void testGetCapacidadeTotal() {
        System.out.println("getCapacidadeTotal");
        CompartimentoCarga instance = new CompartimentoCarga();
        int expResult = 1000;
        int result = instance.getCapacidadeTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQntAtual method, of class CompartimentoCarga.
     */
    @Test
    public void testGetQntAtual() {
        System.out.println("getQntAtual");
        CompartimentoCarga instance = new CompartimentoCarga();
        int expResult = 0;
        int result = instance.getQntAtual();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of carregarCarga method, of class CompartimentoCarga.
     */
    @Test
    public void testCarregarCarga() {
        System.out.println("carregarCarga");
        CompartimentoCarga instance = new CompartimentoCarga();
        boolean expResult1 = false;
        boolean result1 = instance.carregarCarga(2000);
        assertEquals(expResult1, result1);
        assertEquals(0, instance.getQntAtual());
        //
        boolean expResult2 = true;
        boolean result2 = instance.carregarCarga(100);
        assertEquals(expResult2, result2);
        assertEquals(100, instance.getQntAtual());
        //
        boolean expResult3 = true;
        boolean result3 = instance.carregarCarga(50);
        assertEquals(expResult3, result3);
        assertEquals(150, instance.getQntAtual());
        
    }
    
}
