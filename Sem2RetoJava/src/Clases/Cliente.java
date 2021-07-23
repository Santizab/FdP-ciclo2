
package Clases;


public class Cliente extends Persona{
    private String direccionC;
    private String telefono;
    private Empresa empresa;
    

    public Cliente(String direccionC, String telefono, String nombre, String apellidos, String docIdentidad, String eMail) {
        super(nombre, apellidos, docIdentidad, eMail);
        this.direccionC = direccionC;
        this.telefono = telefono;
    }
    
    
    
    public void mostrarDatosCliente(){
        System.out.println("-----Cliente-----");
        System.out.println("Nombre: "+super.getNombre());
        System.out.println("Apellidos: " +super.getApellidos());
        System.out.println("Documento de Identidad: "+super.getDocIdentidad());
        System.out.println("Direccion: "+this.direccionC);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Correo Electronico: "+super.geteMail());
    }

    /**
     * @return the direccionC
     */
    public String getDireccionC() {
        return direccionC;
    }

    /**
     * @param direccionC the direccionC to set
     */
    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
