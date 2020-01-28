/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.LoginLunandina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PAUCAR
 */
public class testDevolverDato {
    
    LoginLunandina ll=new LoginLunandina("57575475", "57575475");
    
    public testDevolverDato() {
        
    }
    @Test
        public void testDevolverDato(){
            String resultado="";
            String esperado="Administrador";
            resultado = ll.DevolverDato("cargo");
            assertEquals(esperado, resultado);
        }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
