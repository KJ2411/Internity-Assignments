import java.io.*;
public class FileHandling {

	public static void main(String[] args) throws IOException {
		
		try {
			File file = new File("g:\\file.txt");
			if (file.createNewFile()){
				System.out.println("File is created!");
				}
			else{
				System.out.println("File already exists.");
				}
			/*
			 * IMPORTANT FILE FUNCTIONS
			 * 
			 * // Check if the corresponding file or directory actually exists
			boolean fileExists = file.exists();

			// Create a single directory if it does not already exist
			boolean directoryCreated = file.mkdir();

			// Read the length of the file in bytes
			long length = file.length();

			// Rename or move a file or directory:
			boolean renameSuccessful = file.renameTo(new File("c:\\new-file.txt"));

			// Delete the file or directory
			boolean success = file.delete();

			// Check if the File object points to a directory
			boolean isDirectory = file.isDirectory();

			// Check if the file/directory is hidden
			boolean isHidden = file.isHidden();

			// Get a list (an array) of all the names of the files/directories in a directory
			String[] fileNames = file.list();

			// Get a list of all files/directories in a directory as instances of File
			File[]   files = file.listFiles();*/
		}
		catch (Exception e) {
		  System.out.println(e);
		}
	}
}
