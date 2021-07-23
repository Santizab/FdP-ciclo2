
package retoumlyjavasem1;

import clases.Persona;

/**
 *
 * @author Santiago Zabala
 */
public class RetoUMLyJavaSem1 {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Santiago", 30, "Masculino", "Cllfake123", "Soltero");
        persona1.Despertar();
        persona1.Comer();
        persona1.Caminar();
        persona1.Dormir();
    }
    
}
