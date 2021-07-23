/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author sz_21
 */
public class PasajeroAdulto extends PasajeroNino{
    String contacto;
    String correo;

    public PasajeroAdulto(String contacto, String correo, String nombre, String apellido, String tipoDocumento, String numDocumento, String Sexo) {
        super(nombre, apellido, tipoDocumento, numDocumento, Sexo);
        this.contacto = contacto;
        this.correo = correo;
    }
    
    
    
}
