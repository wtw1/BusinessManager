
package model;

import com.google.gson.Gson;
import java.util.ArrayList;

public class Users {
    
    public ArrayList userslist;  //of user
    
    public Users() {
        
        userslist = new ArrayList();
        String[] StringArray = new String[3];
        StringArray[0] = "Wayne";
        StringArray[1] = "Jacob";
        StringArray[2] = "Chris";
        for (int i=0; i<3; i++){
            User user = new User();
            user.SetID(StringArray[i]);
            userslist.add(user);
            Gson gson = new Gson();  
            
            System.out.println(gson.toJson(user));  
        }
    }
    
    public User getUserAtIndex (int index){
        User user = (User)userslist.get(index);
        return user;
    }
    
}
