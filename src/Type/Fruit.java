package Type;

import Fileformat.CsvData;
import Geom.Circle;
import Geom.Point3D;

public class Fruit {
	private Circle c;
	public CsvData data;
	private int index;
	private String[] s;
	private String id;
	final int rad=1;
	public Point3D p;
	public Fruit(Point3D p){
		this.p=p;
		
	}
	public Fruit(CsvData d1,int index){
	
		this.data=d1;
		this.index=index;
		s=d1.getLine(index);
		int indexX=d1.getIndexOfHeader("Lat");
		int indexY=d1.getIndexOfHeader("Lon");
		int indexZ=d1.getIndexOfHeader("Alt");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		int indexOfid=d1.getIndexOfHeader("id");
		this.id = s[indexOfid];
		this.p=new Point3D(x,y,z);
		c= new Circle(this.p,rad);
		
	}
	
	
	
	public String toString() {
		return id+",Fruit";
		
	}
	
	
	public Point3D getPoint() {
		return p;
	}
}










