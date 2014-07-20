
package model;

import java.util.ArrayList;

public class Users {
    
    public ArrayList userslist;  //of user
    
    public Users() {
        
        userslist = new ArrayList();
        
        for (int i=0; i<3; i++){
            User user = new User();
            user.id = Integer.toString(i);
            userslist.add(user);
        }
    }
    
    public User getUserAtIndex (int index){
        User user = (User)userslist.get(index);
        return user;
    }
    
}
