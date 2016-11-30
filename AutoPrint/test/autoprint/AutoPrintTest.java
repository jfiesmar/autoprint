/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoprint;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class AutoPrintTest {
    
    public AutoPrintTest() {
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
     * Test of listarDirectorio method, of class AutoPrint.
     * @throws java.lang.Exception
     */
    @Test
    public void testListarDirectorio() throws Exception {
        System.out.println("listarDirectorio");
        AutoPrint instance = new AutoPrint();
        File[] expResult = null;
        File[] result = instance.listarDirectorio();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarDemonio method, of class AutoPrint.
     * @throws java.lang.Exception
     */
    @Test
    public void testIniciarDemonio() throws Exception {
        System.out.println("iniciarDemonio");
        AutoPrint instance = new AutoPrint();
        instance.iniciarDemonio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimir method, of class AutoPrint.
     * @throws java.lang.Exception
     */
    @Test
    public void testImprimir() throws Exception {
        System.out.println("imprimir");
        File fichero = null;
        AutoPrint instance = new AutoPrint();
        instance.imprimir(fichero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFichero method, of class AutoPrint.
     */
    @Test
    public void testBorrarFichero() {
        System.out.println("borrarFichero");
        File fichero = null;
        AutoPrint instance = new AutoPrint();
        instance.borrarFichero(fichero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AutoPrint.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AutoPrint.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
