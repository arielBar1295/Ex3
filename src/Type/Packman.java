package Type;

import Coords.MyCoords;
import Fileformat.CsvData;
import Geom.Circle;
import Geom.Point3D;

public class Packman {
	private Circle c;
	public CsvData d;
	private int index;
	private String[] s;
	public String id;
	final int rad=3;
    private Point3D p;
	private double Speed;
	private double radiusOfeat;
	public Packman(Point3D p) {
		this.p=p;
		this.Speed=1;
		this.radiusOfeat=1;
	}
	
	public Packman(CsvData d1,int index) {
		this.d=d1;
		this.index=index;
		s=d1.getLine(index);
		int indexX=d1.getIndexOfHeader("Lat");
		int indexY=d1.getIndexOfHeader("Lon");
		int indexZ=d1.getIndexOfHeader("Alt");
		int indexOfid=d1.getIndexOfHeader("id");
		int indexOfspeed=d1.getIndexOfHeader("Speed/Weight");
		int indexOfradius=d1.getIndexOfHeader("Radius");
		
		this.Speed=Double.parseDouble(s[indexOfspeed]);
		this.radiusOfeat=Double.parseDouble(s[indexOfradius]);
		this.id=s[indexOfid];
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		this.p=new Point3D(x,y,z);
		c= new Circle(this.p,rad);
		
	}
	public String toString() {
		return id+",packman";
		
	}
	
	public double getSpeed() {
		return Speed;
	}
	
	public double getRadiusOfeat() {
		return radiusOfeat;
	}
	
	public Point3D getPoint() {
		return p;
	}
}
