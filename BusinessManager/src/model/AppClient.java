
package model;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AppClient {
    
    //Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    
    public AppClient(Socket X) throws Exception {
        //this.SOCK = X;
        run();
    }
        
        
    private void run() throws Exception {
        
        Socket SOCK = new Socket("54.186.128.14",1025);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("Hey Jake");
        
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        
        String MESSAGE = BR.readLine();
        System.out.println(MESSAGE);
        
    }
    
}