package Testings;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp_2.AGMdePrim;
import tp_2.City;
import tp_2.Grafo;
import tp_2.Trayectoria;
import tp_2.calculateDistance;
import tp_2.control;

class controlTest {

	
	@BeforeEach
	
	void setUp() throws Exception {
		control.actualizarCiudades(getCities());
	}

//	@Test
//	final void testExisteCiudad() {
//		assertTrue(control.existeCiudad("Bs As", "San Miguel"));
//	}
//
//	@Test
//	final void testExisteCoordenada() {
//		assertTrue(control.existeCoordenada(121212.0, 123123.123));
//		assertTrue(control.existeCoordenada(19990, 18344.4));
//		assertTrue(control.existeCoordenada(444.44, 123123.123));
//	}
//	
//	@Test
//	final void testNOExisteCoordenada() {
//		assertFalse(control.existeCoordenada( 123123.123, 121212.0));
//	}

	


	// EL TEST DE LA CLASE Trayectoria; lo hago aqui porque se complementan
	// las clases
	@Test
	final void trayectoriaTest() {
		
		
		Grafo g = new Grafo(6);
		
		g.agregarArista(0, 1, 4);
		g.agregarArista(0, 2, 8);
		g.agregarArista(0, 5, 3);
		g.agregarArista(1, 2, 3);
		g.agregarArista(1, 4, 1);
		g.agregarArista(5, 4, 3);
		g.agregarArista(2, 4, 1);
		g.agregarArista(2, 3, 1);
		g.agregarArista(4, 3, 3);
		
		double aux = Trayectoria.solver(AGMdePrim.arbolGeneradorMinimo(g, 0));
		assertTrue(aux == (3+1+1+1+3));
		
		
		
	}
	
	@Test
	void trayectoriaTestControl() {
		control.actualizarCiudades(getCities());
		
		Grafo g = this.AGM(getCities());
		
		assertTrue(control.getTrayectoria() == Trayectoria.solver(g));
	}
	
	@Test
	final void testCalcularCosto() {
		
		control.actualizarCiudades(getCities());
		
		//--------------costos para el test-------------------------------------------------
		//costo por cada km de la conexion = 5
		//costo en porcentaje adicional que se agrega si la conexion supera los 300km = 5
		//costo fijo adicional por cada provincia que se tiene que cursar = 5
		
		
		
		Grafo g = AGM(getCities());
		
		double n = Trayectoria.solver(g);
		
		double aux =  (n * 5); //se aplica costo por km
	
		if(n >= 300.0) { //se aplica el costo por superar los 300km
			aux += ((aux * 5)/ 100);
		
		}
		
		aux += 5; // se aplica el costo fijo por cada provincia que cursa la conexion
					// en este ejemplo son tres las provincias, con tres ciudades
		
		BigDecimal bd = new BigDecimal(aux);					 //SE HACE USO DE LA CLASE BIGDECIMAL, PARA REDONDER EL VALOR a 4 decimales
		aux = bd.setScale(4, RoundingMode.HALF_UP).doubleValue();

		assertTrue(control.calcularCosto(5, 5, 5) == aux);
	}
	
	
	
	private ArrayList<City> getCities(){
		 ArrayList<City> ret = new ArrayList<City> ();
		 
		 ret.add(new City("Bs As", "San Miguel", 121212.0, 123123.123));
		 
		 ret.add(new City("Santa Fe", "Rosario", 19990, 18344.4));
		 ret.add(new City("T. del Fuego", "Husuaia", 444.44, 123123.123));
		 
		 return ret;
	}
	
	
	
	private Grafo AGM(ArrayList<City> C) {
		
		 ArrayList<City> ciudades = C;
		Grafo g = new Grafo(ciudades.size());
		
		for(int i=0; i<ciudades.size(); i++) {
			for(int j=1; j<ciudades.size(); j++) { //++++++++++++++++
				if(i != j) {
					double L = calculateDistance.distance(ciudades.get(i).getLatitud(), ciudades.get(i).getLongitud(), ciudades.get(j).getLatitud(), ciudades.get(j).getLongitud());
					g.agregarArista(i, j, L);
				}
			}
		}
		
		return AGMdePrim.arbolGeneradorMinimo(g,0);
	}
	
	private ArrayList<Double> ordenar( ArrayList<Double> lista){
		ArrayList<Double> k = lista;
		double aux=0;
		for(int i =0; i<k.size(); i++) {
			for(int j =0; j < k.size()-1; j++) {
				if(k.get(j) > k.get(j+1)) {
					aux = k.get(j+1);
					k.set(j+1,k.get(j));
					k.set(j, aux);
				}
			}
		}
		
		return k;
	}
	
}
