//package project1_2;
//Jie Ding, andrewID: jied1
//How many lines emerged in your output files?
//single number to standard output

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class project1_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read from output file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("output"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int count = 0;
		String input;
		try {
			while((input = br.readLine()) != null){
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
