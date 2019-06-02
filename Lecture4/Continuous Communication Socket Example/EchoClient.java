package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");

        System.out.println("Message received from server");
        System.out.println(response);

        String resp1 = client.sendMessage("hello");
        System.out.println(resp1);
        String resp2 = client.sendMessage("world");
        System.out.println(resp2);
        String resp3 = client.sendMessage("!");
        System.out.println(resp3);
        String resp4 = client.sendMessage(".");
        System.out.println(resp4);
    }
}
