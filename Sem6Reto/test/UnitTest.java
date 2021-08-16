/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.DepartamentoController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import models.Departamento;
import models.GeneralModel;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.db.DBConf;

/**
 *
 * @author sz_21
 */
public class UnitTest {
    
    DepartamentoController depCtr = new DepartamentoController();
    
    public UnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBConf.testMode = true;
        new GeneralModel().startDbTest();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1ObtenerDepartamentos(){
       List<Departamento> DepList = depCtr.getDepartamentoList();
        
       if( DepList.size() != 33 )
            assertTrue(false);
        
       for(Departamento dep : DepList){
            if( dep.getId() < 1 || dep.getId() > 33)
                assertTrue(false);
       
        }
    }
   
   @Test 
   public void test2CrearNuevoDepartamento() throws Exception{
       List<Departamento> DepList = depCtr.getDepartamentoList();
       int numRegistros=DepList.size();
       depCtr.saveDepartamento(null,"panama", "100");
       List<Departamento> DepList2 = depCtr.getDepartamentoList();
       Assert.assertNotEquals(numRegistros,DepList2.size());
       
   }
   
   @Test
   public void test3EditarDepartamento() throws Exception{
       List<Departamento> DepList = depCtr.getDepartamentoList();
       String nombreOriginal = DepList.get(5).getNombre();
       
       depCtr.saveDepartamento(6,"Nuevo Caldas", "17");
       List<Departamento> DepList2 = depCtr.getDepartamentoList();
       String nombreNuevo = DepList2.get(5).getNombre();
       
       Assert.assertNotEquals(nombreOriginal,nombreNuevo);
   }
   
   @Test
   public void test4EliminarDepartamento(){
       List<Departamento> DepList = depCtr.getDepartamentoList();
       
       depCtr.deleteDepartamento(6);
       List<Departamento> DepList2 = depCtr.getDepartamentoList();
       Assert.assertNotEquals(DepList.size(),DepList2.size());
       
   }
   
}
