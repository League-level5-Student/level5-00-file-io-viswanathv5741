package _02_File_Encrypt_Decrypt;

public class EncryptTester {
	
	public static void main(String[] args) {
		FileEncryptor fe = new FileEncryptor();
		String dec = fe.Encrypt();
		
		FileDecryptor fd = new FileDecryptor(dec);
		fd.Decrypt();
	}
}
