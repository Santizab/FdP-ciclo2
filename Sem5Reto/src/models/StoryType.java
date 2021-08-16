
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.*;

public class StoryType extends Persev{
    private DB db = new DB();
    private Integer id;
    private String name;

    public StoryType() {
    }
    
    public ArrayList<StoryType> StoryTypeList(){
        ArrayList<StoryType> stList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT st.id, st.name FROM story_type st order by st.id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                StoryType st = new StoryType();
                st.setId( result.getInt("id") );
                st.setName( result.getString("name") );
                stList.add( st );
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de StoryType");
        }
        
        return stList;
    }
    

    @Override
    public Object find(Integer id) {
        StoryType st = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT st.id, st.name FROM story_type st WHERE st.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el id="+id);
                            
                this.id = result.getInt("id");
                this.name = result.getString("name");
                st = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla story_type");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla story_type");
        }
        
        return st;
    }

    @Override
    public Integer save() {
        Integer id = null;
        String query;
        try(Connection conn = super.conectar()){
            
            if( this.getId() == null){
                query = "INSERT INTO story_type (name) "
                    + "  VALUES (?);";
            } else {
                query = "UPDATE story_type set name=?"
                    + "  WHERE id = ? ";
            }
            
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.getName());
            
            if( this.getId() != null)
                statement.setInt(2, this.getId());
            
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla story_type.");
        }
        
        return id;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the db
     */
    public DB getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(DB db) {
        this.db = db;
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
    public String getName() {
        return name;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
