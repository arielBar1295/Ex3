package Type;

import java.util.ArrayList;

import Coords.MyCoords;
import Fileformat.CsvData;
import Geom.Circle;
import Geom.Point3D;

public class Packman {
	/**
	 * This class represents a single pacman 
	 */
	private Circle c;
	public CsvData d;
	private int index;
	private String[] s;
	public String id;
	final int rad=3;
    private Point3D p;

	private double Speed;
	private double radiusOfeat;
	private double time;
	private MyCoords m=new MyCoords();
	private ArrayList<shortestTime> path;  //holding the id of the fruits which this pacman has already eat .
	private String timeStemp;
	public Packman(Point3D p,String id) {
		this.p=p;
		this.Speed=1;
		this.radiusOfeat=1;
		this.id=id;
		this.time=0;
		this.path=new ArrayList<shortestTime>();
	}
	/**
	 * A constructor ,gets a csvData and index,finding the values of the lat,lon,alt of the specific pacman ,id, radius and speed.
	 * @param d1 is the csvData
	 * @param index is the line for the single pacman.
	 */
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
		double x=Double.parseDouble(s[indexY]);
		double y=Double.parseDouble(s[indexX]);
		double z=Double.parseDouble(s[indexZ]);
		this.p=new Point3D(x,y,z);
		c= new Circle(this.p,rad);
		time=0;
		this.path=new ArrayList<shortestTime>();
		timeStemp="";
		
	}
	public String getTimeStemp() {
		return timeStemp;
	}
	public void setTimeStemp(String timeStemp) {
		this.timeStemp = timeStemp;
	}
	/**
	 * 
	 * @return an arrayList which represents the path of eating 
	 */
	public ArrayList<shortestTime> getPath() {
		return path;
	}
    /**
     * 
     * @return the location of the pacman
     */
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
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
	public String getId() {
		return this.id;
		
	}
	public void translate(Point3D vec) {
		this.p=m.add(p, vec);
		
	}
	public void setP(Point3D p) {
		this.p = p;
	}
}
