package _02_File_Encrypt_Decrypt;

import java.util.Scanner;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
	String eMessage = "";
	String message = "";
	
	public FileEncryptor() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type the message you want to encrypt");
		message = keyboard.nextLine();
	}
	
	public String Encrypt() {
		for (int i=0; i<message.length(); i++) {
			eMessage += (char)(message.charAt(i) + 1);
		}
		System.out.println(eMessage);
		return eMessage;
	}
}
