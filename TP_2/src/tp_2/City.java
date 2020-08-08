package tp_2;

import java.io.Serializable;

public class City implements Serializable { //IMPLEMENTA la interfaz Serializble

	
	private static final long serialVersionUID = 1L; //ID nesesaria para que el archivo Serializado pueda ser 
	 												// leido por cualquier otro Software
	
	// variables de instancia
	
	private String provincia;
	private String ciudad;
	private double latitud;
	private double longitud;
	
	
	public City(String provincia, String ciudad,  double latitud, double longitud){
		
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;

	}
	
	//Operaciones
	public String getCiudad() {
		return ciudad;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public double getLatitud() {
		return latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public String toString() {
		return "provincia: "+provincia+" ciudad: "+ciudad +" latitud: "+latitud +" longitud: "+longitud;
	}
}

