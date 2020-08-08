package Testings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp_2.calculateDistance;

class calculateDistanceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testDistance() {
		double n = 7595.390278305978;
		
		assertTrue( n  == calculateDistance.distance(47.6788206 , - 122.3271205,  45.6788206 , - 12.5271205));
	}
	
	
}
