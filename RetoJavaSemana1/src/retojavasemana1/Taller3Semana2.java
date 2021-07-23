
package retojavasemana1;

import Clases.DistanciaCorta;
import java.util.Scanner;

/**
 *
 * @author Santiago Zabala
 */
public class Taller3Semana2 {
    public static void main(String[] args) {
        int option;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        boolean firstTime = true;
        double xc1,yc1,xa1,ya1,xch,ych,xc2,yc2,xa2,ya2,dis;
        
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
            System.out.println("| 1. Medir Distancia Total: (1)");
            System.out.println("==================================================");
            System.out.println("| 2. Salir: (2)");
            System.out.println("==================================================");
            System.out.print("Opción: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("Ingrese Coordenada X del celular 1: ");
                    xc1 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada Y del celular 1: ");
                    yc1 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada X del antena 1: ");
                    xa1 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada Y del antena 1: ");
                    ya1 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada X del Central: ");
                    xch = sc.nextDouble();
                    System.out.println("Ingrese Coordenada Y del Central: ");
                    ych = sc.nextDouble();
                    System.out.println("Ingrese Coordenada X del celular 2: ");
                    xc2 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada Y del celular 2: ");
                    yc2 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada X del antena 2: ");
                    xa2 = sc.nextDouble();
                    System.out.println("Ingrese Coordenada Y del antena 2: ");
                    ya2 = sc.nextDouble();
                    dis=DistanciaCorta.obtenerDistanciaTotal(xc1, yc1, xa1, ya1, xch, ych, xc2, yc2, xa2, ya2);
                    System.out.println("Distancia Total: "+dis);
                    case 2:
                    run = false;
                    break;
            } 
        }
    }    
}
