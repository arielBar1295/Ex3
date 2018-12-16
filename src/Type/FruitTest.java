package Type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fileformat.CsvData;
import Geom.Point3D;

class FruitTest {

	private CsvData d1=new CsvData("C:\\Users\\ariel\\Desktop\\Ex3\\game_1543684662657.csv");
	private int index=4;
	Fruit fTest=new Fruit(d1,index);

	@Test
	void getPoint() {
		Point3D expected=new Point3D(32.10462702,35.20573393,10.0);
		Point3D actual=fTest.getPoint();
		assertTrue(expected.equals(actual));
	}
	@Test
	void getId() {
		String expected="0";
		String actual=fTest.getId();
		assertTrue(expected.equals(actual));
	}

}
