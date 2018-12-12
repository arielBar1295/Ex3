package algo;

import java.util.ArrayList;

import Coords.MyCoords;
import Fileformat.CsvData;
import Geom.Point3D;
import Maps.solutionForPa;
import Type.Fruit;
import Type.Game;
import Type.Packman;
import Type.shortestTime;

public class path {
	
	private ArrayList<Packman> packman;
	
	private ArrayList<Fruit> fruit;
	private ArrayList<shortestTime> solution;
	private ArrayList<shortestTime> temp;
	private ArrayList<Point3D> point;
	//private ArrayList<Fruit> tempF;
	private MyCoords m;
	
	public path(Game game) {
		this.packman=game.getPackman();
		this.fruit=game.copyF();
		this.solution=new ArrayList<shortestTime>();
		this.temp=new ArrayList<shortestTime>();
		m=new MyCoords();
		init();
		
	}
	private void init() {
		 point= new ArrayList<Point3D> ();
		for (int i = 0; i < packman.size(); i++) {
			point.add(packman.get(i).getPoint());
		}
		
	}
	public void pathTofruit() {
		int counter=fruit.size();
		while(counter!=0) {
			for (int i = 0; i < packman.size(); i++) {
				System.out.println(i+" : ");
				solutionForPa p=new solutionForPa(packman.get(i),fruit);
				shortestTime s=p.solution();
				solution.add(s);
			}
			while(!this.solution.isEmpty()) {
			int indexMinTime=findMinTime(solution);
			if(isIn(indexMinTime,temp)) {
				temp.add(solution.get(indexMinTime));
				int indexP=findIndexOfP(solution.get(indexMinTime).getPackmanId(),packman );
				
				this.packman.get(indexP).setTime(solution.get(indexMinTime).getTime()+packman.get(indexP).getTime());
				System.out.println("indexP: "+indexP);
				this.packman.get(indexP).getPath().add(solution.get(indexMinTime).getFruitId());
				int indexF=findIndexOfF(solution.get(indexMinTime).getFruitId(), fruit);
				System.out.println("indexF: "+indexF);
				//need to calculate the coords in dis-raduis and then create a new point
				Point3D p=m.vector3D(packman.get(indexP).getPoint(), fruit.get(indexF).getPoint());
                this.packman.get(indexP).translate(p);
				this.fruit.set(indexF, null);
				counter--;
				this.solution.remove(indexMinTime);


			}
			else {
				this.solution.remove(indexMinTime);
			}
			}
			this.temp.removeAll(temp);
		}
		for (int i = 0; i < packman.size(); i++) {
			packman.get(i).setP(point.get(i));
		}

	}
private int findMinTime(ArrayList<shortestTime> solution) {
	int min=0;
	for(int i=0;i<solution.size();i++) {
		if(solution.get(min).getTime()>solution.get(i).getTime())
			min=i;
	}
	return min;
}
private boolean isIn(int index,ArrayList<shortestTime> temp) {
	String idF=this.solution.get(index).getFruitId();
	for(int i=0;i<temp.size();i++) {
		if(temp.get(i).getFruitId().equals(idF))
			return false;
	}
	return true;
}
private int findIndexOfF(String id,ArrayList<Fruit> F) {
	int temp=-1;
for (int i = 0; i < F.size(); i++) {
	int a= Integer.parseInt(id);
	if (F.get(i)==null) {
		
	}else {
	int b =  Integer.parseInt(F.get(i).getId());
	if (a==b)
	return i;
}
}
return temp;
	
}
private int findIndexOfP(String id,ArrayList<Packman> P) {
	int temp=-1; // never get a -1;
for (int i = 0; i < P.size(); i++) {
	int a= Integer.parseInt(id);
	int b =  Integer.parseInt(P.get(i).getId());
	if (a==b)
	return i;
	
}
return temp;

	
}
public static void main(String[] args) {
	 CsvData d1=new CsvData("C:\\Users\\moshe\\OneDrive\\Documents\\game_1543693911932_a.csv");
	 Game g= new Game(d1);
	 path p = new path(g);
	 p.pathTofruit();
	 
	 for (int i = 0; i < g.getPackman().size() ;i++) {
		// String s="";
		 System.out.println(g.getPackman().get(i).getPath());
		 System.out.println(g.getPackman().get(i).getPoint());

	}
		for (int i = 0; i <g.getFruit().size(); i++) {
			System.out.println(g.getFruit().get(i).toString());
		}
}

}

