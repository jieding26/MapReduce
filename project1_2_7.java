//package project1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Jie Ding, jied1
 * Rank the operating systems in the file q7 based on their total month views page views
 * (In descending order of page views, with the highest one first. In descending alphabetical order by name
 * if the pageviews are same;
 * OS_X,Android_(operating_system),Windows_10,Linux
 */
public class project1_2_7 {

	/* self design a comparator
	 * to compare between input
	 * rank by the views first (descending)
	 * then by the name (descending)
	 */
	private class comparator implements Comparator<String>{
	    public int compare(String str1, String str2) {
	    	// string format: views \t name
	    	String[] words1 = str1.split("\t");
	    	String[] words2 = str2.split("\t");
	    	int count1 = Integer.parseInt(words1[0]);
	    	int count2 = Integer.parseInt(words2[0]);
	    	String name1 = words1[1];
	    	String name2 = words2[1];
	    	if(count1 != count2) return -Integer.compare(count1, count2);
	    	else return -name1.compareTo(name2);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read from q7, save os names into arraylist oss
		BufferedReader brQ7 = null;
		try {
			brQ7 = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String os = null;
        ArrayList<String> oss = new ArrayList<String>();
        try {
			while((os = brQ7.readLine()) != null){
				oss.add(os);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //int number = oss.size(); // os number
        
        //read from output
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("output")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		String input = null;
		ArrayList<String> array = new ArrayList<String>(); // records lines from output
        try {
			while((input = br.readLine()) != null){
				/*
				 * input format:
				 * [total month views]\t[article name]\t[date1:page views for date1]\t[date2:page views for date2]
				 */
				String[] parts = input.split("\t");
				String curr = parts[0] + "\t" + parts[1]; // views \t title
				for(String str : oss){
					if(parts[1].equals(str))
						array.add(curr);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        project1_2_7 prj127 = new project1_2_7();
        Collections.sort(array, prj127. new comparator()); // sort array by the rules of comparator
        StringBuilder sb = new StringBuilder();
        for(String str : array){
        	sb.append(str.split("\t")[1] + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));

	}

}
