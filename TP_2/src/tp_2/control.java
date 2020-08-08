package tp_2;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class control {
	
//	Atributos
	private static ArrayList<City> ciudades; //Class City
	private static Grafo grafo;
	

// Operaciones
	
	private static Grafo arbolGeneradorMinimo() {
		
		generarConexiones();
			
		return AGMdePrim.arbolGeneradorMinimo(grafo, 0);
	}
	
	
	
	private static void generarConexiones() {
		grafo = new Grafo(ciudades.size());
		
		for(int i=0; i<ciudades.size(); i++) {
			for(int j=1; j<ciudades.size(); j++) { //++++++++++++++++
				if(i != j) {
					double L = calculateDistance.distance(ciudades.get(i).getLatitud(), ciudades.get(i).getLongitud(), ciudades.get(j).getLatitud(), ciudades.get(j).getLongitud());
					grafo.agregarArista(i, j, L);
				}
			}
		}
	}
		
	public static double getTrayectoria() {
		return Trayectoria.solver((arbolGeneradorMinimo()));
	}
	
	

	
	private static int cantProvincias() {
		
		if(ciudades==null || ciudades.size()==0) 
			return 0;
		Set<String> provincias = new HashSet<String>();
		for(City i : ciudades) {
			provincias.add(i.getProvincia());
		}
		
		return provincias.size();
	}
	
	
	private static double calcularPorcentage(double valor_1, int valor_2) {
		double ret = (valor_1 * valor_2)/100;
		
		return ret;
	}
	

	
	
	public static void  actualizarCiudades(ArrayList<City> Cities) {
		
		ciudades = new ArrayList<City> ();
		
		for(City n : Cities) { //Para no hacer Aliasing, clono cada ciudad
			ciudades.add(new City(n.getProvincia(), n.getCiudad(), n.getLatitud(), n.getLongitud()));
		}
	}
	
	
	
	
	public static double calcularCosto(int costoKM, int porcentaje, int costoFijo ) {
		
		double trayectoria = Trayectoria.solver(arbolGeneradorMinimo());
		
		double ret =  trayectoria* costoKM; //se aplica el costo por cada km de la conexion
		
		if(ret == 0.0)
			return 0.0;
		
		if(trayectoria >= 300.0 ) { //costo en porcentaje adicional que se agrega si la conexion supera los 300km
			ret +=  calcularPorcentage(ret, porcentaje);
		}
	
		if(cantProvincias() >1) {
			ret += costoFijo; //costo fijo adicional por cada provincia que se tiene que cursar
		}
		
	
		BigDecimal bd = new BigDecimal(ret);					 //SE HACE USO DE LA CLASE BIGDECIMAL, PARA REDONDER EL VALOR 
		ret = bd.setScale(4, RoundingMode.HALF_UP).doubleValue();// EN DECIMAL A CUATRO FRACCIONES
		
		return ret;
	}
	
	
	
	
	
	
	
	public static String optenerConexiones() {
		
		String ret = "";
		if(ciudades.size() <=1) {
			ret+="\n\tno hay conexiones entre ciudades";
		}
		
		int cont = 0;
		Grafo g = arbolGeneradorMinimo();
		for(int i=0; i<g.tamanio(); i++) {
			for(int j=i+1; j<g.tamanio(); j++) {
				if(i!=j && g.existeArista(i, j)) {
					cont++;
					ret+="\n\tconexion " + cont + " ; "; 
					ret+=" provincia:  "+ciudades.get(i).getProvincia()+" ; ciudad:  "+ciudades.get(i).getCiudad()
							+ "  < con >  " +"  provincia:  "+ciudades.get(j).getProvincia()+";  ciudad:  "+ciudades.get(j).getCiudad();
				}
			}
		}
		
		return ret;
	}
	
	
	public static String obtenerCities() {
		String ret="Localidades:\t";
		for(City i : ciudades) {
			ret += "Provincia=  "+i.getProvincia() +",   Ciudad= "+ i.getCiudad() + ",   Lat= " + i.getLatitud() + ",   Long= " + i.getLongitud() +"\n\t\t";
		}
		return ret;
	}
	
}
