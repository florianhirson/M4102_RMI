package fr.univ_lille.iut.m4102;

public class Calculatrice {
	private Double nb1;
	private Double nb2;
	private char op;
	private Double out;
	
	public Calculatrice(Double nb1, Double nb2, char op) {
		this.nb1 = nb1;
		this.nb2 = nb2;
		this.op = op;
		this.out = 0.0;
	}
	
	public Calculatrice() {
		this.nb1 = 0.0;
		this.nb2 = 0.0;
		this.op = '+';
		this.out = 0.0;
	}

	public Double getNb1() {
		return nb1;
	}
	public void setNb1(Double nb1) {
		this.nb1 = nb1;
	}
	public Double getNb2() {
		return nb2;
	}
	public void setNb2(Double nb2) {
		this.nb2 = nb2;
	}
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public Double getOut() {
		return out;
	}
	public void setOut(Double out) {
		this.out = out;
	}
	
	public void calcul(){
		switch (this.op)
		{
		  case '+':
			this.setOut(this.getNb1()+this.getNb2());
		    break;
		  case '-':
			  this.setOut(this.getNb1()-this.getNb2());
		    break;
		  case '*':
			  this.setOut(this.getNb1()*this.getNb2());
			    break;
		  case '/':
			  if(this.getNb2()==0.0){
				  System.out.println("Impossible de diviser par 0.");
			  }else{
				  this.setOut(this.getNb1()/this.getNb2());
			  }
		    break;
		  case '%':
			  this.setOut(this.getNb1()%this.getNb2());
			    break;
		  default:
		    System.out.println("L'opérateur n'est pas valide.");
		}
	}
	
}

