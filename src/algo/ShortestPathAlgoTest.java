package algo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fileformat.CsvData;
import Type.Game;


class ShortestPathAlgoTest {
	private	CsvData d1=new CsvData("game_1543684662657.csv");
	private	Game g= new Game(d1);
	private	 ShortestPathAlgo p = new ShortestPathAlgo(g);

	@Test
	void pathTofruitTest() {
		p.pathTofruit();
		int index=0;
		ArrayList<shortestTime>actual=g.getPackman().get(0).getPath();
		ArrayList<String>actualIdF=new ArrayList<String>();
		actualIdF.add(actual.get(index++).getFruitId());
		actualIdF.add(actual.get(index++).getFruitId());
		actualIdF.add(actual.get(index++).getFruitId());
		actualIdF.add(actual.get(index++).getFruitId());
		actualIdF.add(actual.get(index++).getFruitId());
		ArrayList<String>expectedIDf= new ArrayList<String>();
		expectedIDf.add("-1");
		expectedIDf.add("3");
		expectedIDf.add("2");
		expectedIDf.add("1");
		expectedIDf.add("0");

		assertTrue(expectedIDf.equals(actualIdF));


	}



}
