package Fileformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CsvReader {
	/**
	 * 
	 * @param S is a location for the csv file
	 * @return  ArrayList which holds the information of the csv file.
	 */
	//the source code was taken from the moodle
	public  static ArrayList<String[]> csvReader(String S){
		String csvFile = S;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> data=new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{   
			//br.readLine();


			while ((line = br.readLine()) != null) 
			{   //put the information into an array,in the end ,add to the array list.
				String[] userInfo = line.split(cvsSplitBy);
				data.add(userInfo);

			}


		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	public  static ArrayList<String[]> csvReader(File F){

		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> data=new ArrayList<String[]>();
		 FileReader File = null;
		try {
			File = new FileReader(F);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(File) )
		{   
			//br.readLine();


			while ((line = br.readLine()) != null) 
			{   //put the information into an array,in the end ,add to the array list.
				String[] userInfo = line.split(cvsSplitBy);
				data.add(userInfo);

			}


		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return data;
	}

}