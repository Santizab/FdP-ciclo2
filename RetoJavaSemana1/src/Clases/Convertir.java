
package Clases;

public class Convertir {
    public static void convertirYIQaRVA(double y,double i,double q){
        double r = y+0.955*i+0.618*q;
        double v = y-0.271*i-0.645*q;
        double a = y-1.11*i+1.7*q;
        System.out.println("r="+r+" v="+v+" a="+a);
    }
    
    public static void convertirYIQaYCbCr(double y,double i,double q){
        double r = y+0.955*i+0.618*q;
        double v = y-0.271*i-0.645*q;
        double a = y-1.11*i+1.7*q;
 
        double y1 = 0.299*r+0.587*v+0.114*a;
        double cb = 0.1687*r-0.3313*v-0.5*a;
        double cr = 0.5*r-0.418*v+0.0813*a;
        System.out.println("Y="+y1+" Cb="+cb+" Cr="+cr);
    }
    
    public static void convertirRVAaYIQ(double r,double v,double a){
        double y=0.299*r+0.587*v+0.114*a;
        double i=0.596*r-0.275*v-0.321*a;
        double q=0.212*r-0.528*v+0.311*a;
        System.out.println("Y="+y+" I="+i+" Q="+q);
    }
    
    public static void convertirRVAaYCbCr(double r,double v,double a){
        double y1 = 0.299*r+0.587*v+0.114*a;
        double cb = 0.1687*r-0.3313*v-0.5*a;
        double cr = 0.5*r-0.418*v+0.0813*a;
        System.out.println("Y="+y1+" Cb="+cb+" Cr="+cr);
    }
    
    public static void convertirYCbCraYIQ(double y1,double cb,double cr){
        double r=1*y1+0*cb+1.402*cr;
        double v=1*y1+0.344*cb-0.714*cr;
        double a=1*y1+1.772*cb+0*cr;
        
        double y=0.299*r+0.587*v+0.114*a;
        double i=0.596*r-0.275*v-0.321*a;
        double q=0.212*r-0.528*v+0.311*a;
        System.out.println("Y="+y+" I="+i+" Q="+q);
    }
    
    public static void convertirYCbCraRVA(double y1,double cb,double cr){
        double r=1*y1+0*cb+1.402*cr;
        double v=1*y1+0.344*cb-0.714*cr;
        double a=1*y1+1.772*cb+0*cr;
        System.out.println("r="+r+" v="+v+" a="+a);
    }
}
