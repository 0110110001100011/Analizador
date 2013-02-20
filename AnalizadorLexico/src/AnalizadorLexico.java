import java.awt.EventQueue;
import java.util.StringTokenizer;


public class AnalizadorLexico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static boolean esPalabraReservada(String palabra){
		String reservada = new String("break case char const continue default do double " +
				"else enum extern float for goto if int long register return short signed " +
				"sizeof static struct switch typedef union unsigned void volatile while " +
				"struct static const enum");
		StringTokenizer token = new StringTokenizer(reservada);
		String compara = new String();
		compara=token.nextToken();
		while(token.hasMoreTokens()){;
			if(palabra.compareTo(compara)==0)
				return true;
			compara=token.nextToken();
		}
		return false;
	}
	
	public static String muestra(int envio, String cadenaSalida){
		switch(envio){
		case 0:
			cadenaSalida+=("estado 0\n");
			break;
		case 1:
			cadenaSalida+=("Cadena o Identificador\n");
			break;
		case 2:
			cadenaSalida+=("Identificador\n");
			break;
		case 3:	case 4: case 19:
			cadenaSalida+=("Operador Aritmetico\n");
			break;
		case 5:
			cadenaSalida+=("Entero\n");
			break;
		case 7:
			cadenaSalida+=("Real\n");
			break;
		case 8:
			cadenaSalida+=("Parentesis\n");
			break;
		case 9:
			cadenaSalida+=("Palabra reservada\n");
			break;
		case 10:
			cadenaSalida+=("Llave\n");
			break;
		case 11:
			cadenaSalida+=("Corchete\n");
			break;
		case 12: case 13: case 23:
			cadenaSalida+=("Operador Relacional\n");
			break;
		case 14: case 22:
			cadenaSalida+=("Operador Logico\n");
			break;
		case 15:case 21: 
			cadenaSalida+=("Operador Asignacion\n");
			break;
		case 16:case 17: case 24:
			cadenaSalida+=("Operador nivel bit\n");
			break;
		case 18:
			cadenaSalida+=("Incremento\n");
			break;
		case 20:
			cadenaSalida+=("Decremento\n");
			break;
		default:
			cadenaSalida+=("ERROR\n");
		}
		return cadenaSalida;
	}

}
