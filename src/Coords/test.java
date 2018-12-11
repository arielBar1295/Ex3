package Coords;

import Geom.Point3D;

public class test {
	public static void main(String[] args) {
		MyCoords m= new MyCoords();
		Point3D n1 = new Point3D (32.103315,35.209039,670);
		Point3D n2 = new Point3D (32.106352,35.205225,650);
		Point3D n3 = new Point3D(337.699,-359.249,-20);
		Point3D n4 = m.add(n1, n3);
		double d =m.distance3d(n1, n2);
		System.out.println(d);
		System.out.println(n4);
		System.out.println(m.isValid_GPS_Point(n4));
		
	}
	


}
