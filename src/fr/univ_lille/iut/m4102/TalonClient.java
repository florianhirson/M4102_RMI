package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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
		this.calcul();
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
