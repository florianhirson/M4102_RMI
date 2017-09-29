package fr.univ_lille.iut.m4102;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	private ServerSocket serveurSocket = null;
	
	public Serveur(int port) {
		try {
			serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void miseEnService() {
		Socket unClient = null;
		
		while (true ) {
			try {
				unClient = serveurSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

			TalonStringFun TC = new TalonStringFun(unClient);
		}
	}
	
	public static void main(String[] args) {
		Serveur serveur = new Serveur(3131);
		
		serveur.miseEnService();
	}

}
