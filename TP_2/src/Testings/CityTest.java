package Testings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp_2.City;

class CityTest {

	private City ciudad = new City("Tucuman", "San Miguel", 3241234.3213, -23423.34);

	
	
	@Test
	void ProvinciaTest() {
		assertTrue(ciudad.getProvincia().equals("Tucuman"));
	}
	
	@Test
	void CiudadTest() {
		assertTrue(ciudad.getCiudad().equals("San Miguel"));
	}
	
	
	@Test
	void LongitudTest() {
		assertTrue(ciudad.getLongitud() == (-23423.34));
	}
	
	
	@Test
	void LatitudTest() {
		assertFalse(ciudad.getLatitud() == (3241234));
	}

}
