
package Clases;

public class DistanciaCorta {
    
    public static double obtenerDistanciaTotal (double xc1,double yc1,double xa1,double ya1,
            double xch,double ych,double xc2,double yc2,double xa2,double ya2){
        double d1 = Math.sqrt((Math.pow(2,xc1-xa1))+(Math.pow(2,yc1-ya1)));
        double d2 = Math.sqrt((Math.pow(2,xa1-xch))+(Math.pow(2,ya1-ych)));
        double d3 = Math.sqrt((Math.pow(2,xch-xa2))+(Math.pow(2,ych-ya2)));
        double d4 = Math.sqrt((Math.pow(2,xa2-xc2))+(Math.pow(2,ya2-yc2)));
        double dt = d1+d2+d3+d4;
        return dt;
    }
}
