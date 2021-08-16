
package modelos;

import clases.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import utils.db.DB;


public class Casos {
    private Integer id;
    private Date fecha_reporte_web;
    private Date fecha_notificacion;
    private Integer edad;
    private String sexo;
    private String tipo_contagio;
    private String ubicacion;
    private String estado;
    private String pais_importado;
    private String recuperado;
    private Date fecha_inicio_sintomas;
    private Date fecha_diagnostico;
    private Date fecha_recuperacion;
    private Date fecha_muerte;
    private Municipio municipio;
    private DB db;

    
    public Casos(){
        db=new DB();
    }
    
    public LinkedList<RptCasosPorEdad> listCasosPorEdad(){
        LinkedList<RptCasosPorEdad> reporte = new LinkedList<>();
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT c.edad, count(c.edad) "
                    + "FROM casos c "
                    + "GROUP BY c.edad";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                RptCasosPorEdad ed = new RptCasosPorEdad();
                String edad=result.getString(1);
                int total = result.getInt(2);
                ed.setEdad(edad);
                ed.setNumCasosPorEdad(total);
                reporte.add(ed);
                
            }
            return reporte;
            
        }catch(Exception e){
            return reporte;
        }
        
    }
    
    public LinkedList<RptCasosPorMunicipio> listCasosPorMunicipio(){
        LinkedList<RptCasosPorMunicipio> reporte = new LinkedList<>();
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT mun.nombre, COUNT(mun.nombre) "
                    + "FROM casos c "
                    + "LEFT JOIN municipio mun ON c.municipio_id=mun.id "
                    + "GROUP BY mun.nombre";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                RptCasosPorMunicipio mun = new RptCasosPorMunicipio();
                String municipio=result.getString(1);
                int total = result.getInt(2);
                mun.setNombreMun(municipio);
                mun.setNumCasosPorMunicipio(total);
                reporte.add(mun);
                
            }
            return reporte;
            
        }catch(Exception e){
            return reporte;
        }
        
    }
    
    public LinkedList<RptCasosPorDepartamento> listCasosPorDepartamento(){
        LinkedList<RptCasosPorDepartamento> reporte = new LinkedList<>();
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT dep.nombre, count(dep.nombre) "
                    + "FROM casos c  "
                    + "LEFT JOIN municipio mun ON c.municipio_id=mun.id "
                    + "LEFT JOIN departamento dep ON mun.departamento_id=dep.id "
                    + "GROUP BY dep.nombre";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                RptCasosPorDepartamento dep = new RptCasosPorDepartamento();
                String departamento=result.getString(1);
                int total = result.getInt(2);
                dep.setNombreDep(departamento);
                dep.setNumCasosPorDepartamento(total);
                reporte.add(dep);
                
            }
            return reporte;
            
        }catch(Exception e){
            return reporte;
        }
        
    }
    
    public LinkedList<RptCasosPorGenero> listCasosPorGenero(){
        LinkedList<RptCasosPorGenero> reporte = new LinkedList<>();
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT c.sexo, COUNT(c.sexo) "
                    + "FROM casos c "
                    + "GROUP BY c.sexo";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                RptCasosPorGenero gen = new RptCasosPorGenero();
                String genero=result.getString(1);
                int total = result.getInt(2);
                gen.setGenero(genero);
                gen.setNumCasosPorGenero(total);
                reporte.add(gen);
                
            }
            return reporte;
            
        }catch(Exception e){
            return reporte;
        }
        
    }
    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the fecha_reporte_web
     */
    public Date getFecha_reporte_web() {
        return fecha_reporte_web;
    }

    /**
     * @param fecha_reporte_web the fecha_reporte_web to set
     */
    public void setFecha_reporte_web(Date fecha_reporte_web) {
        this.fecha_reporte_web = fecha_reporte_web;
    }

    /**
     * @return the fecha_notificacion
     */
    public Date getFecha_notificacion() {
        return fecha_notificacion;
    }

    /**
     * @param fecha_notificacion the fecha_notificacion to set
     */
    public void setFecha_notificacion(Date fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tipo_contagio
     */
    public String getTipo_contagio() {
        return tipo_contagio;
    }

    /**
     * @param tipo_contagio the tipo_contagio to set
     */
    public void setTipo_contagio(String tipo_contagio) {
        this.tipo_contagio = tipo_contagio;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the pais_importado
     */
    public String getPais_importado() {
        return pais_importado;
    }

    /**
     * @param pais_importado the pais_importado to set
     */
    public void setPais_importado(String pais_importado) {
        this.pais_importado = pais_importado;
    }

    /**
     * @return the recuperado
     */
    public String getRecuperado() {
        return recuperado;
    }

    /**
     * @param recuperado the recuperado to set
     */
    public void setRecuperado(String recuperado) {
        this.recuperado = recuperado;
    }

    /**
     * @return the fecha_inicio_sintomas
     */
    public Date getFecha_inicio_sintomas() {
        return fecha_inicio_sintomas;
    }

    /**
     * @param fecha_inicio_sintomas the fecha_inicio_sintomas to set
     */
    public void setFecha_inicio_sintomas(Date fecha_inicio_sintomas) {
        this.fecha_inicio_sintomas = fecha_inicio_sintomas;
    }

    /**
     * @return the fecha_diagnostico
     */
    public Date getFecha_diagnostico() {
        return fecha_diagnostico;
    }

    /**
     * @param fecha_diagnostico the fecha_diagnostico to set
     */
    public void setFecha_diagnostico(Date fecha_diagnostico) {
        this.fecha_diagnostico = fecha_diagnostico;
    }

    /**
     * @return the fecha_recuperacion
     */
    public Date getFecha_recuperacion() {
        return fecha_recuperacion;
    }

    /**
     * @param fecha_recuperacion the fecha_recuperacion to set
     */
    public void setFecha_recuperacion(Date fecha_recuperacion) {
        this.fecha_recuperacion = fecha_recuperacion;
    }

    /**
     * @return the fecha_muerte
     */
    public Date getFecha_muerte() {
        return fecha_muerte;
    }

    /**
     * @param fecha_muerte the fecha_muerte to set
     */
    public void setFecha_muerte(Date fecha_muerte) {
        this.fecha_muerte = fecha_muerte;
    }

    /**
     * @return the municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
