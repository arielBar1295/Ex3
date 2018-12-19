package Type;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Fileformat.CsvData;
/**
 * This class represent a complete game,including a collection of packman and fruit.
 * @author ariel and moshe
 *
 */
public class Game {
	private ArrayList<Packman> packman;
	private ArrayList<Fruit> fruit;
	public CsvData d;
	public Game () {
		packman = new ArrayList<Packman> (); 
		fruit = new ArrayList<Fruit> ();
	}
	public Game(CsvData d) {
		packman = new ArrayList<Packman> ();
		fruit = new ArrayList<Fruit> ();
		this.d=d;
		this.init();
		
	}
	private void init() {
	for(int i=1;i<d.getA1().size();i++) { 
		
		
		
		if(d.getElement("Type", i).equals("P")) {
			
			Packman p=new Packman(d,i);
			String time=new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(Calendar.getInstance().getTime());
			p.setTimeStemp(time);
			packman.add(p); 
		}
		else {
			
			Fruit f=new Fruit(d,i);
			fruit.add(f);
		}
	}
		
	}
	public ArrayList<Packman> getPackman() {
		return packman;
	}
	public ArrayList<Fruit> getFruit() {
		return fruit;
	}
	public ArrayList<Fruit> copyF(){
		ArrayList<Fruit> F = new ArrayList<Fruit>();
		for (int i = 0; i < this.getFruit().size(); i++) {
			F.add(this.getFruit().get(i));
		}
		return F;
	}
	
	

}
