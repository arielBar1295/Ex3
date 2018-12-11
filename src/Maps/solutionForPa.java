package Maps;

import java.util.ArrayList;
import java.util.Iterator;

import Coords.MyCoords;
import Fileformat.CsvData;
import Type.Fruit;
import Type.Game;
import Type.Packman;

public class solutionForPa {
	private ArrayList<Fruit> fruit;
	private Packman p;
	MyCoords m=new MyCoords();
	
	
	public solutionForPa(Packman p,ArrayList<Fruit> fruit) {
		this.fruit=fruit;
		this.p=p;
	}
	public ArrayList<Integer> solution(){
	    ArrayList<Integer> indexOfF = new ArrayList<Integer>(); 
	    ArrayList<Double> dis = new ArrayList<Double>(); 
		for(int i=0;i<fruit.size();i++) {
			//System.out.println(p.getPoint().x()+","+p.getPoint().y()+","+ fruit.get(i).getPoint().x()+","+ fruit.get(i).getPoint().y());
			double disP=m.distance3d(p.getPoint(), fruit.get(i).getPoint());
			dis.add(disP-p.getRadiusOfeat());
			
		}
		for (int i = 0; i < dis.size(); i++) {
			System.out.print(dis.get(i)+",");
		}
		int size=dis.size();
		for(int i=0; i<size;i++) {
		int index=indexOfMinimum(dis,indexOfF);
		
		indexOfF.add(index);
		//dis.remove(index);
		
		}
		for (int i = 0 ;i<indexOfF.size();i++) {
			System.out.print(indexOfF.get(i)+",");
		}
		return indexOfF;
	}
	public int indexOfMinimum(ArrayList<Double> dis,ArrayList<Integer> arr) {
		int min=0;
		while(search (min,arr)){
			min++;	
		}
		for(int i=1;i<dis.size();i++) {
			if(dis.get(min)>dis.get(i)&&(!search(i,arr)))
				min=i;
		}
		return min;
	}
	public boolean search (int index,ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)==index)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		 CsvData d1=new CsvData("C:\\Users\\moshe\\OneDrive\\Documents\\game_1543684662657.csv");
		 Game g= new Game(d1);
		 ArrayList<ArrayList> a = new ArrayList<ArrayList>();
//		 for (int i = 0 ; i<g.getPackman().size();i++) {
//			 ArrayList<Integer> n =
//		 }
		 solutionForPa p = new solutionForPa(g.getPackman().get(0),g.getFruit());
		 ArrayList<Integer> n =p.solution();
		 int a1=0;
	
		 
	}


}
