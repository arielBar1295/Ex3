package GUI;

import Geom.Point3D;
import Maps.Way;
import Type.Packman;
/**
 * This class is extends of Thread.
 * The class responsible for moving the packman.
 * @author moshe
 *
 */
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

	/**
	 * when the thread is alive ,using the way class for calculating all the points in the packman's way
	 * Setting the packman's position to each point in the way ,and update the screen by repainting.
	 */
	@Override
	public void run() {
		way= new Way(this.p,this.time);
		way.wayto();
		Point3D pOrigin=p.getPoint();
		for (int i = 0; i < way.getWayOfP().size(); i++) {
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
