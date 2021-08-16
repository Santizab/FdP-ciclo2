
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.*;


public class Stories extends Persev{
    
    private DB db = new DB();
    private Integer id;
    private Integer userId;
    private Integer storyTypeID;
    private String title;
    private String shortDescription;
    private String story;
    private String timestamp;

    public Stories() {
    }
    
    public ArrayList<Stories> allStoriesList(){
        ArrayList<Stories> allstoriesList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT s.id, s.user_id, s.story_type_id, s.title, s.short_description, s.story, s.timestamp"
                    + " FROM stories s order by s.id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                Stories s = new Stories();
                s.setId( result.getInt("id") );
                s.setUserId(result.getInt("user_id") );
                s.setStoryTypeID(result.getInt("story_type_id") );
                s.setTitle(result.getString("title"));
                s.setShortDescription(result.getString("short_description"));
                s.setStory(result.getString("story"));
                s.setTimestamp(result.getString("timestamp"));
                allstoriesList.add( s );
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de stories");
        }
        return allstoriesList;
    }
    
    public ArrayList<Stories> userStoriesList(int id){
        ArrayList<Stories> userStoriesList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT s.id, s.user_id, s.story_type_id, s.title, s.short_description, s.story, s.timestamp"
                    + " FROM stories s WHERE s.user_id="+id;
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                Stories s = new Stories();
                s.setId( result.getInt("id") );
                s.setUserId(result.getInt("user_id") );
                s.setStoryTypeID(result.getInt("story_type_id") );
                s.setTitle(result.getString("title"));
                s.setShortDescription(result.getString("short_description"));
                s.setStory(result.getString("story"));
                s.setTimestamp(result.getString("timestamp"));
                userStoriesList.add( s );
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de Usuarios");
        }
        return userStoriesList;
    }
   
    @Override
    public Object find(Integer id) {
        Stories s = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT s.id, s.user_id, s.story_type_id, s.title, s.short_description, s.story, s.timestamp"
                    + " FROM stories s WHERE s.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el id="+id);
                            
                this.setId((Integer) result.getInt("id"));
                this.setUserId((Integer) result.getInt("user_id"));
                this.setStoryTypeID((Integer) result.getInt("story_type_id"));
                this.setTitle(result.getString("title"));
                this.setShortDescription(result.getString("short_description"));
                this.setStory(result.getString("story"));
                this.setTimestamp(result.getString("timestamp"));
                s = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla stories");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla stories");
        }
        
        return s;
    }

    @Override
    public Integer save() {
        Integer id = null;
        String query;
        try(Connection conn = super.conectar()){
            
            if( this.getId() == null){
                query = "INSERT INTO stories (user_id,story_type_id,title,short_description,story,timestamp) "
                    + "  VALUES (?,?,?,?,?,?);";
            } else {
                query = "UPDATE stories set user_id=?, story_type_id=?, title=?, short_description=?, story=?, timestamp=?"
                    + "  WHERE id = ? ";
            }
            
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, this.getUserId());
            statement.setInt(2, this.getStoryTypeID());
            statement.setString(3, this.getTitle());
            statement.setString(4, this.getShortDescription());
            statement.setString(5, this.getStory());
            statement.setString(6, this.getTimestamp());
            
            if( this.getId() != null)
                statement.setInt(7, this.getId());
            
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla stories.");
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
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the storyTypeID
     */
    public Integer getStoryTypeID() {
        return storyTypeID;
    }

    /**
     * @param storyTypeID the storyTypeID to set
     */
    public void setStoryTypeID(Integer storyTypeID) {
        this.storyTypeID = storyTypeID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the shortDescription to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return the story
     */
    public String getStory() {
        return story;
    }

    /**
     * @param story the story to set
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

    