package Maps;

import java.util.ArrayList;

import Fileformat.CsvData;
import Type.Game;

public class test {
	public static void main(String[] args) {
		 CsvData d1=new CsvData("C:\\Users\\ariel\\Desktop\\Ex3\\game_1543684662657.csv");
		 Game g= new Game(d1);
		 ArrayList<ArrayList> a = new ArrayList<ArrayList>();
//		 for (int i = 0 ; i<g.getPackman().size();i++) {
//			 ArrayList<Integer> n =
//		 }
		 solutionForPa p = new solutionForPa(g.getPackman().get(0),g.getFruit());
		 ArrayList<Integer> n =p.solution();
	
		 
	}

}
