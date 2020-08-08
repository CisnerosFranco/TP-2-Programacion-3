package tp_2;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class addCity extends JFrame {

	private JPanel contentPane;
	private JTextField Ciudad;
	private JTextField Provincia;
	private JTextField Latitud;
	private JTextField Longitud;
	private ArrayList<City> ciudades;					
	private Grafo grafo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCity frame = new addCity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param object 
	 */
	public addCity() {
		
		setTitle("A\u00F1adir Ciudad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Ciudad = new JTextField();
		Ciudad.setDropMode(DropMode.INSERT);
		Ciudad.setToolTipText("");
		Ciudad.setBounds(100, 59, 231, 23);
		contentPane.add(Ciudad);
		Ciudad.setColumns(10);
		
		Provincia = new JTextField();
		Provincia.setBounds(100, 28, 231, 23);
		contentPane.add(Provincia);
		Provincia.setColumns(10);
		
		Latitud = new JTextField();
		Latitud.setBounds(100, 90, 231, 23);
		contentPane.add(Latitud);
		Latitud.setColumns(10);
		
		Longitud = new JTextField();
		Longitud.setBounds(100, 121, 231, 23);
		contentPane.add(Longitud);
		Longitud.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Ciudad");
		lblNewLabel.setBounds(21, 65, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Provincia");
		lblNewLabel_1.setBounds(23, 31, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Latitud");
		lblNewLabel_2.setBounds(23, 96, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Longitud");
		lblNewLabel_3.setBounds(23, 127, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("a\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(Auxiliares.mensajeVacio(Provincia.getText()) || Auxiliares.mensajeVacio(Ciudad.getText())  || Auxiliares.mensajeVacio(Latitud.getText()) || Auxiliares.mensajeVacio(Longitud.getText())) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados");
					return;
				}
				
				
				if(!Auxiliares.soloLetras(Provincia.getText()) || !Auxiliares.soloLetras(Ciudad.getText()) ) {
					JOptionPane.showMessageDialog(null, "los campos de ciudad y provincia solo deben contener letras y espacios en blanco");
					return;
				}
				
				if(!Auxiliares.validarDouble(Latitud.getText()) ||!Auxiliares.validarDouble(Longitud.getText())) {
					JOptionPane.showMessageDialog(null, "Los  campos de Latitud y Longitud solo puede contener numeros, a los sumo un signo de negacion "
							+ "al principio y un punto, No al principio, ni al final");
					return;
				}


				boolean ret = INDEX.ingresar(new City(Provincia.getText(), Ciudad.getText(), Auxiliares.parseDouble(Latitud.getText()), Auxiliares.parseDouble(Longitud.getText())));

				if(ret==false) {
					JOptionPane.showMessageDialog(null, "Hubo un Error;\n" +
							"es posible que la ciudad ya se haya registrado previamente en dicha Provincia, ó que las Coordenadas ya hayan cido ingresadas previamente ");
					return;
				}
				Provincia.setText("");
				Ciudad.setText("");
				Latitud.setText("");
				Longitud.setText("");
				
			}
		});
		btnNewButton.setBounds(137, 184, 72, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(266, 184, 72, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
