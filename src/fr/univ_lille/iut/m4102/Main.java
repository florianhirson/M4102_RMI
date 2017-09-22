package fr.univ_lille.iut.m4102;

public class Main {

	public static void main(String [] args) throws DivisionParZero{
		Calculatrice c = new Calculatrice();
		
		System.out.println("add : "+c.addition(1, 1)+" sub :"+c.soustraction(1, 10));
		System.out.println(" mult : "+c.multiplication(2, 2));
		System.out.println("division OK: "+c.division(4, 2));
		System.out.println("division err : "+c.division(1, 0));
	}


}
