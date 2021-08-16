
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.*;

public class User extends Persev{
    private DB db = new DB();
    private Integer id;
    private String name;
    private String lastName;

    public User() {
    }
    
    public ArrayList<User> UserList(){
        ArrayList<User> userList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT u.id, u.name, u.last_name FROM user u order by u.id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                User u = new User();
                u.setId( result.getInt("id") );
                u.setName( result.getString("name") );
                u.setLastName(result.getString("last_name") );
                userList.add( u );
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de Usuarios");
        }
        return userList;
    }
    
    
    
    
    @Override
    public Object find(Integer id) {
        User u = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT u.id, u.name, u.last_name FROM user u WHERE u.id = ?";
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
                this.lastName = result.getString("last_name");
                u = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla user");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla user");
        }
        
        return u;
    }

    @Override
    public Integer save() {
        Integer id = null;
        String query;
        try(Connection conn = super.conectar()){
            
            if( this.getId() == null){
                query = "INSERT INTO user (name,last_name) "
                    + "  VALUES (?,?);";
            } else {
                query = "UPDATE user set name=?, last_name=?"
                    + "  WHERE id = ? ";
            }
            
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.getName());
            statement.setString(2, this.getLastName());
            
            if( this.getId() != null)
                statement.setInt(3, this.getId());
            
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla User.");
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
