
package utils;

import java.sql.Connection;

public abstract class Persev {
    private DB db = new DB();

    public Persev() {
    }
    
    public abstract Object find(Integer id);
    public abstract Integer save();
    public abstract void delete();
    
    
    public Connection conectar(){
        return this.db.conectar();
    }
}
