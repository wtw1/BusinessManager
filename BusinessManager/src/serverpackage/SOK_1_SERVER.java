package serverpackage;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SOK_1_SERVER {
    
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();
    
    public static void main(String[] args) throws Exception {
        SOK_1_SERVER SERVER = new SOK_1_SERVER();
        SERVER.run();
    }

    private void run() throws IOException {
        
        try {
            final int PORT = 1025;
            ServerSocket SRVSOCK = new ServerSocket(PORT);
            System.out.println("Waiting for clients...");
        
            while(true) {
                Socket SOCK = SRVSOCK.accept();
                ConnectionArray.add(SOCK); //add to sellers or buyers //dont have dupe sockets
        
                System.out.println("Client connected from: " + SOCK.getLocalAddress().getHostName());
                
                AddUserName(SOCK); //load intal list if seller
                
                Server_Return CHAT = new Server_Return(SOCK);
                Thread X = new Thread(CHAT);
                X.start();
            }
        }
        catch(IOException x) {System.out.println(x);}
        
    }
    
    public static void AddUserName(Socket X)throws IOException {
        Scanner INPUT = new Scanner(X.getInputStream()); 
        String UserName = INPUT.nextLine();
        CurrentUsers.add(UserName);
        System.out.println(UserName);
        
        for (int i=0; i < SOK_1_SERVER.ConnectionArray.size(); i++) {
            Socket TEMP_SOCK = (Socket) SOK_1_SERVER.ConnectionArray.get(i);
            PrintWriter OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
            OUT.println("#?!"+UserName);
            OUT.flush();
        }
        
        
    }
    
//                InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
//                BufferedReader BR = new BufferedReader(IR);
//        
//                System.out.println("Here2");
//                String MESSAGE = BR.readLine();
//                System.out.println(MESSAGE);
//        
//                if (MESSAGE != null) {
//                   PrintStream PS = new PrintStream(SOCK.getOutputStream());
//                   PS.println("Message received!");
//                }
    
    
}
