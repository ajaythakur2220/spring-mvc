package com.voca.seve.socket;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by ajay.thakur on 27/05/2016.
 */
public class ClientForSocketConnection {

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {
//        String serverAddress = JOptionPane.showInputDialog(
//                "Enter IP Address of a machine that is\n" +
//                        "running the date service on port 9090:");
        Socket s = new Socket("10.105.44.49", 15313);

        //Send the message to the server
        OutputStream os = s.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        String number = "Hello can you hear me !!!";

        String sendMessage = number + "\n";
        bw.write(sendMessage);
        bw.flush();

        System.out.println("Message sent to the server : "+sendMessage);


        System.out.println("++++++++Connection Live ++++++ " +  s.isConnected() + "Timew" + new Date());
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }

}
