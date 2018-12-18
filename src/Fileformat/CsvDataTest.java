package Fileformat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CsvDataTest {
private  CsvData dTest=new CsvData("game_1543684662657.csv");

@Test
void getIndexOfHeaderTest() {
	String header="Type";
	int indexExpected=0;
	int actual=dTest.getIndexOfHeader(header);
	assertEquals(actual,indexExpected);
}
@Test
void getElementTest() {
	String s="id";
	int index=6;
	String expected="2";
	String actual=dTest.getElement(s, index);
	assertTrue(actual.equals(expected));
}
@Test
void getLineTest() {
	int index=2;
	String []line=dTest.getLine(index);
	
	String [] expected= {"P", "1", "32.10451344", "35.21019738", "0", "1", "1"};
	boolean eqs=true;
	for(int i=0;i<line.length;i++) {
		
		if(!line[i].equals(expected[i]))
			eqs=false;
	
	}
	assertTrue(eqs);
}
@Test
void getrowTest() {
	String row = dTest.getRaw("Speed/Weight");
	String expected = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,";
	assertTrue(row.equals(expected));
}
}
