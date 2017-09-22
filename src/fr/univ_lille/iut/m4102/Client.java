package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static Socket clientSocket = null;
    private static PrintWriter envoi = null;
    private static BufferedReader reception = null;
    
    public Client(String host, int port) {
	try {
	    clientSocket = new Socket(host, port);
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	    System.exit(1);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	
	    try {
			envoi = new PrintWriter(clientSocket.getOutputStream(), true);
			reception = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
    
	public static void main(String[] args) {
		Client client = new Client(args[0], Integer.parseInt(args[1]));
		
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		
		TalonClient TC = new TalonClient(in,clientSocket,envoi,reception);
	}
}
