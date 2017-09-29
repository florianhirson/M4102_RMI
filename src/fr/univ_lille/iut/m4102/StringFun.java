package fr.univ_lille.iut.m4102;

public class StringFun {
	
	/**
	* renvoie la chaîne de caractères après avoir surprimé les caractères r et R
	* si la chaîne fournie ne contient pas ces caractères,
	* l'exception PasDair est levée
	*/
	public String asphyxie(String chaine) throws PasDair {
		String clean = "";
		boolean asphyxie = true;
		for (int i = 0; i < chaine.length(); i++) {
	        if (chaine.charAt(i) != 'r' && chaine.charAt(i) != 'R') {
	            clean += chaine.charAt(i);
	        } else {
	        	asphyxie = false;
	        }
	    }
		if(asphyxie) {
			throw new PasDair("J'étouffe !!");
		}
		return clean;
	
	
	}
	/**
	* transforme la chaine fournie en remplacant les voyelles par des chiffres
	*/
	public String leet(String chaine) {
		String clean = "";
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);
	        switch(c) {
	        case 'a' : clean += "1";
	        	break;
	        case 'e' : clean += "2";
	        	break;
	        case 'i' : clean += "3";
	        	break;
	        case 'o' : clean += "4";
	        	break;
	        case 'u' : clean += "5";
	        	break;
	        case 'y' : clean += "6";
	        	break;
	        case 'A' : clean += "7";
	        break;
	        case 'E' : clean += "8";
	        break;
	        case 'I' : clean += "9";
	        break;
	        case 'O' : clean += "10";
	        break;
	        case 'U' : clean += "11";
	        break;
	        case 'Y' : clean += "12";
	        break;
	        default: clean += c;
	        break;
	        }
	    }
		return clean;	
		
	}
	
	public static void main(String[] args)   {
		try {
			System.out.println(new StringFun().asphyxie("Yolo"));
		} catch (PasDair e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(new StringFun().asphyxie("Bijour"));
		} catch (PasDair e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new StringFun().leet("Test"));
	}

}
