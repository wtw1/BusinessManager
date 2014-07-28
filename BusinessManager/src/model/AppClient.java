
package model;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AppClient implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    
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
