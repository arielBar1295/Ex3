package Maps;

import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Geom.Point3D;
/**
 * the class "Convert" responsible for converting from pixels to coordinates and the other way around.
 * @author ariel and moshe 
 * helping source code  : https://gamedev.stackexchange.com/questions/32555/how-do-i-convert-between-two-different-2d-coordinate-systems
 */
public class Convert {
    
   final Point3D min=new Point3D(35.20238,32.10190);
   final Point3D max=new Point3D(35.21236,32.10569);
   public static BufferedImage myImage; 
   /**
    * a constructor which reads an image.
    */
   public Convert()
   {
		try {
			 myImage = ImageIO.read(new File("C:\\Users\\ariel\\image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
   /**
    * the function normalize the points ,means after normalization the points will be between 0-1
    * @param value
    * @param min 
    * @param max
    * @return
    */
   public static double normalize(double value, double min, double max) {
	    return Math.abs((value - min) / (max - min));
	}
   /**
    * the function converts pixels to coordinates 
    * @param p is the point in pixel  
    * @return a new point in coordinates.
    */
   public Point3D pixToCo(Point3D p) {
	   double y=0;
	   
	   double xPercent=normalize(p.x(),0,myImage.getWidth());
	   double x =xPercent*Math.abs(max.x()-min.x())+min.x();
	   double yPercent=normalize(p.y(),0,myImage.getHeight());
	   if (yPercent>=0.5) {
		    y=yPercent*Math.abs(max.y()-min.y())+min.y();
		  
		   double eps=max.y()-y;
		  
		   y=min.y()+eps;
		  
	   }
	   else if(yPercent<0.5)
	   {
		    y=yPercent*Math.abs(max.y()-min.y())+min.y();
		   double eps=y-min.y();
		   y=max.y()-eps;
		   
	   }
	  
	   return new Point3D(x,y);
   }
   /**
    * the function converts a coordinates into pixels.
    * @param p is the point in coordinates
    * @return a new point in pixels.
    */
   public Point3D conToPix(Point3D p) {
	   double y=0;
	   double xPercent=normalize(p.x(),min.x() , max.x());
	   double x =xPercent*Math.abs(myImage.getWidth()-0);
	   double yPercent = normalize(p.y(), min.y(), max.y());
	   if (yPercent>=0.5) {
		   y=yPercent*Math.abs(myImage.getHeight());
		   double eps = myImage.getHeight() - y;
		   y= eps;
	   }else if(yPercent<0.5) {
		   y=yPercent*Math.abs(myImage.getHeight());
		   double eps =  y;
		   y=myImage.getHeight()- eps;
	   }
	   return new Point3D(x,y);
   }
   


   
   

}
