
package model;

public class User {
    
    private String id;
    private String pw;
    
    public InventoryList inventory;
    
    public User() {
        id = "123";
        pw = "123";
        
        inventory = new InventoryList();
    }
    public void SetID(String name)
    {
        this.id = name;
    }
    public void SetPw(String name)
    {
        this.pw = name;
    }
    public String GetID()
    {
        return this.id;
    }
    public String GetPw()
    {
        return this.pw;
    }
}
