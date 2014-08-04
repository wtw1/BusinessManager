
package model;

import com.google.gson.Gson;

/**
 * This class defines user properties. User properties include a name, password, and inventory.
 * @author Owner
 */
public class User {
    
    private String id;
    private String pw;
    
    /**
     * The InventoryList that this user has.
     */
    public InventoryList inventory;
    
    /**
     *Default constructor.
     */
    public User() {
        id = "123";
        pw = "123";
        
        inventory = new InventoryList();
    }

    /**
     * Setter
     * @param name
     */
    public void SetID(String name)
    {
        this.id = name;
    }

    /**
     * Setter
     * @param name
     */
    public void SetPw(String name)
    {
        this.pw = name;
    }

    /**
     * Getter
     * @return
     */
    public String GetID()
    {
        return this.id;
    }

    /**
     *Getter
     * @return
     */
    public String GetPw()
    {
        return this.pw;
    }
    
    /**
     * Translates this class instance to send over the network.
     * @return
     */
    public String toJson() {
        Gson gson = new Gson();  
        String json = gson.toJson(this); 
        return json;
    }
}
