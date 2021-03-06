package algo;

import java.util.ArrayList;
import java.util.Iterator;

import Coords.MyCoords;
import Fileformat.CsvData;
import Type.Fruit;
import Type.Game;
import Type.Packman;

/**
 * this class calculate the path between one pacman to each fruit
 * @author ariel and Moshe
 *
 */
public class solutionForPackman {
	private ArrayList<Fruit> fruit;
	private Packman p;
	MyCoords m=new MyCoords();
	 
	/**
	 * A constructor
	 * @param p is the pacman.
	 * @param fruit is list of the fruits.
	 */
	
	public solutionForPackman(Packman p,ArrayList<Fruit> fruit) { 
		this.fruit=fruit;
		this.p=p;
	}
	/**
	 * The function calculate the time it takes the pacman get to the specific fruit.
	 * @return s ,type of shortestTime ,which holds the pacman  id, and the fruit's id which took the minimum time eating.
	 */
	public shortestTime solution(){
		shortestTime  s;
		 ArrayList<Double> times=new ArrayList<Double>();

		for(int i=0;i<fruit.size();i++) {
			if(fruit.get(i)==null) {
				double t= Double.MAX_VALUE;
				times.add(t);

			}else {
			//if there is a fruit in the array and its not null ,calculate the time(from the formula :time*speed=distance)	
			double time =0;
			double dis=m.distance3d(p.getPoint(), fruit.get(i).getPoint());
            //if the pacman can eat the fruit from its position ,stay still.
			if (dis == 0 ) {
				 time =0;
			}else {
			 time=(dis-p.getRadiusOfeat())/p.getSpeed();// +p.getTime(); 
			}

			times.add(time);
			}
		}
		//find the minimum time ,and create a new shortestTime.
		int index=indexOfMinimum(times);
		s=new shortestTime(fruit.get(index).getId(),p.getId(),times.get(index)+p.getTime(),fruit.get(index).p,fruit.get(index).getWeight());
		
		//System.out.println("shortestTime : "+times.get(index));
		return s;
	  
	}
	/**
	 * The function gets an arrayList,and find the minimum time
	 * @param arr is the ArrayList
	 * @return the index of the minimum time.
	 */
	public int indexOfMinimum(ArrayList<Double> arr) {
		int min=0;

		for(int i=1;i<arr.size();i++) {
			if(arr.get(min)>arr.get(i))
				min=i;
		}
		return min;
	}



}
