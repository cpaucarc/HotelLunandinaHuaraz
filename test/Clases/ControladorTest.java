package Clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorTest {
    
    public ControladorTest() {
    }
    
    @BeforeClass public static void setUpClass() {}
    
    @AfterClass public static void tearDownClass() {}
    
    @Before public void setUp() {}
    
    @After public void tearDown() {}

    @Test
    public void testDevolverRegistroDto() {
        System.out.println("DevolverRegistroDto");
        String sq = "select nombres from vw_empleados WHERE username = '57575475'";
        int pos = 1;                  
        Controlador instance = new Controlador();
        String expResult = "Christian Ember Marcelino";
        String result = instance.DevolverRegistroDto(sq, pos);
        assertEquals(expResult, result);
    }  
    //Prubas Unitarias: evalua la logica
    //P. Intergracion: evalua el codigo
    //Prueba de rendimiento: verifica las debilidades y limites
        // verifica los requerimientos funcionales y cumplir con losparametros de seguridad
    //prueba de estres: ir al extrmeo y colocar informacion que no es veraz necesariamente
}
