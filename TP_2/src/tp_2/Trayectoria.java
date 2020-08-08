package tp_2;

public class Trayectoria {
	
	
	//Toma un grafo y acumula la longitud de cada arista en el grafo.
	 public static double solver(Grafo grafo) {
			double ret=0;
			for(int i=0; i<grafo.tamanio(); i++) {
				for(int j=1; j<grafo.tamanio(); j++) {
					if(i!=j && grafo.existeArista(i, j)) {
						ret+= grafo.getLongitud(i, j);
						grafo.eliminarArista(i, j);
					}
				}
			}
		
			return ret;	
		}
}
