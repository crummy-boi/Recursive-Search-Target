/**
 * Name: Nuranissa Sofia Abdul Wahid
 * CSS 143 A
 * Assignment: DirFileSearch, part one of Recursion. To track
 * and find file target in a directed file and to practise
 * using recursion.
 * 
 * I used the 48 hour extension on this homework
 */
package Recursion;
import java.io.File;
import java.util.ArrayList;
/**
 * @author Nuranissa Sofia Abdul Wahid
 * A class that searches the target file through a pathway with recursive.
 * It recurses in directoarySearch until the file matches with the target
 * file. Checks if the searched file reaches the max files to find, is in
 * the directory, and is null. Prints where the target file is.
 * 
 * I used the 48 hour extension on this homework
 */
public class FindFile {
	/*acts as a limiter for the files searched*/
	private int maxFiles;
	/*to count the number of matched files*/
	private int count = 0;
	/*to store all the matched files*/
	public ArrayList<String> listFile = new ArrayList<String>();

	/**
	 * to set this class's maxFiles to the passed max number of files
	 * */
	FindFile(int maxFiles){
		this.maxFiles = maxFiles;
	}

	/**
	 * searches the target file through the directory through recursion.
	 * Keeps recursing until the it reaches the target file. If reached,
	 * the file is added to the ArrayList listFile, which stores all matched
	 * files. If not, keep recursing. If file is not in the directory or the
	 * searched files reaches the max files to find, throw an IllegalArgumentException
	 * to the main driver. If the file is null, print the null error and exit the
	 * program
	 * */
	public void directorySearch(String target, String dirName){
		/*to be used to check if file is in the directory*/
		File checkFile = new File(dirName);
		/*if file is not in directory, throw an IllegalArgumentException to the main
		 * driver, printing an error that the pathway is not a valid directory*/
		if(!(checkFile.isDirectory())){
			throw new IllegalArgumentException("Error: " + dirName + " is not a valid directory");
		}
		/*to print where every pathway is searched, matched or not*/
		System.out.println("Searching " + target + " for " + dirName);
		/*to catch if any of the files in searching are null. If so, catch the
		 * NullPointerException and print the error that null files disrupts with
		 * the array and that all files must not be null*/
		try {
			/*all sub directories are in an array, all the file locations*/
			File[] file = new File(dirName).listFiles();
			/*loops through each file length*/
			for(int i = 0; i < file.length; i++) {
				/*if number of target files matches with max number of files to find,
				 * throw an IllegalArgumentException to the main driver, commenting about this*/
				if(this.count == this.maxFiles) {
					throw new IllegalArgumentException("Error: Files reached max number of files to find");
				}
				/*if the file matches the target file, increment count and store it to 
				 * the listFile to be printed later*/
				else if(file[i].getName().equals(target)) {
					this.count++;
					listFile.add(file[i].getPath());
				}
				/*if the file does not match the target file, is under the max number of
				 * files, and is in the same directory, recurse the method directorySearch*/
				else if(file[i].isDirectory()) {
					directorySearch(target, file[i].getPath());
				}

			}
		}
		/*clarified above the try block. In short, catches any files with null, prints null error,
		 * and exits the program*/
		catch(NullPointerException e) {
			System.out.println("NullPointerException: ");
			System.out.println("Error: " + e.getMessage());
			System.out.println("All files must not be null");
			System.exit(0);
		}
	}

	/*return number of matching files found*/
	int getCount() {
		return this.count;
	}

	/*returns the list of matched file locations, if the size is zero
	 * print an error that the file is not found*/
	ArrayList<String> getFiles(){
		if(listFile.size() == 0) {
			System.out.println("ItemNotFoundException: ");
			System.out.println("Error: File is not found");
			System.exit(0);
		}
		return this.listFile;
	}

	/**
	 * returns a String list of file that matched with the target file.
	 * Prints an error message if it meets an exception
	 * */
	@Override
	public String toString(){
		String output = "Found " + getCount() + " Files: ";
		/*catch any exception that occurs while looping through
		 * each matched file. Prints an error message and then
		 * exits the entire program*/
		try {
			/*Makes a String of each matched files*/
			for(int i = 0; i < this.getFiles().size();i++) {
				if(this.getFiles().get(i) != null) {
					output += "\n" + this.getFiles().get(i);
				}
			}
		}
		/*clarified above the try block. In short, catches any
		 * exception, prints error message, and exits program*/
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return output;
	}

}
