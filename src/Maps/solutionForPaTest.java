package Maps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fileformat.CsvData;
import Type.Game;
import Type.Packman;
import Type.shortestTime;

class solutionForPaTest {
	CsvData d1=new CsvData("C:\\Users\\ariel\\Desktop\\Ex3\\game_1543684662657.csv");
	Game g=new Game(d1);
    Packman p =new Packman(d1,1);
    solutionForPa sp= new solutionForPa(p,g.getFruit());
    shortestTime sT=sp.solution();

	

	@Test
	void solutionsTest() {
		
		
		String expected="3";
		String actual=sT.getFruitId();
		System.out.println(actual);
		assertTrue(expected.equals(actual));
	}
	@Test
	void solutionsTest2() {
		
		
		double expected=0;
		double actual=sT.getTime();
		assertEquals(expected,actual);
	}


}
