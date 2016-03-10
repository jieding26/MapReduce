//package project1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Jie Ding, jied1
 * How many films in the dataset also have a corresponding TV series?
 * Films are named <article_name>_([year_]film) 
 * TV_series are named <article_name>_([year]_TV_series)
 * 1. The article_name must be identical in both the film and TV_series
 * 2. The film or TV_series *may* be accompanied by a 4 digit year
 * Examples of valid cases:
 * a. Concussion_(2015_film) is a match for Concussion_(TV_series)
 * b. Scream_Queens_(2015_TV_series) is a match for Scream_Queens_(1929_film)
 */
public class project1_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("output"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String input = null;
		int count = 0;
		ArrayList<String> films = new ArrayList<String>(); // records film names
		ArrayList<String> tvs = new ArrayList<String>(); // records TV series names
		
		try {
			while((input = br.readLine()) != null){
				String title = input.split("\t")[1];
				// only if it is film or TV series can be processed
		        if(!title.endsWith("film)") && !title.endsWith("TV_series)")) continue;
				String name = title.split("[(]")[0]; 
				if(title.endsWith("film)"))
					films.add(name);
				if(title.endsWith("TV_series)"))
					tvs.add(name);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String film : films){ // if films and tvs both have, then count + 1
			if(tvs.contains(film)) count++;
		}
		System.out.println(count);

	}

}
