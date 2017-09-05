package br.unicamp.ic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * tarefa 1
 * @author INF323
 */
public class ContadorVogaisTest {
    
    public ContadorVogaisTest() {
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
     * Test of totalA method, of class ContadorVogais.
     */
    @Test
    public void testTotalA() {
        System.out.println("totalA");
        ContadorVogais instance = new ContadorVogais("Test of totalA method, of class ContadorVogais.".split(" "));
        int expResult = 5;
        int result = instance.totalA();
        assertEquals(expResult, result);
    }

    /**
     * Test of totalE method, of class ContadorVogais.
     */
    @Test
    public void testTotalE() {
        System.out.println("totalE");
        ContadorVogais instance = new ContadorVogais("Test of totalE method, of class ContadorVogais.".split(" "));
        int expResult = 3;
        int result = instance.totalE();
        assertEquals(expResult, result);
    }

    /**
     * Test of totalI method, of class ContadorVogais.
     */
    @Test
    public void testTotalI() {
        System.out.println("totalI");
        ContadorVogais instance = new ContadorVogais("Test of totalI method, of class ContadorVogais.".split(" "));
        int expResult = 2;
        int result = instance.totalI();
        assertEquals(expResult, result);
    }

    /**
     * Test of totalO method, of class ContadorVogais.
     */
    @Test
    public void testTotalO() {
        System.out.println("totalO");
        ContadorVogais instance = new ContadorVogais("Test of totalO method, of class ContadorVogais.".split(" "));
        int expResult = 8;
        int result = instance.totalO();
        assertEquals(expResult, result);
    }

    /**
     * Test of totalU method, of class ContadorVogais.
     */
    @Test
    public void testTotalU() {
        System.out.println("totalU");
        ContadorVogais instance = new ContadorVogais("Test of totalU method, of class ContadorVogais.".split(" "));
        int expResult = 1;
        int result = instance.totalU();
        assertEquals(expResult, result);
    }

    /**
     * Test of total method, of class ContadorVogais.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        ContadorVogais instance = new ContadorVogais("Test of total method, of class ContadorVogais.".split(" "));
        int expResult = 14;
        int result = instance.total();
        assertEquals(expResult, result);
    }
    
}
