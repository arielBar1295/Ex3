package Fileformat;
import java.util.ArrayList;

import Geom.Point3D;
/**
 * csvData holds the data which was taken by the csvReader ,using an ArrayList.
 * @author ariel and moshe 
 *
 */
public class CsvData {
	
	private CsvReader c;
	String[] header;
	ArrayList<String[]> a1;
	/**
	 * A COONSTRUCTOR
	 * @param s is a location of the file.
	 */
	public CsvData(String s) {
		//filling the arrayList with information by the csvReader which gets a location.
		a1=c.csvReader(s);
		//filling the header array with the first line of the arrayList
		header=a1.get(0);
	}

	public String[] getHeader() {
		return header;
	}

	public ArrayList<String[]> getA1() {
		return a1;
	}
	/**
	 * 
	 * @param s the header of which row to return .
	 * @return the row of the header.
	 */
	
public String getRaw(String s) {
	int index=0;
	String ans="";
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			index=i;
	}
	for(int i=1;i<a1.size();i++) {
		ans+=a1.get(i)[index]+",";
	}
	return ans;
}
/**
 * 
 * @param i is the line of data 
 * @return the line of data accordingly .
 */
public String[] getLine(int i) {
	return a1.get(i);
}
/**
 * 
 * @param s is the header 
 * @param index is which line to take the information from.
 * @return the specific element
 */
public String getElement(String s,int index) {
	int temp=0;
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			temp=i;
	}
	return a1.get(index)[temp];
}
/**
 * 
 * @param s the header
 * @return the index of the header.
 */
public int getIndexOfHeader(String s) {
	int index=0;
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			index=i;
	}return index;
}

	
}