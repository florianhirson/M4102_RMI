package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalonStringFun implements Runnable{
Socket unClient;
	
	public TalonStringFun(Socket unClient) {
		this.unClient = unClient;
		this.run();
	}
	
	@Override
	public void run() {
		PrintWriter envoi = null;
		BufferedReader reception = null;
		try {
	
			envoi = new PrintWriter(unClient.getOutputStream(), true);
			
			reception = new BufferedReader(new InputStreamReader(unClient.getInputStream()));
			String acceuil = "Bonjour ! 1 [phrase] pour enlever les r ou R\n 2 [phrase] pour remplacer les voyelles par des chiffres";
			envoi.println(acceuil);
			StringFun sf = new StringFun();
			String line = reception.readLine();
			System.out.println(line);
			String message ="";
			if(line.charAt(0)=='1'){
				 message = sf.asphyxie(line);
			}else if(line.charAt(0)=='2'){
				 message = sf.leet(line);
			}else{
				 message = "Veuillez mettre une option en premier carac (1 ou 2)";
			}
			
			envoi.println(message);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (PasDair e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
