package algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fileformat.CsvData;
import Type.Game;
import Type.Packman;


class solutionForPaTest {
	CsvData d1=new CsvData("game_1543684662657.csv");
	Game g=new Game(d1);
    Packman p =new Packman(d1,1);
    solutionForPackman sp= new solutionForPackman(p,g.getFruit());
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
