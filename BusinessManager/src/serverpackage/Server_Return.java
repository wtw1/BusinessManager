package serverpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Server_Return implements Runnable{
    
    //Globals
    Socket SOCK;
    private Scanner INPUT;
    private PrintWriter OUT;
    String MESSAGE = "";
    
    public Server_Return(Socket X) {
        this.SOCK = X;
    }

    public void CheckConnection() throws IOException {
        if(!SOCK.isConnected()) {
            
            for(int i=0;i< SOK_1_SERVER.ConnectionArray.size();i++) {
                if(SOK_1_SERVER.ConnectionArray.get(i) == SOCK)
                    SOK_1_SERVER.ConnectionArray.remove(i);
            }
            
            for(int i=0; i<SOK_1_SERVER.ConnectionArray.size();i++) {
                Socket TEMP_SOCK = (Socket)SOK_1_SERVER.ConnectionArray.get(i);
                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() + " disconnected");
                TEMP_OUT.flush();
                
                System.out.println(TEMP_SOCK.getLocalAddress().getHostName() + " disconnected");
            }
            
        }
    }
    
    public void run() {
        try {
            try {
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                
                while(true){
                    CheckConnection();
                    
                    if(!INPUT.hasNext()) {
                        return;
                    }
                    MESSAGE = INPUT.nextLine();
                    
                    System.out.println("Client Said: " + MESSAGE); //after intial push
                    
                    for (int i=0; i<SOK_1_SERVER.ConnectionArray.size();i++) {
                        Socket TEMP_SOCK = SOK_1_SERVER.ConnectionArray.get(i);
                        PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to: " + TEMP_SOCK.getLocalAddress().getHostName()); 
                    }
                    
                }
            }
            finally {
                SOCK.close();
            }
        }
        catch (Exception X){System.out.println(X);}
    }
    
}
