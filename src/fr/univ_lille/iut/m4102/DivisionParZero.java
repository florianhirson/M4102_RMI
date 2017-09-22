package fr.univ_lille.iut.m4102;

public class DivisionParZero extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String err="";
	public DivisionParZero(String err){this.err=err;}
	public String toString(){return err;}

}
