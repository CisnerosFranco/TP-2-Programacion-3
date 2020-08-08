package tp_2;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class principal {
//	public static addExcel x = new addExcel(); //Instancio el objeto
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//		String[][] Mat = new String[3][3];
//		Mat[0][0] = "nombre";
//		Mat[0][1] = "apellido";
//		Mat[0][2] = "edad";		
////		Mat[0][3] = "Edad";
//
////		String[][] Mat2 = new String[3][3];
////		Mat[1][0] = "Franco";
////		Mat[1][1] = "cisnero";
////		Mat[1][2] = "21";
//////				
////		String src ="C:\\Users\\nasa\\Downloads/salida.xls";
////		addExcel.generarExcel(Mat, src);
//
//		ArrayList<City> cities = new ArrayList<City>();
//		
//		cities.add( new City("Bs As", "Grand Bourg", 47.6788206 , - 122.3271205));
//		cities.add( new City("Buenos Aires", "Polvorines", 47.6788206 , - 122.5271205));
//		cities.add( new City("S. del Estero", "Monte", 45.6788206 , - 12.5271205));
//		cities.add( new City("S. del Estero", "C. gallo", 55.6788206 , - 22.5271205));
//
//		control.actualizarCiudades(cities);
////		System.out.println(control.optenerConexiones());
////		System.out.println("\n\t costo de la conexion: "+control.calcularCosto(5, 5, 5));
////		System.out.println(control.obtenerCities());
//		double ret = calculateDistance.distance(47.6788206 , - 122.3271205,  45.6788206 , - 12.5271205);
//		
//		System.out.println("--"+ret);
////		ret= ret*5;		   // costo por kilometro
////		ret+= (ret*5)/100; // porcentaje adicional si supera los 300km
////		ret+= (2*5); 		  // aficional fijo por cada povincia que crusa
//
//	
	double ret = Math.sqrt(2);
	System.out.println((double)Math.round(ret*100d)/100);
	
	BigDecimal bd = new BigDecimal(ret);
	
	System.out.println(bd.setScale(4, RoundingMode.HALF_UP));
	
	
	}
	
	
}
