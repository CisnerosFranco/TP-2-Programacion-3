package Testings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp_2.AGMdePrim;
import tp_2.Grafo;
import tp_2.Trayectoria;

class AGMprimTest {

	private Grafo grafo;
	
	//A=0
	//B=1
//	  C=2
//	  D=3
//	  E=4
//	  F=5
//	  G=6
//	  H=7
//	  I=8
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	 grafo = new Grafo(9);
	 grafo.agregarArista(0, 1, 4);  //Este ejemplo de Grafo es el que se muestra en la diapositia
	 grafo.agregarArista(0, 7, 8);  // para el algoritmo AGM de Prim
	 grafo.agregarArista(1, 7, 12);
	 grafo.agregarArista(1, 2, 8);
	 grafo.agregarArista(7, 8, 6);
	 grafo.agregarArista(7, 6, 1);
	 grafo.agregarArista(2, 3, 6);
	 grafo.agregarArista(2, 8, 3);
	 grafo.agregarArista(2, 5, 4);
	 grafo.agregarArista(8, 6, 5);
	 grafo.agregarArista(6, 5, 3);
	 grafo.agregarArista(3, 5, 13);
	 grafo.agregarArista(4, 5, 10);
	 grafo.agregarArista(3, 4, 9);
	
	}

	@Test
	final void AGMtest() {
		Grafo g = AGMdePrim.arbolGeneradorMinimo(grafo, 0);
		
		double n= (4 + 8 + 6 + 9 + 3 + 1 + 3 + 4); // Estos son los valores que deberia dar el AGM de Prim
		
		
		assertTrue(Trayectoria.solver(g) == n);
	}
	

	
	
	
}
