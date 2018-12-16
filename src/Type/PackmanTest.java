package Type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fileformat.CsvData;
import Geom.Point3D;

class PackmanTest {
private CsvData d1=new CsvData("C:\\Users\\ariel\\Desktop\\Ex3\\game_1543684662657.csv");
private int index=3;
private Packman p=new Packman(d1,index);
	@Test
	void getPointTest() {
	
		Point3D expected=new Point3D(32.1042768,35.21035679,20.0);
		Point3D actual=p.getPoint();
		assertTrue(expected.equals(actual));
		
	}
	@Test
	void getIdTest() {
		String expected="2";
		String actual=p.id;
		assertTrue(expected.equals(actual));

}
	@Test
	void getSpeed() {
		double expected=1;
		double actual=p.getSpeed();
		assertEquals(expected,actual);

}
	@Test
	void getRadius() {
		double expected=1;
		double actual=p.getRadiusOfeat();
		assertEquals(expected,actual);

}
//	@Test
	void translate() {
		
	}
	
	void getTime() {
		
	}
	
}