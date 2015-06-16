import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import java.io.*;

//Used some code from http://stackoverflow.com/questions/3697833/find-all-string-the-in-txt-file
public class Search {
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		try {
			
			String s1 = "Makar Alexeevich";
			String s2 = "Joseph Bazdeev";
			String s3 = "Boris Drubetskoy";
			
			BufferedReader bf = new BufferedReader(new FileReader("WarAndPeace.txt"));
			int lineCount = 1;
			String line;
			System.out.println("Searching for " + s1 + ", " + s2 + ", and "+ s3 + " in file WarAndPeace.txt...\n");
			System.out.printf("%-12s%-12s%s\n", "LINE", "POSITION", "NAME");
			
			while ((line = bf.readLine()) != null) {
				bf.mark(80);
				String line2 = bf.readLine();
				int indexFound = line.indexOf(s1);
				int indexFound2 = line.indexOf(s2);
				int indexFound3 = line.indexOf(s3);
				
				/* checks if string wraps to next line*/
				if (line.endsWith("Makar") && line2.startsWith("Alexeevich")) {
					indexFound = line.indexOf("Makar");
				}
				if (line.endsWith("Joseph") && line2.startsWith("Bazdeev")) {
					indexFound2 = line.indexOf("Joseph");
				}
				if (line.endsWith("Boris") && line2.startsWith("Drubetskoy")) {
					indexFound3 = line.indexOf("Boris");
				}
				
				/* Prints results if string is found*/
				if (indexFound > -1) {
					System.out.printf("%-12d%-12d%s\n", lineCount,(indexFound + 1), s1);
				}
				if (indexFound2 > -1) {
					System.out.printf("%-12d%-12d%s\n", lineCount,(indexFound2 + 1), s2);
				}
				if (indexFound3 > -1) {
					System.out.printf("%-12d%-12d%s\n", lineCount, (indexFound3 + 1), s3);
				}
				bf.reset();
				lineCount++;
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Error Occurred: " + e.toString());
		}
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time elapsed: " + elapsed + " milliseconds");
	}
}