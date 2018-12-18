package Maps;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Point3D;
import Type.Packman;
/**
 * This class responsible for creating points in the packman's path .
 * @author moshe and ariel 
 *
 */
public class Way {
private Packman p;
private double jumps;
private MyCoords m;
private ArrayList<Point3D> wayofP;
/**
 * A constructor 
 * @param p is the packman 
 * @param time represents the the division ratio of the path.

 */
public Way(Packman p,double time) {
	this.p=p;
	this.jumps=time;
	this.wayofP=new ArrayList<Point3D>();
	this.m=new MyCoords();
}
/**
 * this function creating points between packman/fruit to fruit ,by using the time elements from the constructor .
 * this points will represents the movement of the specific packman .
 */
public void wayto() {
	//saving the origin packman point
	Point3D pOrigin=p.getPoint();
	double jump=0;

	for(int i=0;i<p.getPath().size();i++) {
		
		jump+=this.jumps;
		//calculate the distance 
		double dis=m.distance3d(p.getPoint(), p.getPath().get(i).getP());
		//calculate the time (by the formula : time*speed=distance)
		double time =dis/p.getSpeed();
		while(time-jump>jumps) {
			double normal=jump/time;
			//calculating the the division ratio
            double x=normal*(p.getPath().get(i).getP().x()-p.getPoint().x())+p.getPoint().x();
			double y=normal*(p.getPath().get(i).getP().y()-p.getPoint().y())+p.getPoint().y();
			Point3D newP=new Point3D(x,y);
			//add the point to the array
			wayofP.add(newP);
			
			jump+=this.jumps;
		}
		
		wayofP.add(p.getPath().get(i).getP());
		p.setP(p.getPath().get(i).getP());
		jump=0;
	}
	p.setP(pOrigin);
	
}
public ArrayList<Point3D> getWayOfP(){
	return this.wayofP;
}

}
