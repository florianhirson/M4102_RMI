package fr.univ_lille.iut.m4102;

import java.util.Scanner;

public class Client {
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		
		TalonClient TC = new TalonClient(in,args[0], Integer.parseInt(args[1]));
		TC.calcul();
	}
}
