package tp_2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Serializacion { 
	
		
	public static void createFile(String nameFile) {
		try
		{
			FileOutputStream fos = new FileOutputStream(nameFile); //Nombro el Archivo a crear (archivo logico)
//			OutputStreamWriter out = new OutputStreamWriter(fos); //Cramos el archivo fisico
	
		}
  	    catch (FileNotFoundException e) {
		
		e.printStackTrace();
       }
	}


	/**
	 * Se Escribe el File, para eso se toma
	 * 
	 * el Path del File a escribir, y un ArrayList de los objetos a escibir
	 * 
	 */
	public static void writeFile(String pathFile, ArrayList<City> objs) {
		try {
				//CREO EL FICHERO DONDE ESCRIBO LOS OBJETOS
			ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(pathFile));
			
			//Escribo en el fichero
			for(Object i : objs) {
				fichero.writeObject(i);
			}
			fichero.close();
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	/**
	 * se lee el fichero indicado 
	 * y se retorna su contenido en un ArrayList con elemntos de tipo Object
	 */
	public static ArrayList<City> readFile(String path_fichero) throws ClassNotFoundException {
		ArrayList<City> ret = new ArrayList<City> (); 
		
		try {
				//CREO EL FICHERO DONDE ESCRIBO LOS OBJETOS
			ObjectInputStream fichero = new ObjectInputStream(new FileInputStream(path_fichero));
			
			while(true){
				ret.add((City) fichero.readObject()); //lo que hace es LEER un Objeto, que debe ser casteado a alguna clase
			}
			
		}
		catch(ClassNotFoundException e) {} //te dice si existe o no la clase (en este caso "Empleado" )
		catch(EOFException ex){} // para que la exception salte cuando ya no encuentre nada mas en el fichero
		catch(IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		return ret;
	}
	
}
