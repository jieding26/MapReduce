//package project1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Jie Ding, jied1
 * What is the most popular article of December 2015 with ZERO views on December 1, 2015?
 */
public class project1_2_4 {

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
        String max = null;
        String title = null;
        try {
			while((input = br.readLine()) != null){
				/*
				 * input format:
				 * [total month views]\t[article name]\t[date1:page views for date1]\t[date2:page views for date2]
				 */
				String[] parts = input.split("\t");
				
				//if Dec 1 != ZERO, continue
				String dec1 = parts[2]; // 20151201:xx
				String dec1Count = dec1.split(":")[1];
				if(!dec1Count.equals("0")) continue;
				
				String count = parts[0];
				String name = parts[1];
				//initialize max, title
				if(max == null){
					max = count;
					title = name;
				}
				//esle, normal compare
				if(max.length() == count.length() && max.compareTo(count) < 0){
					max = count;
					title = name;
				}
				else if(max.length() < count.length()){
					max = count;
					title = name;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(title);
	}

}
