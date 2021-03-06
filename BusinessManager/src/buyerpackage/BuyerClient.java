
package buyerpackage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;


public class BuyerClient implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    
    private BuyerClientDelegate delegate;
    
    public interface BuyerClientDelegate {
        void newUserAdded(ArrayList x);
    }
    
    public void setDelegate(BuyerClientDelegate delegate) {
        this.delegate = delegate;
    }
    
    
    public BuyerClient(Socket X) {
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
                System.out.println(MESSAGE);
                try {                    
                    ArrayList<User> data = new Gson().fromJson(MESSAGE, new TypeToken<ArrayList<User>>(){}.getType());
                    delegate.newUserAdded(data);
                } catch (Exception e) {System.out.println(e);}
            } else {
                //update user

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
