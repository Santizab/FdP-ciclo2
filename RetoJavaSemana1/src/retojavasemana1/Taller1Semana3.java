
package retojavasemana1;

import Clases.Calculadora;
import java.util.Scanner;

/**
 *
 * @author Santiago Zabala
 */
public class Taller1Semana3 {
    public static void main(String[] args) {
        int option,numero1,numero2;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        boolean firstTime = true;
        
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
            System.out.println("| Ingresa un numero para realizar la operacion.");
            System.out.println("==================================================");
            System.out.println("| 1. Calcular suma: (1)");
            System.out.println("==================================================");
            System.out.println("| 2. Calcular la resta: (2)");
            System.out.println("==================================================");
            System.out.println("| 3. Calcular multiplicación: (3)");
            System.out.println("==================================================");
            System.out.println("| 4. Calcular división: (4)");
            System.out.println("==================================================");
            System.out.println("| 5. Salir: (5)");
            System.out.println("==================================================");
            System.out.print("Opción: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.print("Ingrese primer numero: ");
                    numero1 = sc.nextInt();
                    System.out.print("Ingrese segundo numero: ");
                    numero2 = sc.nextInt();
                    System.out.println("Suma: "+Calculadora.sumarNumeros(numero1,numero2));
                    break;
                case 2:
                    System.out.print("Ingrese primer numero: ");
                    numero1 = sc.nextInt();
                    System.out.print("Ingrese segundo numero: ");
                    numero2 = sc.nextInt();
                    System.out.println("Resta: "+Calculadora.restarNumeros(numero1,numero2));
                    break;
                case 3:
                    System.out.print("Ingrese primer numero: ");
                    numero1 = sc.nextInt();
                    System.out.print("Ingrese segundo numero: ");
                    numero2 = sc.nextInt();
                    System.out.println("Multiplicacion: "+Calculadora.multiplicarNumeros(numero1,numero2));
                    break;
                case 4:
                    System.out.print("Ingrese primer numero: ");
                    numero1 = sc.nextInt();
                    System.out.print("Ingrese segundo numero: ");
                    numero2 = sc.nextInt();
                    if (numero2==0){
                        System.out.println("Error Matematico al dividir por 0");
                        break;
                    }else {
                    System.out.println("Division: "+Calculadora.dividirNumeros(numero1,numero2));
                    break;
                    }
                case 5:
                    run = false;
                    break;
            }
        }    
    }
}
