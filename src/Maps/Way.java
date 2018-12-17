package Maps;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Point3D;
import Type.Packman;

public class Way {
private Packman p;
private double jumps;
private MyCoords m;
private ArrayList<Point3D> wayofP;
public Way(Packman p,double time) {
	this.p=p;
	this.jumps=time;
	this.wayofP=new ArrayList<Point3D>();
	this.m=new MyCoords();
}
public void wayto() {
	Point3D pOrigin=p.getPoint();
	double jump=0;
	//System.out.println("size:"+ p.getPath().size());
	for(int i=0;i<p.getPath().size();i++) {
		
		jump+=this.jumps;
		double dis=m.distance3d(p.getPoint(), p.getPath().get(i).getP());
		double time =dis/p.getSpeed();
		while(time-jump>jumps) {
			double normal=jump/time;
			double x=normal*(p.getPath().get(i).getP().x()-p.getPoint().x())+p.getPoint().x();
			double y=normal*(p.getPath().get(i).getP().y()-p.getPoint().y())+p.getPoint().y();
			Point3D newP=new Point3D(x,y);
			
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
