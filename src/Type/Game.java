package Type;

import java.util.ArrayList;

import Fileformat.CsvData;

public class Game {
	private ArrayList<Packman> packman;
	private ArrayList<Fruit> fruit;
	public CsvData d;
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
	
	

}
