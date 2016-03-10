//package project1_2;

/*
 * Jie Ding, andrewID: jied1
 * Rank the movie titles in the file q6 based on their maximum single-day wikipedia page views 
 * (In descending order of page views, with the highest one first):
 * Jurassic_Park_(film),The_Hunger_Games_(film),Fifty_Shades_of_Grey_(film),The_Martian_(film),Interstellar_(film)
 * Ensure that you print the answers comma separated (As shown in the above line) without spaces
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;

public class project1_2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read movie names from file q6
        BufferedReader brQ6 = null;
		try {
			brQ6 = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String movie = null;
        ArrayList<String> movies = new ArrayList<String>(); // records movie names
        // put movie into arraylist
        try {
			while((movie = brQ6.readLine()) != null){
				movies.add(movie);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int number = movies.size(); // movies number
        
        // read from output
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("output"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String input = null;
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        try {
			while((input = br.readLine()) != null){
				/*
				 * input format:
				 * [total month views]\t[article name]\t[date1:page views for date1]\t[date2:page views for date2]
				 */
				String[] parts = input.split("\t");
				if(movies.contains(parts[1])){
					int max = 0;
					for(int i = 1; i < 32; i++){ // i represents date, eg 01
						int curr = Integer.parseInt(parts[i + 1].split(":")[1]);
						if(max < curr) max = curr;
					}
					map.put(max, parts[1]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        StringBuilder sb = new StringBuilder();
        for(int count : map.keySet()){
        	sb.insert(0, map.get(count) + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
	}

}
