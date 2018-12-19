package algo;

import java.util.ArrayList;

import Coords.MyCoords;
import Fileformat.CsvData;
import Geom.Point3D;
import Type.Fruit;
import Type.Game;
import Type.Packman;


public class ShortestPathAlgo {
	/**
	 * The class ShortestPathAlgo represents the algorithm which calculating the paths of eating for all the pacman.
	 * At first the algorithm  calculating for each pacman its closest fruit,saving the result in a new array,
	 * now the algorithm takes the pacman with the least  time to its specific fruit from the new array,
	 * the pacman will move forward and removed from the array, the fruit is no longer can be eaten ,now do the same as long there are pacman in the new array 
	 * after that,building a new array without the fruits which have been eaten .keep running as long there are fruit which can be eaten.
	 */

	private ArrayList<Packman> packman;

	private ArrayList<Fruit> fruit;
	private ArrayList<shortestTime> solution;
	private ArrayList<shortestTime> temp;
	private ArrayList<Point3D> point;
	//private ArrayList<Fruit> tempF;
	private MyCoords m;

	public ShortestPathAlgo(Game game) {   
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
			shortestTime sho= new shortestTime("-1","-1",0,packman.get(i).getPoint(),0);
			packman.get(i).getPath().add(sho);
		}

	}
	/**
	 * The function calculate the path of the specific game by finding the the minimum time for each pacman to eat some fruit ,from all the pacman take the one with the minimum time .
	 */
	public void pathTofruit() {
		//stop running when there are no fruits left in the array.
		int counterSizeOfFruits=fruit.size();
		while(counterSizeOfFruits!=0) {
			//Going over the arrayList of the pacman , find for each pacman the closest fruit by using "solutionForPacman",add to the array of solutin.
			for (int i = 0; i < packman.size(); i++) {
				solutionForPackman p=new solutionForPackman(packman.get(i),fruit);
				shortestTime s=p.solution();
				solution.add(s);

			}
			//Going over the arrayList of solution ,find the minimum time ,check if the fruit is free,if it is , remove from the list and add to the temp list ,set the location and time of the pacman ,in the end remove the fruit .
			while(!this.solution.isEmpty()) {
				
				int indexMinTime=findMinTime(solution);
				
				if(isIn(indexMinTime,temp)) {
					
					temp.add(solution.get(indexMinTime));
					int indexP=findIndexOfP(solution.get(indexMinTime).getPackmanId(),packman );
				
					this.packman.get(indexP).setTime(solution.get(indexMinTime).getTime()+packman.get(indexP).getTime());
					this.packman.get(indexP).setWeight(solution.get(indexMinTime).getWeight()+this.packman.get(indexP).getWeight());
					this.packman.get(indexP).getPath().add(solution.get(indexMinTime));
					int indexF=findIndexOfF(solution.get(indexMinTime).getFruitId(), fruit);
					Point3D p=m.vector3D(packman.get(indexP).getPoint(), fruit.get(indexF).getPoint());
					this.packman.get(indexP).translate(p);
					//setting the eaten fruit to NULL
					this.fruit.set(indexF, null);
					counterSizeOfFruits--;
					this.solution.remove(indexMinTime);


				}
				//if the the minimum time was find but the fruit is not in the arrayList ,remove from the solution array.
				else {
					this.solution.remove(indexMinTime);
				}
			}
			this.temp.removeAll(temp);
			System.out.println();
		}
		for (int i = 0; i < packman.size(); i++) {
			packman.get(i).setP(point.get(i));
		
			
		}

	}
	
	/**
	 * The function gets an arrayList and find the minimum time of the solutions.
	 * @param solution is the arrayList
	 * @return the index of the minimum element
	 */
	private int findMinTime(ArrayList<shortestTime> solution) {
		int min=0;
		for(int i=0;i<solution.size();i++) {
			if(solution.get(min).getTime()>solution.get(i).getTime())
				min=i;
		}
		return min;
	}
	/**
	 * the function gets an array and idFruit and checks if the fruit was already eaten by another pacman
	 * @param index of the location in solution array.
	 * @param temp the arraylist with the fruitId which is no longer in the game
	 * @return true if the fruit is free,and false if not
	 */
	private boolean isIn(int index,ArrayList<shortestTime> temp) {
		String idF=this.solution.get(index).getFruitId();
		for(int i=0;i<temp.size();i++) {
			if(temp.get(i).getFruitId().equals(idF))
				return false;
		}
		return true;
	}
	/**
	 * the function gets an id of a single fruit and arrayList of fruits and finds the index of the fruit which holds this specific id.
	 * @param id of the specific fruit
	 * @param F the arrayList of the fruits
	 * @return the index 
	 */
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
	/**
	 * the function gets an id of a single pacman and arrayList of pacmans and,  finds the index of the pacman which holds this specific id.
	 * @param id of the pacman
	 * @param P the arrayList of the pacman
	 * @return
	 */
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


}

