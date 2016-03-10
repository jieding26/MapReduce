//package project1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Jie Ding, andrewID: jied1
 *What was the least popular article in the filtered output? How many total views
 *did the least popular article get over the month?
 *Run your commands/code to process the output and echo <article_name>\t<total views>
 *Break ties in reverse alphabetic order (if "ABC" and "XYZ" both have the minimum views, return "XYZ")
 */
public class project1_2_2 {

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
		String least = null; // records the current least value
		String title = null; // records the title
		try {
			while((input = br.readLine()) != null){
				String[] parts = input.split("\t");
				String count = parts[0];
				// initialize least and title, when they are null
				if(least == null){
					least = count;
					title = parts[1];
				}
				//if there is a tie
				if(count.equals(least) && title.compareTo(parts[1]) < 0){
					title = parts[1];
				}
				//else, normal compare
				if(count.length() == least.length()){
					if(count.compareTo(least) < 0){
						least = count;
						title = parts[1];
					}
				}
				else{
					if(count.length() < least.length()){
						least = count;
						title = parts[1];
					}
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title + "\t" + least);
	}

}
