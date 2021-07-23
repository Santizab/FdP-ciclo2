
package retojavasemana1;

import Clases.Radar;
import java.util.Scanner;

/**
 *
 * @author Santiago Zabala
 */
public class Taller3Semana3 {
    public static void main(String[] args) {
        int option;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        boolean firstTime = true;
        double dis1,dis2,tiempo,gradoAlcohol;
        
        while(run){
            
            if( firstTime ){
                firstTime = false;
            } else {
                System.out.println();
                System.out.println("----Presione enter para continuar---");
                new Scanner(System.in).nextLine();
            }
            
            System.out.println("==================================================");
            System.out.println("| Menu");
            System.out.println("==================================================");
            System.out.println("| Ingresa una opcion para continuar.");
            System.out.println("==================================================");
            System.out.println("| 1. Consultar Multa: (1)");
            System.out.println("==================================================");
            System.out.println("| 2. Salir: (2)");
            System.out.println("==================================================");
            System.out.print("Opción: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("Inserte la primer distancia (m): ");
                    dis1 = sc.nextDouble();
                    System.out.println("Inserte la segunda distancia (m): ");
                    dis2 = sc.nextDouble();
                    System.out.println("Ingrese tiempo (s): ");
                    tiempo = sc.nextDouble();
                    System.out.println("Grado de Alcohol: ");
                    gradoAlcohol = sc.nextDouble();
                    System.out.println("Multa: "+Radar.multa(dis1, dis2, tiempo, gradoAlcohol));
                case 2:
                    run = false;
                    break;
            }        
        } 
    }    
}
