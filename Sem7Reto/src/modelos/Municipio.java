
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.db.DB;

public class Municipio {
    private Integer id;
    private String nombre;
    private Integer codigo;
    private Departamento departamento;
    private DB db;
    
    public Municipio(){
        db=new DB();
    }

    public Municipio getMunicipioById(Integer id){
        Municipio mun = null;
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT mun.id, mun.nombre, mun.codigo "
                    + "     FROM municipio mun WHERE mun.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un resultado.");
                
                this.id = result.getInt(1);
                this.nombre = result.getString(3);
                this.codigo = result.getInt(4);
                
                mun = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            System.err.println("No se puedo obtener la información del objeto id=" + id + " en la tabla departamento.");
        }
        
        return mun;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
