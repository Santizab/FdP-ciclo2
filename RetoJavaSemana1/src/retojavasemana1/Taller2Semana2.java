
package retojavasemana1;


import Clases.Convertir;
import java.util.Scanner;

/**
 *
 * @author Santiago Zabala
 */
public class Taller2Semana2 {
    public static void main(String[] args) {
        int option,option2,numero1,numero2;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        boolean firstTime = true;
        double y,i,q,r,v,a,y1,cb,cr;
        
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
            System.out.println("| Ingresa una opcion para convertir.");
            System.out.println("==================================================");
            System.out.println("| 1. Convertir de YIQ: (1)");
            System.out.println("==================================================");
            System.out.println("| 2. Convertir de rva: (2)");
            System.out.println("==================================================");
            System.out.println("| 3. Convertir de YCbCr : (3)");
            System.out.println("==================================================");
            System.out.println("| 4. Salir: (4)");
            System.out.println("==================================================");
            System.out.print("Opción: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.print("Ingrese Y: ");
                    y = sc.nextDouble();
                    System.out.print("Ingrese I: ");
                    i = sc.nextDouble();
                    System.out.print("Ingrese Q: ");
                    q = sc.nextDouble();
                    System.out.print("| Ingresa una opcion: ");
                    System.out.print("| 1. YIQ a rva: ");
                    System.out.println("| 2. YIQ a YCbCr: ");
                    System.out.print("Opción: ");
                    option2 = sc.nextInt();
                    switch(option2){
                        case 1:
                            Convertir.convertirYIQaRVA(y,i,q);
                            break;
                        case 2:
                            Convertir.convertirYIQaYCbCr(y, i, q);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Ingrese r: ");
                    r = sc.nextDouble();
                    System.out.print("Ingrese v: ");
                    v = sc.nextDouble();
                    System.out.print("Ingrese a: ");
                    a = sc.nextDouble();
                    System.out.print("| Ingresa una opcion: ");
                    System.out.print("| 1. rva a YIQ: ");
                    System.out.println("| 2. rva a YCbCr: ");
                    System.out.print("Opción: ");
                    option2 = sc.nextInt();
                    switch(option2){
                        case 1:
                            Convertir.convertirRVAaYIQ(r, v, a);
                            break;
                        case 2:
                            Convertir.convertirRVAaYCbCr(r, v, a);
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Ingrese Y: ");
                    y1 = sc.nextDouble();
                    System.out.print("Ingrese Cb: ");
                    cb = sc.nextDouble();
                    System.out.print("Ingrese Cr: ");
                    cr = sc.nextDouble();
                    System.out.print("| Ingresa una opcion: ");
                    System.out.print("| 1. YCbCr a YIQ: ");
                    System.out.println("| 2. YCbCr a rva: ");
                    System.out.print("Opción: ");
                    option2 = sc.nextInt();
                    switch(option2){
                        case 1:
                            Convertir.convertirYCbCraYIQ(y1, cb, cr);
                            break;
                        case 2:
                            Convertir.convertirYCbCraRVA(y1, cb, cr);
                            break;
                    }
                    break;
                case 4:
                    run = false;
                    break;
            }
        }
    }
}
