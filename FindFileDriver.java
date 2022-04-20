/**
 * Name: Nuranissa Sofia Abdul Wahid
 * CSS 143 A
 * Assignment: DirFileSearch, part one of Recursion. To track
 * and find file target in a directed directory and to practise
 * using recursion.
 * 
 * I used the 48 hour extension on this homework
 */
package Recursion;
/**
 * @author Nuranissa Sofia Abdul Wahid
 * A driver that passes though the FindFile class to search the target file
 * through a pathway with recursive. FindFind recurses in directoarySearch until
 * the file matches with the target file and returns the String of matched files
 * to this driver. This driver prints the returned String out and catches any
 * IllegalArgumentException that is thrown from the FindFile class.
 * 
 * Since I'm using a MacBook Pro, my pathToSearch is based on Apple's pathway, not Windows
 * 
 * I used the 48 hour extension on this homework
 */
public class FindFileDriver {

	/*to be used to pass in the FindFile class and limit the number of files to find*/
	private static final int MAX_NUMBER_OF_FILES_TO_FIND = 5;
	
	/**
	 * Initialises and passes the target file and path to search in the directorySearch
	 * from FindFile to store a list of files that matches with the target file. Passes
	 * the number of max files to be find in FindFile to set a limit of matched files to
	 * be found. Prints the list of files that matches with the target file. Catches any
	 * IllegalArgumentException thrown from the directorySearch in the FindFile class and
	 * prints the error message and list of matched files
	 * */
	public static void main(String[]args) {
		/*to be used as a target file that will be matched in the file search*/
		String targetFile = "longwords.txt";
		/*a pathway to search through the files with. I'm using a MacBook Pro, so this is the
		 * format to have access to my file. Change the path, so it matches with your computer
		 * (if you are not using Apple)*/
		String pathToSearch = "/Users/buttboo/Downloads";
		/*sets the max number of matched files to find in FindFile, so searched files should not
		 * reach this max number (or else an IllegalArgumentException will be thrown)*/
		FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
		/*catches any IllegalArgumentException that is thrown from FindFile and prints the error
		 * message and the matched files found before it reached the exception. Then exits the
		 * entire program*/
		try {
			/*passes the target file and pathway to the directorySearch to store a list of files
			 * that match with the target file found in the directory*/
			finder.directorySearch(targetFile, pathToSearch);
			/*prints a String list of matched files found in the directory*/
			System.out.println(finder.toString());
		}
		/*clarified above the try block. In short, catches any IllegalArgumentException thrown
		 * from FindFiles, prints an error message and matched files before it hit the exception
		 * and exits the program*/
		catch(IllegalArgumentException e) {
			System.out.println("\nIllegalArgumentException: ");
			System.out.println(e.getMessage());
			System.out.println(finder.toString());
			System.exit(0);
		}
	}

}
