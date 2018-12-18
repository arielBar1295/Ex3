package Fileformat;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Geom.Point3D;
import Type.Game;
/**
 * This class responsible for creating Kml page.
 * @author moshe and ariel
 *
 */
public class Path2Kml {

public static void  projectToKml(Game game ,String output) {
	ArrayList<String> content=new ArrayList<String>();
	String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>\n";
	content.add(KmlStart);
	String kmlend = " </Document>\n"+"</kml>";	
	try {

		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		Point3D pac=null;
		Point3D f1=null;
		//first running over the path of each packman and draw a line
		for(int i=0;i<game.getPackman().size();i++) {
			String fold="<Folder>\n"+"<name>"+"packman" + i+"</name>\n";
		    String endfold="</Folder>\n";
     		content.add(fold);
     		String []date=game.getPackman().get(i).getTimeStemp().split(",");
     		for(int j=0;j<game.getPackman().get(i).getPath().size();j++) {
     			if(j<game.getPackman().get(i).getPath().size()-1) {
     			 pac=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
     			 f1=new Point3D(game.getPackman().get(i).getPath().get(j+1).getP());
     			}
     			else {
     				 pac=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
         			 f1=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
     			}
     			  String kmlelement ="<Placemark>\n" +
     					 "<LineString>"+
  						"<coordinates>"+pac.x()+"&"+pac.y()+"&"+pac.z()+"&"+f1.x()+"&"+f1.y()+"</coordinates>"+
   					 "</LineString>"+
 						"</Placemark>\n";
 				        content.add(kmlelement);
     		}
     		content.add(endfold);
		}
		//running over the path of each packman and mark the point
		for(int i=0;i<game.getPackman().size();i++) {
			String fold="<Folder>\n"+"<name>"+"packman" + i+"</name>\n";
		    String endfold="</Folder>\n";
		    content.add(fold);
		    int sum=0;
		    String []date=game.getPackman().get(i).getTimeStemp().split(",");
		for(int j=0;j<game.getPackman().get(i).getPath().size();j++) {
			sum+=game.getPackman().get(i).getPath().get(j).getTime();
 			sum/=60;
 			
 			String timeForFruit=addMin(date[1],sum);
 			String temp= date[0]+"T"+timeForFruit+"Z";
 			if(j==0) {   //meaning its a packman
 				 String kmlelement ="<Placemark>\n" +
 						"<name>"+game.getPackman().get(i).getPath().get(j).getFruitId()+"</name>\n" +
                       "<Style id="+"\"downArroIcon\""+">"+
 						"<IconStyle>"+
                       "<Icon>"+
 						"<href>http://maps.google.com/mapfiles/kml/paddle/ylw-circle.png</href>"+
                       "</Icon>"+
 						"</IconStyle>"+
                       "</Style>"+
 					"<TimeStamp>\n"+
 						"<when>"+temp+"</when>\n"+
 						"</TimeStamp>\n"+
 						//"<description>"+da1ta[1]+"&"+data[2]+"</description>\n"+
 					"<Point>\n"+
 					"<coordinates>"+game.getPackman().get(i).getPath().get(j).getP().x()+"&"+game.getPackman().get(i).getPath().get(j).getP().y()+"&"+game.getPackman().get(i).getPath().get(j).getP().z()+"</coordinates>" +
 					"</Point>\n" +
 						"</Placemark>\n";
 				        content.add(kmlelement);
 			}
 			else {   //its a fruit
 			 String kmlelement ="<Placemark>\n" +
						"<name>"+game.getPackman().get(i).getPath().get(j).getFruitId()+"</name>\n" +
                      "<Style id="+"\"downArroIcon\""+">"+
						"<IconStyle>"+
                      "<Icon>"+
						"<href>http://maps.google.com/mapfiles/kml/paddle/F.png</href>"+
                      "</Icon>"+
						"</IconStyle>"+
                      "</Style>"+
					"<TimeStamp>\n"+
						"<when>"+temp+"</when>\n"+
						"</TimeStamp>\n"+
						//"<description>"+da1ta[1]+"&"+data[2]+"</description>\n"+
					"<Point>\n"+
					"<coordinates>"+game.getPackman().get(i).getPath().get(j).getP().x()+"&"+game.getPackman().get(i).getPath().get(j).getP().y()+"&"+game.getPackman().get(i).getPath().get(j).getP().z()+"</coordinates>" +
					"</Point>\n" +
						"</Placemark>\n";
				        content.add(kmlelement);
 			}
  			
		}
		content.add(endfold);
		}
		
		//closing the kml
		content.add(kmlend);
		String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
		csv=csv.replaceAll("&",",");
		bw.write(csv);
		bw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
/**
 * the function gets origin time represent :("HH:mm:ss") and minutes to add .
 * @param time is the origin time
 * @param timeF is the minutes to add
 * @return the new time after adding the minutes.
 */
private static String addMin(String time,double timeF) {
	
	 String myTime = time;
	 SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	 java.util.Date d = null;
	try {
		d = df.parse(myTime);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(d);
	 cal.add(Calendar.HOUR, -2);
	 cal.add(Calendar.MINUTE, (int)timeF);
	 String newTime = df.format(cal.getTime());
	 return newTime;
}

}
