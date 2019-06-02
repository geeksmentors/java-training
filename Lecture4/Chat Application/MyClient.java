package com.projects;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyClient implements ActionListener
    {
        Socket s;

        DataInputStream dis;
        DataOutputStream dos;

        JButton sendButton, logoutButton,loginButton, exitButton;
        JFrame chatWindow;
        JTextArea txtBroadcast;
        JTextArea txtMessage;
        JList usersList;

        //////////////////////////
        public void displayGUI()
        {
            chatWindow=new JFrame();
            txtBroadcast=new JTextArea(5,30);
            txtBroadcast.setEditable(false);
            txtMessage=new JTextArea(2,20);
            usersList=new JList();

            sendButton=new JButton("Send");
            logoutButton=new JButton("Log out");
            loginButton=new JButton("Log in");
            exitButton=new JButton("Exit");

            JPanel center1=new JPanel();
            center1.setLayout(new BorderLayout());
            center1.add(new JLabel("Broad Cast messages from all online users",JLabel.CENTER),"North");
            center1.add(new JScrollPane(txtBroadcast),"Center");

            JPanel south1=new JPanel();
            south1.setLayout(new FlowLayout());
            south1.add(new JScrollPane(txtMessage));
            south1.add(sendButton);

            JPanel south2=new JPanel();
            south2.setLayout(new FlowLayout());
            south2.add(loginButton);
            south2.add(logoutButton);
            south2.add(exitButton);

            JPanel south=new JPanel();
            south.setLayout(new GridLayout(2,1));
            south.add(south1);
            south.add(south2);

            JPanel east=new JPanel();
            east.setLayout(new BorderLayout());
            east.add(new JLabel("Online Users",JLabel.CENTER),"East");
            east.add(new JScrollPane(usersList),"South");

            chatWindow.add(east,"East");

            chatWindow.add(center1,"Center");
            chatWindow.add(south,"South");

            chatWindow.pack();
            chatWindow.setTitle("Login for Chat");
            chatWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            chatWindow.setVisible(true);
            sendButton.addActionListener(this);
            logoutButton.addActionListener(this);
            loginButton.addActionListener(this);
            exitButton.addActionListener(this);
            logoutButton.setEnabled(false);
            loginButton.setEnabled(true);
            txtMessage.addFocusListener(new FocusAdapter()
            {public void focusGained(FocusEvent fe){txtMessage.selectAll();}});

            chatWindow.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent ev)
                {
                    if(s!=null)
                    {
                        JOptionPane.showMessageDialog(chatWindow,"u r logged out right now. ","Exit",JOptionPane.INFORMATION_MESSAGE);
                        logoutSession();
                    }
                    System.exit(0);
                }
            });
        }
        ///////////////////////////
        public void actionPerformed(ActionEvent ev)
        {
            JButton temp=(JButton)ev.getSource();
            if(temp==sendButton)
            {
                if(s==null)
                {JOptionPane.showMessageDialog(chatWindow,"u r not logged in. plz login first"); return;}
                try{
                    dos.writeUTF(txtMessage.getText());
                    txtMessage.setText("");
                }
                catch(Exception excp){txtBroadcast.append("\nsend button click :"+excp);}
            }
            if(temp==loginButton)
            {
                String uname=JOptionPane.showInputDialog(chatWindow,"Enter Your lovely nick name: ");
                if(uname!=null)
                    clientChat(uname);
            }
            if(temp==logoutButton)
            {
                if(s!=null)
                    logoutSession();
            }
            if(temp==exitButton)
            {
                if(s!=null)
                {
                    JOptionPane.showMessageDialog(chatWindow,"u r logged out right now. ","Exit",JOptionPane.INFORMATION_MESSAGE);
                    logoutSession();
                }
                System.exit(0);
            }
        }
        ///////////////////////////
        public void logoutSession()
        {
            if(s==null) return;
            try{
                dos.writeUTF(MyServer.LOGOUT_MESSAGE);
                Thread.sleep(500);
                s=null;
            }
            catch(Exception e){txtBroadcast.append("\n inside logoutSession Method"+e);}

            logoutButton.setEnabled(false);
            loginButton.setEnabled(true);
            chatWindow.setTitle("Login for Chat");
        }
        //////////////////////////
        public void clientChat(String uname)
        {
            try{
                s=new Socket(InetAddress.getLocalHost(),MyServer.PORT);
                dis=new DataInputStream(s.getInputStream());
                dos=new DataOutputStream(s.getOutputStream());
                ClientThread ct=new ClientThread(dis,this);
                Thread t1=new Thread(ct);
                t1.start();
                dos.writeUTF(uname);
                chatWindow.setTitle(uname+" Chat Window");
            }
            catch(Exception e){txtBroadcast.append("\nClient Constructor " +e);}
            logoutButton.setEnabled(true);
            loginButton.setEnabled(false);
        }
        ///////////////////////////////
        public MyClient()
        {
            displayGUI();
//	clientChat();
        }
        ///////////////////////////////
        public static void main(String []args)
        {
            new MyClient();
        }
//////////////////////////
    }
