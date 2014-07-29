package serverpackage;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;
import model.Users;

public class SOK_1_SERVER {
    
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();
    public static Users serverUsers = new Users(); 
    
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
        System.out.println(UserName);
        
        //convert the json string back to object
        try {
        Gson gson = new Gson();
        User obj = gson.fromJson(UserName, User.class);
	System.out.println(obj.GetID());
        
        serverUsers.addUserToList(obj);
        
        //CurrentUsers.add(UserName);
        //System.out.println(UserName);
        } catch (Exception e) {
		System.out.println(e);
	}
        
        for (int i=0; i < SOK_1_SERVER.ConnectionArray.size(); i++) {
            Socket TEMP_SOCK = (Socket) SOK_1_SERVER.ConnectionArray.get(i);
            PrintWriter OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
            OUT.println("#?!"+UserName);
            OUT.flush();
        }
        
        
    }
   
}
