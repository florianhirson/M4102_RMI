package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalonCalculatrice implements Runnable{
	private Socket client;
	Calculatrice action = new Calculatrice();

	public TalonCalculatrice(Socket c){
		client=c;
	}

	@Override
	public void run() {
		PrintWriter envoi = null;
		BufferedReader reception = null;
		String op="";
		String tmp="";
		String a="",b="";
		int i=0;
		
		try {
			envoi = new PrintWriter(client.getOutputStream(), true );
		

			reception = new BufferedReader( new
					InputStreamReader(client.getInputStream()));
			
			while(!(tmp = reception.readLine()).equals("=")){
				switch(i){
				case 0:
					a=String.valueOf(tmp);
					break;
				case 1:
					op=String.valueOf(tmp);
					break;
				case 2:
					b=String.valueOf(tmp);
					break;
				default :
					break;
				}
				
				i++;
			}
			
		

		envoi.println(a+" "+op+" "+b+" = "+traitement_ext(a,b,op)+"");
		reception.close();
		envoi.close();
		} catch (IOException | DivisionParZero e1) {
			e1.printStackTrace();
		}

	}

	private double traitement_ext(String a, String b, String op) throws DivisionParZero, FileNotFoundException{
		double resultat;
		switch(op.charAt(0)){
		case '+':
			resultat = action.addition(Double.parseDouble(a),Double.parseDouble(b) );
			break;
			
		case '*':
			resultat = action.multiplication(Double.parseDouble(a),Double.parseDouble(b));
			break;
			
		case '/': 
			try {
				resultat =action.division(Double.parseDouble(a),Double.parseDouble(b));
			} catch (NumberFormatException e1) {
				throw new NumberFormatException("Indiquez un nombre !");
			} catch (DivisionParZero e1) {
				throw new DivisionParZero("Division par zero");
			}
			break;

		case '-': 
			resultat = action.soustraction(Double.parseDouble(a),Double.parseDouble(b));
			break;

		default: 
			throw new NullPointerException("Veuillez indiquer une operande : +-*/");

		}
		return resultat;
	}


}


