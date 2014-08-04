
package model;

import java.util.ArrayList;

/**
 * This class manages a list of users.
 * @author Owner
 */
public class Users {
    
    /**
     * the list of users
     */
    public ArrayList userslist;  //of user
    
    /**
     *constructor
     */
    public Users() {
        
        userslist = new ArrayList();
 /*      String[] StringArray = new String[3];
        StringArray[0] = "Wayne";
        StringArray[1] = "Jacob";
        StringArray[2] = "Chris";
        for (int i=0; i<3; i++){
            User user = new User();
            user.SetID(StringArray[i]);
            userslist.add(user);
        }*/
    }
    
    /**
     * Gets the user at an index.
     * @param index
     * @return
     */
    public User getUserAtIndex (int index){
        User user = (User)userslist.get(index);
        return user;
    }
    
    /**
     * Adds a user to the list.
     * @param user
     */
    public void addUserToList(User user) {
        userslist.add(user);
    }
    
}
