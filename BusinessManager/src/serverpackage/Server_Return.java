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
    Boolean ClosedSock = false;
    
    public Server_Return(Socket X) {
        this.SOCK = X;
    }

    public void CheckConnection() throws IOException {
        System.out.println("sss0");
        if(ClosedSock) {
            System.out.println("sss1");
            for(int i=0;i< SOK_1_SERVER.ConnectionArray.size();i++) {
                if(SOK_1_SERVER.ConnectionArray.get(i) == SOCK) {
                    SOK_1_SERVER.ConnectionArray.remove(i);
                    System.out.println("sss2");
                }
            }
            
            for(int i=0; i<SOK_1_SERVER.ConnectionArray.size();i++) {
                Socket TEMP_SOCK = (Socket)SOK_1_SERVER.ConnectionArray.get(i);
                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() + " disconnected"); //Change to be SOCK.getlocal
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
                    System.out.println("HEHEHSHSH1");
                    if(!INPUT.hasNext()) {
                        ClosedSock = true;
                        CheckConnection();
                        System.out.println("HEHEHSHSH2");
                        return;
                    }
                    CheckConnection();
                    System.out.println("HEHEHSHSH3");
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
