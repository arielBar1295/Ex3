package GUI;


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

public class Path2Kml {

	
	
	
	
	
	
public static void  projectToKml(Game game ,String output) {
	

//	ArrayList<String> content=new ArrayList<String>();
//	String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>\n";
//	content.add(KmlStart);
//	String kmlend = " </Document>\n"+"</kml>";
//	
//	try {
//
//		FileWriter fw = new FileWriter(output);
//		BufferedWriter bw = new BufferedWriter(fw);
//		int counter=0;
//		
//			
//			//creating a new folder for each layer
////			String fold="<Folder>\n"+"<name>"+"packman"+"</name>\n";
////			String endfold="</Folder>\n";
////			content.add(fold);
//			//running over the elements.
//			for(int i=0;i<game.getPackman().size();i++){
//				String fold="<Folder>\n"+"<name>"+"packman" + i+"</name>\n";
//				String endfold="</Folder>\n";
//				content.add(fold);
//			//	System.out.println("time:"+game.getPackman().get(i).getPath().get(i).getTime());
//				double timeF=(game.getPackman().get(i).getPath().get(0).getTime())/60;
//				String []arr=game.getPackman().get(i).getTimeStemp().split(",");
//				System.out.println(arr[1]);
//				String timeforF=addMin(arr[1],timeF);
//				for(int j=2;j<game.getPackman().get(i).getPath().size();j++) {
//				
//					String temp= arr[0]+"T"+timeforF+"Z";
//				        String kmlelement ="<Placemark>\n" +
//						"<name>"+game.getPackman().get(i).getPath().get(j).getFruitId()+"</name>\n" +
//						"<TimeStamp>\n"+
//						"<when>"+temp+"</when>\n"+
//						"</TimeStamp>\n"+
//						//"<description>"+data[1]+"&"+data[2]+"</description>\n"+
//						"<Point>\n"+
//						"<coordinates>"+game.getPackman().get(i).getPath().get(j).getP().x()+"&"+game.getPackman().get(i).getPath().get(j).getP().y()+"&"+game.getPackman().get(i).getPath().get(j).getP().z()+"</coordinates>" +
//						"</Point>\n" +
//						"</Placemark>\n";
//				content.add(kmlelement);
//				timeforF=addMin(timeforF,timeF);
//			}
//			content.add(endfold);
//		}
//        //for closing the kml
//		content.add(kmlend);
//		String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
//		csv=csv.replaceAll("&",",");
//		bw.write(csv);
//		bw.close();
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
	

	ArrayList<String> content=new ArrayList<String>();
	String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>\n";
	content.add(KmlStart);
	String kmlend = " </Document>\n"+"</kml>";	
	try {

		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		int counter=0;
		Point3D pac=null;
		Point3D f1=null;
		for(int i=0;i<game.getPackman().size();i++) {
			String fold="<Folder>\n"+"<name>"+"packman" + i+"</name>\n";
		    String endfold="</Folder>\n";
     		content.add(fold);
     		int sum=0;
     		String []date=game.getPackman().get(i).getTimeStemp().split(",");
     		//Point3D pac=new Point3D(game.getPackman().get(i).getPoint());
     		for(int j=0;j<game.getPackman().get(i).getPath().size();j++) {
//     			if(j<game.getPackman().get(i).getPath().size()-1) {
//     			 pac=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
//     			 f1=new Point3D(game.getPackman().get(i).getPath().get(j+1).getP());
//     			}
//     			else {
//     				 pac=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
//         			 f1=new Point3D(game.getPackman().get(i).getPath().get(j).getP());
//     			}
     			sum+=game.getPackman().get(i).getPath().get(j).getTime();
     			sum/=60;
     			System.out.println("sum: "+ sum);
     			String timeForFruit=addMin(date[1],sum);
     			String temp= date[0]+"T"+timeForFruit+"Z";
     			System.out.println("themp: "+temp);
     			  String kmlelement ="<Placemark>\n" +
  						"<name>"+game.getPackman().get(i).getPath().get(j).getFruitId()+"</name>\n" +
//     					 "<LineString>"+
//  						"<coordinates>"+pac.x()+"&"+pac.y()+"&"+pac.z()+"&"+f1.x()+"&"+f1.y()+"</coordinates>"+
//   					 "</LineString>"+
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
     		content.add(endfold);
		}
		
		
		content.add(kmlend);
		String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
		csv=csv.replaceAll("&",",");
		bw.write(csv);
		bw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
private static String addMin(String time,double timeF) {
	//System.out.println(timeF);
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
	 System.out.println("new :"+newTime);
	 return newTime;
}

}
