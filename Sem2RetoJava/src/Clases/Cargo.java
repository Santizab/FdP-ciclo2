
package Clases;


public class Cargo {
    private String nombreCargo;
    private String nivelJerarquico;

    public Cargo(String nombreCargo, String nivelJerarquico) {
        this.nombreCargo = nombreCargo;
        this.nivelJerarquico = nivelJerarquico;
    }
    
    

    /**
     * @return the nombreCargo
     */
    public String getNombreCargo() {
        return nombreCargo;
    }

    /**
     * @param nombreCargo the nombreCargo to set
     */
    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    /**
     * @return the nivelJerarquico
     */
    public String getNivelJerarquico() {
        return nivelJerarquico;
    }

    /**
     * @param nivelJerarquico the nivelJerarquico to set
     */
    public void setNivelJerarquico(String nivelJerarquico) {
        this.nivelJerarquico = nivelJerarquico;
    }
    
    
}
