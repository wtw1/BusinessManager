
package view.mainframeUI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class AppClient implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    
    User currentUser;
    private SellerClientDelegate delegate;
    
    public interface SellerClientDelegate {
        void updatedSeller(User aUser);
    }
    
    public void setDelegate(SellerClientDelegate delegate) {
        this.delegate = delegate;
    }
    
    
    public AppClient(Socket X) {
        this.SOCK = X;
        
    }
          
    public void run() {
        try {
            try {
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                CheckStream();
            }
            finally {
                SOCK.close();
            }
        }
        catch(Exception X) {System.out.print(X);}
    }
    
    public void CheckStream() {
        while(true) {
            RECEIVE();
        }
    }
    
    public void RECEIVE() {
        if(INPUT.hasNext()){
            String MESSAGE = INPUT.nextLine();
            System.out.println(MESSAGE);
            
            if(MESSAGE.contains("#?!")) {
                //set users
                MESSAGE = MESSAGE.replace("#?!", "");
                ArrayList<User> data = new Gson().fromJson(MESSAGE, new TypeToken<ArrayList<User>>(){}.getType());
                
                for (int i=0;i<data.size();i++) {
                    User aUser = data.get(i);
                    if (aUser.GetID().equals(currentUser.GetID())) {
                        currentUser.inventory = aUser.inventory;
                        this.delegate.updatedSeller(aUser);
                    }
                }
                
            } else {
                //add message
            }
        }
    }
    
    public void SEND(String X) {
        OUT.println(X);
        OUT.flush();
    }
    
    public void DISCONNECT() throws IOException {
        OUT.println("Dicsonnect");
        OUT.flush();
        SOCK.close();
    }
    
    
    
}
