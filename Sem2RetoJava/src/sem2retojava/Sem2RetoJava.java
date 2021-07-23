
package sem2retojava;

import Clases.*;

/**
 *
 * @author Santiago Zabala
 */
public class Sem2RetoJava {

    
    public static void main(String[] args) {
        Cliente cliente1= new Cliente("STfk123", "1234567", "Peter", "Smith", "1234567", "Psmith@email.com");
        Cargo cargoA=new Cargo("Ingeniero", "Medio-Alto");
        Empleado empleado1 = new Empleado(5000000, cargoA, "Jose", "Rojas", "1234567", "JRojas@email.com");
        cliente1.mostrarDatosCliente();
        System.out.println("===============");
        empleado1.mostrarDatosEmpleado();
    }
    
}
