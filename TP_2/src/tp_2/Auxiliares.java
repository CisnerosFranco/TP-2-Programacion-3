package tp_2;

import java.util.ArrayList;

public class Auxiliares {
	
	/**
	 * se recibe un metodo y te dice si esta o no vacio
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean mensajeVacio(String cadena) {
		if(cadena.length()<=0)
			return true;
		return false;
	}
	
	
	
	public static boolean soloLetras(String mss) {
		String cadena = mss.toLowerCase();
		for(char i=0; i<cadena.length(); i++) {
			if(cadena.charAt(i) != 'a' && cadena.charAt(i) != 'b' && cadena.charAt(i) != 'c' && cadena.charAt(i) != 'd' && cadena.charAt(i) != 'e' && cadena.charAt(i) != 'f' && 
					cadena.charAt(i) != 'g' && cadena.charAt(i) != 'h' && cadena.charAt(i) != 'i' && cadena.charAt(i) != 'j' && cadena.charAt(i) != 'k' && cadena.charAt(i) != 'l' && 
					cadena.charAt(i) != 'm' && cadena.charAt(i) != 'n' && cadena.charAt(i) != 'o' && cadena.charAt(i) != 'p' && cadena.charAt(i) != 'q' && cadena.charAt(i) != 'r' && 
					cadena.charAt(i) != 's' && cadena.charAt(i) != 't' && cadena.charAt(i) != 'u' && cadena.charAt(i) != 'v' && cadena.charAt(i) != 'w' && cadena.charAt(i) != 'x' && 
					cadena.charAt(i) != 'y' && cadena.charAt(i) != 'z' && cadena.charAt(i) != ' ' && cadena.charAt(i) != '.' ) {
					
				return false;
			}
		}
		return true;
	}
	
	
	
	public static boolean validarDouble(String mss) {
		
		int puntos = 0;
		for(int i=0; i<mss.length(); i++) {
			if(mss.charAt(i) != '0' && mss.charAt(i) != '1' && mss.charAt(i) != '2' && mss.charAt(i) != '3' && mss.charAt(i) != '4' 
					&& mss.charAt(i) != '5' && mss.charAt(i) != '6' && mss.charAt(i) != '7' && mss.charAt(i) != '8' && mss.charAt(i) != '9' 
					&& mss.charAt(i) != '-' && mss.charAt(i) != '.' ) {
				 return false;
			}
			
			if(mss.charAt(i) == '-' && i!=0) {
				return false;
			}
			if(mss.charAt(i) == '.' && i==0) {
				return false;
			}
			
			if(mss.charAt(i) == '.' && i==mss.length()-1) {
				return false;
			}
			
			if(mss.charAt(i) == '.') {
				puntos++;
			}
			
			if(puntos >1) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean validarPositivo(String str) {
		if(str.length() == 0)
			return false;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!='0' && str.charAt(i)!='1' && str.charAt(i)!='2' && str.charAt(i)!='3' && str.charAt(i)!='4' && str.charAt(i)!='5' &&
					str.charAt(i)!='6' && str.charAt(i)!='7' && str.charAt(i)!='8' && str.charAt(i)!='9' ) {
				return false;
			}
			
			if(str.charAt(i)=='0' && i==0) {
				return false;
			} 
		}
		
		return true;
	}
	
	public static double parseDouble(String mss) {
		double ret =  Double.parseDouble(mss);
		return ret;
	}
	
	
	
	public static boolean existeCiudad(ArrayList<City> ciudades, String provincia ,String ciudad) {
		if(ciudades == null || ciudades.size() == 0) {
			return false;
		}
		for(City i : ciudades) {
			if(i.getCiudad().toLowerCase().equals(ciudad.toLowerCase())  &&  i.getProvincia().toLowerCase().equals(provincia.toLowerCase())) {
				return true;
			}			
		}
		return false;
	}
	
	
	public static boolean existeCoordenada(ArrayList<City> ciudades, double lat , double lon) {
		if(ciudades == null || ciudades.size() == 0) {
			return false;
		}
		for(City i : ciudades) {
			if(i.getLatitud()==lat && i.getLongitud()==lon) {
				return true;
			}
				
		}
		return false;
	}
}
