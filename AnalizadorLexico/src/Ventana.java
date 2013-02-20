import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 
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
	}*/

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Analizador Lexico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblIngresaCadena = new JLabel("Ingresa cadena");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIngresaCadena, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblIngresaCadena, 10, SpringLayout.WEST, panel);
		panel.add(lblIngresaCadena);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 25, SpringLayout.EAST, lblIngresaCadena);
		panel.add(textField);
		textField.setColumns(10);
		

		final JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("Enviar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 37, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 110, SpringLayout.WEST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = new String (textField.getText());
				String cadenatkn = new String();
				String cadenaSalida = new String();
				StringTokenizer tokens = new StringTokenizer(cadena);
				while(tokens.hasMoreTokens()){
					System.out.println(cadenatkn);
					cadenatkn=tokens.nextToken();
					int envio=0;
					Automata analiza = new Automata();
					envio=analiza.analiza(cadenatkn);
					
					switch(envio){
					case 0:
						cadenaSalida+=("estado 0\n");
						break;
					case 1:
						cadenaSalida+=("Cadena, Identificador\n");
						break;
					case 2:
						cadenaSalida+=("Identificador\n");
						break;
					case 3:
						cadenaSalida+=("Operador Adicion\n");
						break;
					case 4:
						cadenaSalida+=("Operador Multiplicacion\n");
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
					default:
						cadenaSalida+=("ERROR\n");
					}
					textArea.setText(cadenaSalida);
				}
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(SystemColor.textHighlight);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, scrollPane);
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, -2, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 184, SpringLayout.EAST, btnNewButton);
		panel.add(scrollPane);
		

		scrollPane.setViewportView(textArea);
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, -1, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, 123, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, textField);

	}
}
