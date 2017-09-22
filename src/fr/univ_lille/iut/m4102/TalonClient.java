package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalonClient {
	private String in;
	private Socket clientSocket = null;
    private PrintWriter envoi = null;
    private BufferedReader reception = null;
    
	public TalonClient(String in, Socket clientSocket, PrintWriter envoi, BufferedReader reception) {
		this.in = in;
		this.clientSocket = clientSocket;
		this.envoi = envoi;
		this.reception = reception;
	}
	
	public TalonClient(String in,String host, int port) {
		this.in =in;
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
    
	public String envoyer(String message) {
		    envoi.println(message);
			    
			    try {
					return reception.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			    return null;
	}
	
	public void calcul(){
		String reponse = envoyer(in);
		System.out.println(reponse);
	}
    

}
