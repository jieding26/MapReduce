// package project1_2;
// Jie Ding, andrewID: jied1
// 0128

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Reducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input = null;
		String currTitle = null;
		// map <date, daily access #>
		int[] records = new int[32]; // records daily count
		for(int i = 0; i < 32; i++) records[i] = 0; // initialize the records as 0
		int total = 0; // records monthly total
		int firstDay = 0; // the first day of current month
		int lastDay = 0; // the last day of current month
		
		// input: title " " date "\t" number of accesses
		try {
			while((input = br.readLine()) != null){
				String[] parts = input.split("\t");
				String title = parts[0].split(" ")[0];  // this line's title
				String fullDay = parts[0].split(" ")[1]; // this line's day, eg 20151201
				int day = Integer.parseInt(fullDay.substring(6)); // extract the day, eg 01
				int count = Integer.parseInt(parts[1]); // this lines' access number
				
				/* if is the first line
				 * put into map
				 * add access# to total
				 */
				if(currTitle == null){
					currTitle = title;
					records[day] = count;
					total = count;
					firstDay = Integer.parseInt(fullDay.substring(0, 6) + "01"); // initialize the firstDay, eg 20151201
					lastDay = firstDay + 30; // initialize last day, eg 20151231
					continue;
				}
				
				/* if it is the same article
				 * corresponding access number = count
				 * add access# to total
				 */
				if(currTitle.equals(title)){
					records[day] += count;
					total += count;
				}
				
				/* if is different article
				 * if(total > 100,000)
				 *   loop from firstDay to lastDay ( 31 days ), if contains the day, output value; else 0
				 * initialize all parameters
				 */
				if(!currTitle.equals(title)){
					if(total > 100000){
						System.out.print(total + "\t" + currTitle + "\t");
						for(int i = firstDay; i <= lastDay; i++){
								System.out.print(i + ":" + records[i - firstDay + 1] + "\t");
							}
						System.out.println();
					}
					currTitle = title;
					records = new int[32];
					for(int i = 0; i < 32; i++) records[i] = 0; // initialize the records as 0
					records[day] = count;
					total = count;
				}
			}
			// the last article
			if(total > 100000){
				System.out.print(total + "\t" + currTitle + "\t");
				for(int i = firstDay; i <= lastDay; i++){
						System.out.print(i + ":" + records[i - firstDay + 1] + "\t");
				}
				System.out.println();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
