package fr.univ_lille.iut.m4102;

public class Calculatrice {
	
	public Calculatrice() {
		// TODO Auto-generated constructor stub
	}
	
	public double addition(double nb1, double nb2) {
		return nb1 + nb2;
	}
	
	public double soustraction(double nb1, double nb2) {
		return nb1 - nb2;
	}
	
	public double multiplication(double nb1, double nb2) {
		return nb1 * nb2;
	}
	
	public double division(double nb1, double nb2) throws DivisionParZero {
		if(nb2 == 0) throw new DivisionParZero("Division par zero !");
		return nb1 / nb2;
	}
}
