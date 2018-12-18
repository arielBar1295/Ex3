package algo;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import Geom.Point3D;

class shortestTimeTest {
	private String idPacman="2";
	private String idFruit="10";
	private double time=2.456; 
	private Point3D p=new Point3D(35.21035679,32.10362369);
final shortestTime s=new shortestTime(idFruit,idPacman,time,p,0); // add Weight.
     @BeforeEach
	void setUp() throws Exception {
    	  String idPacman="2";
    	  String idFruit="10";
    	  double time=2.456;  
	}

	@Test
	void getFruitId() {
		String expected="10";
		String actual=idFruit;
		assertTrue(expected.equals(actual));
	}
	@Test
	void getPacmanId() {
		String expected="2";
		String actual=idPacman;
		assertTrue(expected.equals(actual));
	}
	
	@Test
	void getTime() {
		double expected=2.456;
		double actual=time;
		assertEquals(expected,actual);
	}
	   @Test
	    public void setTime() {
	   s.setTime(45.6);
	   double expected=45.6;
	   double actual=s.getTime();
	   assertEquals(expected,actual);
	    }
	   @Test
	    public void setFid() {
	   s.setFruitId("29");
	   String expected="29";
	   String actual=s.getFruitId();
	   assertEquals(expected,actual);
	    }
	   @Test
	    public void setPid() {
	   s.setPackmanId("90");
	   String expected="90";
	   String actual=s.getPackmanId();
	   assertEquals(expected,actual);
	    }
	   @Test
	    public void getP() {
		   Point3D expected=new Point3D(35.21035679,32.10362369);
		   assertTrue(expected.equals(s.getP()));
	   }
	  
}
