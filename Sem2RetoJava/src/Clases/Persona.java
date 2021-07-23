
package Clases;


public class Persona {
    private String nombre;
    private String apellidos;
    private String docIdentidad;
    private String eMail;

    public Persona(String nombre, String apellidos, String docIdentidad, String eMail) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.docIdentidad = docIdentidad;
        this.eMail = eMail;
    }
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the docIdentidad
     */
    public String getDocIdentidad() {
        return docIdentidad;
    }

    /**
     * @param docIdentidad the docIdentidad to set
     */
    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    
}
