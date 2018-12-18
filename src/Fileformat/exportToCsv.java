package Fileformat;

import java.io.FileWriter;
import java.io.IOException;

import Type.Game;

/**
 * this class responsible for exporting CSV
 * @author moshe and ariel
 *
 */

public class exportToCsv {
	/**
	 * 
	 * @param output to where to save the file.
	 * @param game to export
	 * @throws IOException
	 */
	public static void toCsv(String output,Game game) throws IOException {
		FileWriter pw = new FileWriter(output, true); //add in the end CSV 
        StringBuilder sb = new StringBuilder();
       
        sb.append("Type");
       
        sb.append(',');
        sb.append("id");
        sb.append(',');
        sb.append("Lat");
        sb.append(',');
        sb.append("Lon");
        sb.append(',');
        sb.append("Alt");
        sb.append(',');
        sb.append("Speed/Weight");
        sb.append(',');
        sb.append("Radius");
        sb.append(',');
        sb.append(game.getPackman().size());
        sb.append(',');
        
        sb.append(game.getFruit().size());
        sb.append('\n');
        //adding packmans
        for(int i=0;i<game.getPackman().size();i++) {
        	sb.append("P");
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getId());
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getPoint().y());
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getPoint().x());
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getPoint().z());
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getSpeed());
        	 
        	  sb.append(',');
        	  sb.append(game.getPackman().get(i).getRadiusOfeat());
        	  sb.append('\n');
        }
        //adding fruits
        for(int i=0;i<game.getFruit().size();i++) {
        	sb.append("F");
            sb.append(',');
            sb.append(game.getFruit().get(i).getId());
            sb.append(',');
            sb.append(game.getFruit().get(i).getPoint().y());
      	    sb.append(',');
      	    sb.append(game.getFruit().get(i).getPoint().x());
      	    sb.append(',');
      	    sb.append(game.getFruit().get(i).getPoint().z());
      	    sb.append(',');
      	    sb.append(game.getFruit().get(i).getWeight());
      	    sb.append('\n');
        }
        pw.write(sb.toString());
        pw.flush();
        pw.close();
        System.out.println("done!");
	}

}