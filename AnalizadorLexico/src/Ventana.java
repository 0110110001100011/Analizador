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


@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		sl_panel.putConstraint(SpringLayout.EAST, textField, 271, SpringLayout.EAST, lblIngresaCadena);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 37, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, textField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = new String (textField.getText());
				int envio=0;
				Automata analiza = new Automata();
				envio=analiza.analiza(cadena);
				switch(envio){
				case 0:
					textField_1.setText("estado 0");
					break;
				case 1:
					textField_1.setText("Cadena, Identificador");
					break;
				case 2:
					textField_1.setText("Identificador");
					break;
				case 3:
					textField_1.setText("Operador Adicion");
					break;
				case 4:
					textField_1.setText("Operador Multiplicacion");
					break;
				case 5:
					textField_1.setText("Entero");
					break;
				case 7:
					textField_1.setText("Real");
					break;
				case 8:
					textField_1.setText("Parentesis");
					break;
				default:
					textField_1.setText("ERROR");
				}
			}
		});
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 38, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
