//package project1_2;
// Jie Ding, andrewID: jied1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String filePath = System.getenv("mapreduce_map_input_file"); // file path
		/* split into: "pagecounts", date, hour and sec
		 * we only need date to calculate the total views of that date
		 * just need to keep file name parts [1]
		 */
		// String[] filepathParts = filePath.split("/");
		// int pathLength = filepathParts.length; // the last part of file path is file name
		String[] filenameParts = filePath.split("-");
		// filter records
		try {
			while((input = br.readLine()) != null){
				String[] wordsList = input.split(" ");
				// rule 0
				if(wordsList[1].equals(""))  continue;
			    // rule 1
				if(wordsList[0].equals("en") == false) continue;
			    // rule 2
				if(wordsList[1].startsWith("Media:") ||
						wordsList[1].startsWith("Special:") ||
						wordsList[1].startsWith("Talk:") ||
						wordsList[1].startsWith("User:") ||
						wordsList[1].startsWith("User_talk:") ||
						wordsList[1].startsWith("Project:") ||
						wordsList[1].startsWith("Project_talk:") ||
						wordsList[1].startsWith("File:") ||
						wordsList[1].startsWith("File_talk:") ||
						wordsList[1].startsWith("MediaWiki:") ||
						wordsList[1].startsWith("MediaWiki_talk:") ||
						wordsList[1].startsWith("Template:") ||
						wordsList[1].startsWith("Template_talk:") ||
						wordsList[1].startsWith("Help:") ||
						wordsList[1].startsWith("Help_talk:") ||
						wordsList[1].startsWith("Category:") ||
						wordsList[1].startsWith("Category_talk:") ||
						wordsList[1].startsWith("Portal:") ||
						wordsList[1].startsWith("Wikipedia:") ||
						wordsList[1].startsWith("Wikipedia_talk:") ||
						// rule 4
						wordsList[1].endsWith(".jpg") ||
						wordsList[1].endsWith(".gif") ||
						wordsList[1].endsWith(".png") ||
						wordsList[1].endsWith(".JPG") ||
						wordsList[1].endsWith(".GIF") ||
						wordsList[1].endsWith(".PNG") ||
						wordsList[1].endsWith(".txt") ||
						wordsList[1].endsWith(".ico") ){
					continue;
				}
				// rule 3
				if(wordsList[1].charAt(0) >= 'a' && wordsList[1].charAt(0) <= 'z')
					continue;
				// rule 5	
				if(wordsList[1].equals("404_error/") ||
						wordsList[1].equals("Main_Page") ||
						wordsList[1].equals("Hypertext_Transfer_Protocol") ||
						wordsList[1].equals("Search"))
					continue;
				/* print out
				 * title + date + number of accesses
				 * in this way, the MapReduce sort can sort based on the article title and then date
				 * therefore, 20151201 must appear before 20151202
				 */
				System.out.println(wordsList[1] + " " + filenameParts[2] + "\t" + wordsList[2]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
