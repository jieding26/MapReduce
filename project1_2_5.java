//package project1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Jie Ding, andrewID: jied1
 * For how many days over the month was the page titled "Twitter" more popular 
 * than the page titled "Apple_Inc." ?
 * Run your commands/code to process the dataset and echo a single number to standard output
 * Do not hardcode the articles, as we will run your code with different articles as input
 * For your convenience, "Twitter" is stored in the variable 'first', and "Apple_Inc." in 'second'.
 */
public class project1_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader (new FileReader("output"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String input = null;
		String first = args[0];
		String second = args[1];
		int result = 0;
		int[] firstCount = new int[32]; //records first title's daily views
		int[] secondCount = new int[32]; //records second title's daily views
		
		try {
			while((input = br.readLine()) != null){
				/*
				 * input format:
				 * [total month views]\t[article name]\t[date1:page views for date1]\t[date2:page views for date2]
				 */
				String[] parts = input.split("\t");
				String title = parts[1];
				if(title.equals(first)){
					for(int i = 1; i < 32; i++){ // i denotes date, eg i = 1, represents 1201
						firstCount[i] = Integer.parseInt(parts[i + 1].split(":")[1]);
					}
				}
				if(title.equals(second)){
					for(int i = 1; i < 32; i++){ // i denotes date, eg i = 1, represents 1201
						secondCount[i] = Integer.parseInt(parts[i + 1].split(":")[1]);
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
		for(int i = 1; i < 32; i++){
			if(firstCount[i] > secondCount[i]) result++;
		}
		System.out.println(result);

	}

}
