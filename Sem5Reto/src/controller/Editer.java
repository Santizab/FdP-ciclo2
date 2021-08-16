
package controller;

import java.util.ArrayList;
import models.*;

public class Editer {
     public void saveStoryType(Integer id, String name) throws Exception{
        StoryType new_st = null;
        
        if( name.equals("") ){
            throw new Exception("El campo nombre no puede estar vacio.");
        }
        
        if( name.length() > 50 ){
            throw new Exception("El campo nombre solo puede tener 100 caracteres.");
        }
        
        if( id == null ){
            new_st = new StoryType();
        } else {
            new_st = (StoryType) new StoryType().find(id);
        }
        
        new_st.setName(name);
        
        new_st.save();
     }
     
     public void saveUser(Integer id, String name, String lastName) throws Exception{
        User newU = null;
        
        if( name.equals("") || lastName.equals("")){
            throw new Exception("Debe llenar ambos campos.");
        }
        
        if( name.length() > 50 ){
            throw new Exception("El campo nombre solo puede tener 50 caracteres.");
        }
        
        if( lastName.length() > 50 ){
            throw new Exception("El campo apellido solo puede tener 50 caracteres.");
        }
        
        if( id == null ){
            newU = new User();
        } else {
            newU = (User) new User().find(id);
        }
        
        newU.setName(name);
        newU.setLastName(lastName);
        try{
            newU.save();

        }catch(Exception e){
            e.printStackTrace();
        }
     }
     
     public void saveStory(Integer id, Integer userId, Integer storyTypeId, String title, 
                            String shortDescription, String story, String timestamp ) throws Exception{
        Stories newS = null;
        
        if( title.equals("") || shortDescription.equals("") || story.equals("")){
            throw new Exception("Debe llenar todos los campos.");
        }
        
        if( title.length() > 50  ){
            throw new Exception("El campo Titulo solo puede tener 50 caracteres.");
        }
        
        if( shortDescription.length() > 100 ){
            throw new Exception("El campo Descripcion Corta solo puede tener 100 caracteres.");
        }
        
        if( id == null ){
            newS = new Stories();
        } else {
            newS = (Stories) new Stories().find(id);
        }
        
        newS.setUserId(userId);
        newS.setStoryTypeID(storyTypeId);
        newS.setTitle(title);
        newS.setShortDescription(shortDescription);
        newS.setStory(story);
        newS.setTimestamp(timestamp);
        try{
            newS.save();

        }catch(Exception e){
            e.printStackTrace();
        }
     }
     
     public ArrayList<User> getUserList(){
        ArrayList<User> uList;
        uList = new User().UserList();
        return uList;
     }
     
     public ArrayList<StoryType> getStoryTypeList(){
        ArrayList<StoryType> stList;
        stList = new StoryType().StoryTypeList();
        return stList;
     }
     
     public ArrayList<Stories> getAllStoriesList(){
        ArrayList<Stories> allsList;
        allsList = new Stories().allStoriesList();
        return allsList;
     }
     
     public ArrayList<Stories> getUserStoriesList(Integer id){
        ArrayList<Stories> usList;
        usList = new Stories().userStoriesList(id);
        return usList;
     }
     
}
