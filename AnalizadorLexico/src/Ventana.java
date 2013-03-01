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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblIngresaCadena;
	private JScrollPane scrollPane;
	private JLabel lblSalida;
	private JButton btnX;
	private JButton btnNewButton;
	private JPanel panel;

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
		
		panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblIngresaCadena = new JLabel("Ingresa cadena: ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIngresaCadena, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblIngresaCadena, 10, SpringLayout.WEST, panel);
		panel.add(lblIngresaCadena);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblIngresaCadena);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -39, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		

		final JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		
		btnNewButton = new JButton("Analizar");
		btnNewButton.setToolTipText("Analiza la cadena ingresada");
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 36, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = new String (textField.getText());
				String cadenatkn = new String();
				String cadenaSalida = new String();
				StringTokenizer tokens = new StringTokenizer(cadena);
				while(tokens.hasMoreTokens()){
					//System.out.println(cadenatkn);
					cadenatkn=tokens.nextToken();
					int envio=0;
					Automata analiza = new Automata();
					envio=analiza.analiza(cadenatkn);
					cadenaSalida+=(cadenatkn+" = ");
					cadenaSalida=AnalizadorLexico.muestra(envio, cadenaSalida);
					textArea.setText(cadenaSalida);
				}
				

				textArea.setBackground(SystemColor.black);
			}
		});
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, panel);
		scrollPane.setForeground(SystemColor.textHighlight);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, -1, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, 123, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, textField);
		
		lblSalida = new JLabel("Salida: ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSalida, 41, SpringLayout.SOUTH, lblIngresaCadena);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, lblSalida);
		sl_panel.putConstraint(SpringLayout.WEST, lblSalida, 0, SpringLayout.WEST, lblIngresaCadena);
		panel.add(lblSalida);
		
		btnX = new JButton("");
		sl_panel.putConstraint(SpringLayout.WEST, btnX, 5, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnX, 0, SpringLayout.SOUTH, lblIngresaCadena);
		sl_panel.putConstraint(SpringLayout.EAST, btnX, -10, SpringLayout.EAST, panel);
		btnX.setIcon(new ImageIcon(Ventana.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setBackground(SystemColor.menu);
				textArea.setText("");
				textField.setText("");
				
			}
		});
		btnX.setToolTipText("Limpiar Entrada/Salida");
		panel.add(btnX);

	}
}
