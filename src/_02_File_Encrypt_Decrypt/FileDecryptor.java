package _02_File_Encrypt_Decrypt;

import java.util.Scanner;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	String message = "";
	String dMessage = "";
	
	public FileDecryptor(String m) {
		message = m;
	}
	
	public String Decrypt() {
		for (int i=0; i<message.length(); i++) {
			dMessage += (char)(message.charAt(i) -1);
		}
		System.out.println(dMessage);
		return dMessage;
	}
}
