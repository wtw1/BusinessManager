
package model;

public class User {
    
    public String id;
    public String pw;
    
    public InventoryList inventory;
    
    public User() {
        id = "123";
        pw = "123";
        
        inventory = new InventoryList();
    }
    
}
