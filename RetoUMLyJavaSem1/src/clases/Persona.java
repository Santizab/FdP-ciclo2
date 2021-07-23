
package clases;

public class Persona {
    private String nombre;
    private int edad;
    private String genero;
    private String direccion;
    private String estadoCivil;

    public Persona(String nombre, int edad, String genero, String direccion, String estadoCivil) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
    }

    public void Despertar(){
        System.out.println(this.nombre+" se desperto!");
    }
    public void Comer(){
        System.out.println(this.nombre+" esta comiendo!");
    }
    public void Caminar(){
        System.out.println(this.nombre+" esta caminando!");
    }
    public void Dormir(){
        System.out.println(this.nombre+" se durmio!");
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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
}
