
package Clases;

public class Radar {
    private static String multarAlcoholemia(double gradoAlcohol){
        String textoMulta;
        if (gradoAlcohol >= 20 && gradoAlcohol< 40){
          textoMulta="suspensión de la licencia de conducción entre seis (6) y doce (12) meses";  
        } else if (gradoAlcohol>=40 && gradoAlcohol< 100){
          textoMulta="suspensión de la Licencia de Conducción entre uno (1) y tres (3) años";
        } else if (gradoAlcohol>=100 && gradoAlcohol< 150){
          textoMulta="suspensión de la Licencia de Conducción entre tres (3) y cinco (5) años, y "
                  + "la obligación de realizar curso de sensibilización, conocimientos y "
                  + "consecuencias de la alcoholemia y drogadicción en centros de "
                  + "rehabilitación debidamente autorizados, por un mínimo de cuarenta (40) horas";  
        } else if (gradoAlcohol>=150){
          textoMulta="suspensión entre cinco (5) y diez (10) años de la Licencia de Conducción, y"
                  + " la obligación de realizar curso de sensibilización, conocimientos y consecuencias "
                  + "de la alcoholemia y drogadicción en centros de rehabilitación debidamente autorizados, "
                  + "por un mínimo de ochenta (80) horas";  
        } else{
          textoMulta="y nada mas"; 
        }
        return textoMulta;
    }
    
    
    public static String multa(double dis1,double dis2,double tiempo,double gradoAlcohol){
        String textoMulta;
        double vel=((dis2-dis1)/tiempo)*3.6;
        if (vel < 21){
          textoMulta="Llamado de atención por baja velocidad";  
        } else if (vel>=21 && vel< 61){
          textoMulta="Normal";
        } else if (vel>=61 && vel< 81){
          textoMulta="Llamado de atención por alta velocidad";  
        } else if (vel>=81 && vel<=120){
          textoMulta="Multa tipo I"+" y "+multarAlcoholemia(gradoAlcohol);  
        } else{
          textoMulta="Multa tipo II, inmovilización del vehículo"+" y "+multarAlcoholemia(gradoAlcohol); 
        }
        return textoMulta;
    }
}
