package Testings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp_2.*;

class AuxiliaresTest {


	@Test
	final void testMensajeVacio() {
		assertTrue(Auxiliares.mensajeVacio(""));
	}
	
	@Test
	final void testMensajeNoVacio() {
		assertFalse(Auxiliares.mensajeVacio("n"));
	}
	
	@Test
	final void testSoloLetras() {
		assertTrue(Auxiliares.soloLetras("dddd"));
	}
	
	@Test
	final void testNoSoloLetras() {
		assertFalse(Auxiliares.mensajeVacio("n32jjk"));
	}
	
	@Test
	final void testSoloLetrasVacio() {
		assertTrue(Auxiliares.soloLetras(""));
	}

	@Test
	final void testValidarDouble() {
		Double n= 02.0;
		assertTrue(Auxiliares.validarDouble(n.toString()));
		
	}
	
	@Test
	final void testValidarDoubleSinPunto() {
	
		assertTrue(Auxiliares.validarDouble("-232"));
		
	}
	
	@Test
	final void testValidarDoubleFalso() {
		Double n= 02.0;
		assertFalse(Auxiliares.validarDouble("434.3."));
		assertFalse(Auxiliares.validarDouble("4343s"));
		assertFalse(Auxiliares.validarDouble("434-3"));
	}
	
	
	@Test
	final void testValidarPositivo() {
		assertTrue(Auxiliares.validarPositivo("23"));
	}
	
	@Test
	final void testValidarPositivoFalso() {
		assertFalse(Auxiliares.validarPositivo("-23"));
		assertFalse(Auxiliares.validarPositivo("0"));
	}
	
	

	@Test
	final void testParseDouble() {
		Double k=Auxiliares.parseDouble("44");
		assertTrue(Auxiliares.parseDouble("44")==k);
		
	}
	
	@Test
	final void testExisteCiudad() {
		assertTrue(Auxiliares.existeCiudad(getCities(), "Bs As", "San Miguel"));
	}

	@Test
	final void testExisteCoordenada() {
		assertTrue(Auxiliares.existeCoordenada(getCities(), 121212.0, 123123.123));
		assertTrue(Auxiliares.existeCoordenada(getCities(), 19990, 18344.4));
		assertTrue(Auxiliares.existeCoordenada(getCities(), 444.44, 123123.123));
	}
	
	@Test
	final void testNOExisteCoordenada() {
		assertFalse(Auxiliares.existeCoordenada(getCities(), 123123.123, 121212.0));
	}
	
	private ArrayList<City> getCities(){
		 ArrayList<City> ret = new ArrayList<City> ();
		 
		 ret.add(new City("Bs As", "San Miguel", 121212.0, 123123.123));
		 
		 ret.add(new City("Santa Fe", "Rosario", 19990, 18344.4));
		 ret.add(new City("T. del Fuego", "Husuaia", 444.44, 123123.123));
		 
		 return ret;
	}

}
