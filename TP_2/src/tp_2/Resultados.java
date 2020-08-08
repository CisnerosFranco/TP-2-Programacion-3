package tp_2;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.List;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class Resultados extends JFrame {

	private JPanel contentPane;
	private String conexiones;
	private String Costkm;
	private String PorcentajeAdicional;
	private String CostoFijo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados frame = new Resultados(null, null,null,null,null, null, null);
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
	public Resultados(String ciudades, String Conexiones, String Total, String CostKM, String PorcentajeAdicional, String CostoFijo , String trayectoria) {
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Costos de la Planificacion");
		setBackground(Color.YELLOW);
		setFont(new Font("Agency FB", Font.BOLD, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 514);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea resultados = new TextArea();
		resultados.setEditable(false);
		resultados.setBackground(Color.WHITE);
		resultados.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
		resultados.setBounds(0, 0, 811, 476);
		contentPane.add(resultados);
		
		resultados.setText(ciudades+
				"\r\nlas conexiones a realizar son las siguientes:"
				+ " \t\r\n\t\t"+Conexiones
				+"\t\t\r\n\t\t\r\n\r\n\r\n Costos tenidos en cuenta:"
				+ "\r\n\t\tCosto por cada Km:  $"+CostKM
				+" \r\n\t\tCosto adcional si la red supera los 300km:  $"+PorcentajeAdicional
				+"\r\n\t\tCosto Por cada Provincia que se Crusa:  $"+CostoFijo
				+"\r\n\r\n\r\n\r\n Costo Total:  $"+Total
				+"\n Trayecoria de la Conexion: "+ trayectoria + " km");
	}
}
