
package controller;

import java.util.ArrayList;
import java.util.List;
import models.Departamento;
import models.GeneralModel;


public class DepartamentoController {
    
    
    public void pruebaDb() throws Exception {
        Departamento dep = (Departamento) new Departamento().find(1);
        dep.setCodigo(10);
        dep.save();
        System.out.println( dep.getCodigo());
        
        
        dep = (Departamento) new Departamento().find(1);
        System.out.println( dep.getCodigo());
    }
    
    
    public List<Departamento> getDepartamentoList(){
        List<Departamento> depList;
        
        depList = new GeneralModel().getDepartamentoList();
        
        return depList;
    }
    
    
    public void deleteDepartamento(Integer id){
        Departamento dep = (Departamento) new Departamento().find(id);
        dep.delete();
    }
    
    
    public void saveDepartamento(Integer id, String name, String code) throws Exception{
        int codigo = 0;
        Departamento new_dep = null;
        
        if( name.equals("") ){
            throw new Exception("El campo nombre no puede estar vacio.");
        }
        
        if( name.length() > 100 ){
            throw new Exception("El campo nombre solo puede tener 100 caracteres.");
        }
        
        try{
            codigo = Integer.parseInt(code);
        } catch(NumberFormatException e){
            throw new Exception("El campo código debe ser un número.");
        }
        
        if( id == null ){
            Departamento validar_dep = (Departamento) new Departamento().findByCode(codigo);
            if( validar_dep != null){
                throw new Exception("El departameto con el código " + codigo + " ya exite.");
            }
            
            new_dep = new Departamento();
        } else {
            new_dep = (Departamento) new Departamento().find(id);
        }
        
        new_dep.setCodigo( codigo );
        new_dep.setNombre(name);
        new_dep.save();
            
        
    }
    
    
}
