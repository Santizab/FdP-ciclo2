package utils.db;

import java.sql.Connection;


public abstract class Models {
    private DB db = new DB();

    public Models() {
        db = new DB();
    }
    
    public abstract Object find(Integer id);
    public abstract Integer save();
    public abstract void delete();
    
    
    public Connection createConnection(){
        return this.db.createConnection();
    }
    
    public Connection createDBTesting(){
        return this.db.startTestDB();
    }
    
    
}
