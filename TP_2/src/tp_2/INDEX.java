package tp_2;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class INDEX extends JFrame {

	private JPanel contentPane;
	private JTextField costKM;
	private JTextField percentage;
	private JTextField fixedCost;
	private Resultados ret;
	
	private addCity addCities;
	private static ArrayList<City> ciudades;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INDEX frame = new INDEX();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public INDEX() {
		setTitle("Optene tu mejor Plan");
		//-------------------------------------------------------
		try {
			
			ciudades = Serializacion.readFile("File.txt"); //Se agrega optiene la lista de ciudades
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Inicializo la Lista de Cities
		
		//---------------------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		costKM = new JTextField();
		costKM.setBounds(116, 36, 229, 25);
		contentPane.add(costKM);
		costKM.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Costo Km");
		lblNewLabel.setBounds(32, 41, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Porcentaje");
		lblNewLabel_1.setBounds(31, 89, 75, 20);
		contentPane.add(lblNewLabel_1);
		
		percentage = new JTextField();
		percentage.setBounds(116, 84, 229, 25);
		contentPane.add(percentage);
		percentage.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Costo Fijo");
		lblNewLabel_2.setBounds(32, 146, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		fixedCost = new JTextField();
		fixedCost.setBounds(116, 138, 229, 25);
		contentPane.add(fixedCost);
		fixedCost.setColumns(10);
		
		JButton btnNewButton = new JButton("add city");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCities = new addCity();
				addCities.setVisible(true);
			}
		});
		btnNewButton.setBounds(271, 206, 85, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!Auxiliares.validarPositivo(costKM.getText()) || !Auxiliares.validarPositivo(percentage.getText()) || !Auxiliares.validarPositivo(fixedCost.getText())) {
					JOptionPane.showMessageDialog(null, "los campos deben contener valores positivos, sin puntos ni signos negativos");
					return;
				}
				
				if( ciudades.size() == 0) {
					JOptionPane.showMessageDialog(null,"No se a añadido ninguna ciudad");
					return;
				}		
					
				control.actualizarCiudades(ciudades);
				String Cities = control.obtenerCities();
				String conexiones = control.optenerConexiones();
				double trayectoria = control.getTrayectoria();
				double costos = control.calcularCosto(Integer.parseInt(costKM.getText()), Integer.parseInt(percentage.getText()), Integer.parseInt(fixedCost.getText()));
				
				//----------------------------------------------------------------------------------------------
				Serializacion.writeFile("File.txt", ciudades); //Actualizo la lista de ciudades en el File
				//----------------------------------------------------------------------------------------------
				
				ret = new Resultados(Cities, conexiones, ""+costos, costKM.getText(), percentage.getText(), fixedCost.getText(), ""+trayectoria);
				
				ret.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(116, 205, 85, 25);
		contentPane.add(btnNewButton_1);
	}
	
	
	
	public static boolean ingresar(City elem) {
		
		if(Auxiliares.existeCiudad(ciudades, elem.getProvincia(), elem.getCiudad()))
			return false;
		if(Auxiliares.existeCoordenada(ciudades,  elem.getLatitud(), elem.getLongitud()))
			return false;
		ciudades.add(elem);
		return true;
	}
}
