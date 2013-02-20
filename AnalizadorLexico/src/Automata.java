@SuppressWarnings("serial")
public class Automata extends Ventana{
	//String token = new String();
	int estado=0;
	public int analiza(String cadena){
		char compara;
		for(int i=0;i<cadena.length();i++){
			compara=cadena.charAt(i);
			//System.out.println(cadena.substring(i,i+1)+estado);
			switch(estado){
			case 0:
				if(Character.isLetter(compara)) 
					estado=1;
				else if(compara=='_')
					estado=2;
				else if(compara=='+' || compara=='-')
					estado=3;
				else if(compara=='*' || compara=='/' || compara=='%')
					estado=4;
				else if(Character.isDigit(compara))
					estado=5;
				else if(compara=='(' || compara==')')
					estado=8;
				else
					estado=99;
				break;
			case 1:
				if(Character.isLetter(compara))
					estado=1;
				else if(Character.isDigit(compara) || (compara=='_'))
					estado=2;
				else
					estado=99;
				break;
			case 2:
				if(Character.isLetter(compara) || (compara=='_') || (Character.isDigit(compara)))
					estado=2;
				else
					estado=99;
				break;
			case 3:
				if(Character.isDigit(compara))
					estado=5;
				else
					estado=99;
				break;
			case 4:
				estado=99;
				break;
			case 5:
				if(Character.isDigit(compara))
					estado=5;
				else if(compara=='.')
					estado=6;
				else
					estado=99;
				break;
			case 6:
				if(Character.isDigit(compara))
					estado=7;
				else
					estado=99;
				break;
			case 7:
				if(Character.isDigit(compara))
					estado=7;
				else
					estado=99;
				break;
			case 8:
				estado=99;
				break;
			case 99:
					i=cadena.length();
				break;
			}
		}
		return estado;
	}
}
