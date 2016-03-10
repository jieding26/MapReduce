//package project1_2;
/*
 * Jie Ding, andrewID: jied1
 * What was the most popular article on December 18, 2015 from the filtered output? 
 * How many daily views did the most popular article get on December 18?
 * Run your commands/code to process the output and echo <article_name>\t<daily views>
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class project1_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("output"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String input;
		int max = 0;
		String title = null;
		try {
			while((input = br.readLine()) != null){
				/* input format:
				 * [total month views]\t[article name]\t[date1:page views for date1]\t[date2:page views for date2]... 
				 */
				String[] parts = input.split("\t");
				String dec18 = parts[19];
				int view = Integer.parseInt(dec18.split(":")[1]);
				if(view > max){
					max = view;
					title = parts[1];
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title + "\t" + max);
	}

}
