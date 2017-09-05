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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author inf323
 */
public class AviaoTest {
    
    public AviaoTest() {
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
     * Test of ligarTurbinas method, of class Aviao.
     */
    @Test
    public void testLigarTurbinas() {
        System.out.println("ligarTurbinas");
        Aviao instance = new Aviao();
        boolean expResult = true;
        instance.ligarTurbinas();
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of desligarTurbinas method, of class Aviao.
     */
    @Test
    public void testDesligarTurbinas() {
        System.out.println("desligarTurbinas");
        Aviao instance = new Aviao();
        instance.desligarTurbinas();
        boolean expResult = false;
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isTurbinasLigadas method, of class Aviao.
     */
    @Test
    public void testIsTurbinasLigadas() {
        System.out.println("isTurbinasLigadas");
        Aviao instance = new Aviao();
        boolean expResult = false;
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of nivelPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testNivelPotenciaTurbinas() {
        System.out.println("nivelPotenciaTurbinas");
        Aviao instance = new Aviao();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of aumentarPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testAumentarPotenciaTurbinas() {
        System.out.println("aumentarPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.aumentarPotenciaTurbinas();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
    }

    /**
     * Test of diminuirPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testDiminuirPotenciaTurbinas() {
        System.out.println("diminuirPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.diminuirPotenciaTurbinas();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
    }

    /**
     * Test of abastecer method, of class Aviao.
     */
    @Test
    public void testAbastecer() {
        System.out.println("abastecer");
        double value = 1.0;
        Aviao instance = new Aviao();
        instance.abastecer(value);
        
    }

    /**
     * Test of consumir method, of class Aviao.
     */
    @Test
    public void testConsumir() {
        System.out.println("consumir");
        double value = 0.0;
        Aviao instance = new Aviao();
        instance.consumir(value);
       
    }

    /**
     * Test of getCapacidadeTotalCombustivel method, of class Aviao.
     */
    @Test
    public void testGetCapacidadeTotalCombustivel() {
        System.out.println("getCapacidadeTotalCombustivel");
        Aviao instance = new Aviao();
        double expResult = 1000;
        double result = instance.getCapacidadeTotalCombustivel();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getQntdAtualCombustivel method, of class Aviao.
     */
    @Test
    public void testGetQntdAtualCombustivel() {
        System.out.println("getQntdAtualCombustivel");
        Aviao instance = new Aviao();
        double expResult = 0.0;
        double result = instance.getQntdAtualCombustivel();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of carregarCarga method, of class Aviao.
     */
    @Test
    public void testCarregarCarga() {
        System.out.println("carregarCarga");
        int value = 0;
        Aviao instance = new Aviao();
        instance.carregarCarga(value);

    }

    /**
     * Test of getCapacidadeTotalCarga method, of class Aviao.
     */
    @Test
    public void testGetCapacidadeTotalCarga() {
        System.out.println("getCapacidadeTotalCarga");
        Aviao instance = new Aviao();
        int expResult = 1000;
        int result = instance.getCapacidadeTotalCarga();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getQntdAtualCarga method, of class Aviao.
     */
    @Test
    public void testGetQntdAtualCarga() {
        System.out.println("getQntdAtualCarga");
        Aviao instance = new Aviao();
        int expResult = 0;
        int result = instance.getQntdAtualCarga();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Testa a quantidade de turbinas que o avião possui
     */
    @Test
    public void testQtdTurbinas(){
    	System.out.println("Quantidade de Turbinas");
    	Aviao instance = new Aviao();
    	int expResult = 2;
    	int result = 0;
    	Field[] lista = instance.getClass().getDeclaredFields();
    	for (Field field : lista) {
			if(field.getType().equals(Turbina.class))
				result++;
		}
    	assertEquals(expResult, result);
    	
    }
    
    /**
     * Testa a quantidade de tanques que o avião possui
     */
    @Test
    public void testQtdTanques(){
    	System.out.println("Quantidade de Tanques");
    	Aviao instance = new Aviao();
    	int expResult = 1;
    	int result = 0;
    	Field[] lista = instance.getClass().getDeclaredFields();
    	for (Field field : lista) {
			if(field.getType().equals(TanqueCombustivel.class))
				result++;
		}
    	assertEquals(expResult, result);
    	
    }
    
    /**
     * Testa a quantidade de Compartimento de carga que o avião possui
     */
    @Test
    public void testQtdCompartimentoCarga(){
    	System.out.println("Quantidade de Compartimento de Carga");
    	Aviao instance = new Aviao();
    	int expResult = 1;
    	int result = 0;
    	Field[] lista = instance.getClass().getDeclaredFields();
    	for (Field field : lista) {
			if(field.getType().equals(CompartimentoCarga.class))
				result++;
		}
    	assertEquals(expResult, result);
    	
    }
    
}
