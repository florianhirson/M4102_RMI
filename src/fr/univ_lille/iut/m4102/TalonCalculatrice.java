package fr.univ_lille.iut.m4102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalonCalculatrice implements Runnable{
	
	Socket unClient;
	
	public TalonCalculatrice(Socket unClient) {
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
			
			Calculatrice cal = new Calculatrice();
			String line = reception.readLine();
			String in1="";
			String in2="";
			String op="";
			
			for(int i=0; i<line.length();i++){
				if(op.equals("")){
					if(line.charAt(i)=='.' ||line.charAt(i)=='0' || line.charAt(i)=='1' || line.charAt(i)=='2' || line.charAt(i)=='3' || line.charAt(i)=='4' || line.charAt(i)=='5' || line.charAt(i)=='6' || line.charAt(i)=='7' || line.charAt(i)=='8' || line.charAt(i)=='9'){
						in1=in1+line.charAt(i);
					}
				}else {
					if(line.charAt(i)=='.' ||line.charAt(i)=='0' || line.charAt(i)=='1' || line.charAt(i)=='2' || line.charAt(i)=='3' || line.charAt(i)=='4' || line.charAt(i)=='5' || line.charAt(i)=='6' || line.charAt(i)=='7' || line.charAt(i)=='8' || line.charAt(i)=='9'){
						in2=in2+line.charAt(i);
					}
				}
				
				if(line.charAt(i)=='*' ||line.charAt(i)=='-'||line.charAt(i)=='+'||line.charAt(i)=='/'||line.charAt(i)=='%'){
					op=op+line.charAt(i);
				}
			}
			
			//verification
			if(op.length()>1 || in1.lastIndexOf('.')!=in1.indexOf('.') || in2.lastIndexOf('.')!=in2.indexOf('.')){
				String message = "Le format entré n'est pas valide (FORMAT: XX.X+X.XX) \n  "+ in1 +" / "+op+" / "+in2;
				envoi.println(message);
			}else if(op.charAt(0)=='/' && Double.parseDouble(in2)==0.0){
				String message = "Impossible de diviser par 0.";
				envoi.println(message);
			}else{
				cal.setNb1(Double.parseDouble(in1));
				cal.setNb2(Double.parseDouble(in2));
				cal.setOp(op.charAt(0));
				cal.calcul();
			
				String message = "Result of : "+cal.getNb1() +" "+ cal.getOp() +" "+ cal.getNb2() + " = "+cal.getOut();
				envoi.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}

