
package controladores;

import clases.*;
import modelos.*;
import java.util.LinkedList;

public class GeneralCtrl {
    
    private Casos casos;
    
    public GeneralCtrl(){
        this.casos = new Casos();
    }
    
    public LinkedList<RptCasosPorEdad> listCasosPorEdad(){
        LinkedList<RptCasosPorEdad> reporte = this.casos.listCasosPorEdad();
        return reporte;
    }
    
    public LinkedList<RptCasosPorMunicipio> listCasosPorMunicipio(){
        LinkedList<RptCasosPorMunicipio> reporte = this.casos.listCasosPorMunicipio();
        return reporte;
    }
    
    public LinkedList<RptCasosPorDepartamento> listCasosPorDepartamento(){
        LinkedList<RptCasosPorDepartamento> reporte = this.casos.listCasosPorDepartamento();
        return reporte;
    }
    
    public LinkedList<RptCasosPorGenero> listCasosPorGenero(){
        LinkedList<RptCasosPorGenero> reporte = this.casos.listCasosPorGenero();
        return reporte;
    }
    
}
