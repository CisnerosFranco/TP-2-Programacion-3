package tp_2;

						// Esta Clase consigue el el Arbol Generador de Longitud Minima
						// del Grafo Dado. - version de Prim -
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AGMdePrim {

//	Grafo grafo;
	private static Grafo arbol;
	private static ArrayList<Integer> Vt; //Vertices del Arbol
//	private static Map<Integer,Integer> Et; //Aristas del Arbol
	
	
	

	private static void inicializador(Grafo grafo , int verticeInicial) {
		arbol = new Grafo(grafo.tamanio());
		Vt = new ArrayList<Integer>();
		
		Vt.add(verticeInicial);
	}
	
	
	public static Grafo arbolGeneradorMinimo(Grafo grafo, int verticeInicial) {

		
		inicializador(grafo , verticeInicial);
		int i=1;

		while(i < grafo.tamanio()) {
			int[] E = conseguirArista(grafo);
			if(E[0] != E[1]) {
//				System.out.println(E[0]+" "+E[1]);
				arbol.agregarArista(E[0], E[1], grafo.getLongitud(E[0], E[1]));
				Vt.add(E[1]); // se supone que el i ya se encuenta hay
				
			}
			
			i++;
		}
		
		return arbol;
	}
	
	
	private static int[] conseguirArista(Grafo grafo) {
		
		int[] ret = new int[2];
		double longitud = -1;
		
		for(int i =0 ; i<Vt.size(); i++) {
			for(int j=0; j<grafo.tamanio(); j++) {
				if( Vt.get(i) != j && grafo.existeArista(Vt.get(i), j) && Vt.contains(j) == false ) {
					if(grafo.getLongitud(Vt.get(i), j) < longitud || longitud < 0) {
						longitud = grafo.getLongitud(Vt.get(i), j);
						ret[0] = Vt.get(i);
						ret[1] = j;
					}
				}
			}
		}
		return ret;
		
	}

	
}

