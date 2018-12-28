package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	private String message = "";
		
	public FileRecorder() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What message do you want to write?");
		message = keyboard.nextLine();
	}
	
	public void writeToFile() {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/write.txt", true);
			fw.write(message);
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
