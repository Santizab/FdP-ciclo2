
package Clases;


public class Empleado extends Persona{
    private double salario;
    private Cargo cargo;

    public Empleado(double salario, Cargo cargo, String nombre, String apellidos, String docIdentidad, String eMail) {
        super(nombre, apellidos, docIdentidad, eMail);
        this.salario = salario;
        this.cargo = cargo;
    }
    
    
    
    
    
    public void mostrarDatosEmpleado(){
        System.out.println("-----Empleado-----");
        System.out.println("Nombre: "+super.getNombre());
        System.out.println("Apellidos: " +super.getApellidos());
        System.out.println("Documento de Identidad: "+super.getDocIdentidad());
        System.out.println("Cargo: "+this.cargo.getNombreCargo());
        System.out.println("Salario: "+this.salario);
        System.out.println("Correo Electronico: "+super.geteMail());
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
