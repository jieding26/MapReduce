//package project1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Jie Ding, jied1
 * Find out the number of articles with longest number of strictly decreasing sequence of views
 * Example: If 21 articles have strictly decreasing pageviews everyday for 5 days 
 * (which is the global maximum), 
 * then your script should find these articles from the output file and return 21.
 */
public class project1_2_9 {
	// self design a method to find out the longest number of strictly decreasing sequence of views
	public static int dec(int[] views){
		int length = views.length;
		int count = 0;
		int i = 0;
		int j = 0;
		// start from first element
		while(i < length - 1){
			// because it is STRICTLY decrease, equals need to be except
			if(views[i] <= views[i + 1]){
				i++;
				continue;
			}
			else{
				for(j = i + 1; j < length - 1; j++){
					// because it is STRICTLY decrease, equals need to be except
					if(views[j] <= views[j + 1])  break;
				}
				count = Math.max(count, j - i + 1);
				i = j + 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read from output file
		BufferedReader sb = null;
		try {
			sb = new BufferedReader(new FileReader("output"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String input = null;
		int max = 0; // record the longest number of days so far
		int count = 0; // record the corresponding number of articles
		try {
			while((input = sb.readLine()) != null){
				String[] parts = input.split("\t");
				int[] views = new int[31]; // records everyday's views number
				for(int i = 2; i <= 32; i++){
					views[i - 2] = Integer.parseInt(parts[i].split(":")[1]);
				}
				int currDec = dec(views); // call dec method
				if(currDec > max){ // replace max if currDec > max
					max = currDec;
					count = 1;
					continue;
				}
				if(currDec == max) count++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(count);
    }
}
