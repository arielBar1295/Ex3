package GUI;

import Geom.Point3D;
import Maps.Way;
import Type.Packman;

public class move extends Thread {
	private ImageBackground ImageBackground;
	private Packman p;
	private double time;
	Way way;

	public move(ImageBackground _ImageBackground,Packman _p,double _time) {
		this.ImageBackground=_ImageBackground;
		this.p=_p;
		this.time=_time;
		

	}

//	public void run() {
//		Point3D pOrigin=p.getPoint();
//		for (int i = 0; i < way.getWayOfP().size(); i++) {
//			System.out.println(way.getWayOfP().get(i));
//			p.setP(way.getWayOfP().get(i));
//			try {
//				move.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			ImageBackground.update();
//			
//		}
//		p.setP(pOrigin);
//		ImageBackground.update();
//	
//	}
	
	@Override
	public void run() {
		way= new Way(this.p,this.time);
		way.wayto();
		Point3D pOrigin=p.getPoint();
		//System.out.println("5");
		//System.out.println(way.getWayOfP().size());
		for (int i = 0; i < way.getWayOfP().size(); i++) {
			//System.out.println(way.getWayOfP().get(i));
			p.setP(way.getWayOfP().get(i));

			ImageBackground.update();
			try {
				move.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		p.setP(pOrigin);
		ImageBackground.update();
	
		
	}

}
