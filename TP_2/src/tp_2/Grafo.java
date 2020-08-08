package tp_2;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por su matriz de adyacencia
	private boolean[][] Mat;
	private Map<String, Double> Longitud;
	

	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		Mat = new boolean[vertices][vertices];
		Longitud = new HashMap<String, Double> ();
	}
	
	// Agregado de aristas
	public void agregarArista(int i, int j, double longitud)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		Mat[i][j] = true;
		Mat[j][i] = true;
		
		Longitud.put(i+","+j, longitud);
		Longitud.put(j+","+i, longitud);
	}
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		Mat[i][j] = false;
		Mat[j][i] = false;
		
		Longitud.remove(j+","+i);
		Longitud.remove(i+","+j);
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return Mat[i][j];
	}

	/** Cantidad de vertices
	 * 
	 **/
	public int tamanio()
	{
		return Mat.length;
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamanio(); ++j)
			if( i != j ){
			if( this.existeArista(i,j) )
				ret.add(j);
		    }
		
		return ret;		
	}
	
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= Mat.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	public double getLongitud(int v1, int v2) {
		if(existeArista(v1,v2) == false) {
			throw new RuntimeException("No existe la arista "+v1+", "+v2);
		}
		return Longitud.get(v1+","+v2);
	}
		
	@Override
	public String toString() {
		String ret ="Aristas: ";
		for(int i = 0; i<tamanio(); i++) {
			for(int j=i+1; j<tamanio(); j++) {
				if(existeArista(i,j)) {
					ret+="["+i+","+j+"] ";
				}
			}
		}
		return ret;
	}
	
	
	public boolean mismoGrafo(Grafo g) {
		
		if(g == null) 
			return false;
		
		for(int i=0; i <g.tamanio(); i++) {
			for(int j=i+1; j <g.tamanio(); j++) {
				if(i!=j) 
				if(this.existeArista(i, j) != g.existeArista(i, j) || this.getLongitud(i, j)!= g.getLongitud(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
}