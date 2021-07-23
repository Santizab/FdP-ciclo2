
package Clases;


public class EmpleadoAdministrativo {
    private String categoria;
    private String empleadosSubordinados;
    Empleado empleado;

    public EmpleadoAdministrativo(String categoria, String empleadosSubordinados, Empleado empleado) {
        this.categoria = categoria;
        this.empleadosSubordinados = empleadosSubordinados;
        this.empleado = empleado;
    }

    
    

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the empleadosSubordinados
     */
    public String getEmpleadosSubordinados() {
        return empleadosSubordinados;
    }

    /**
     * @param empleadosSubordinados the empleadosSubordinados to set
     */
    public void setEmpleadosSubordinados(String empleadosSubordinados) {
        this.empleadosSubordinados = empleadosSubordinados;
    }
    
}
