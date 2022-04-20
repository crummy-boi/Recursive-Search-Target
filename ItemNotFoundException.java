/**
 * Name: Nuranissa Sofia Abdul Wahid
 * CSS 143 A
 * Assignment: RecursiveBinarySearch, part two of Recursion. To track,
 * compare, and find word target in the file "longwords.txt" and to
 * practise using recursive.
 * 
 * I used the 48 hour extension on this homework
 */
package Recursion;
/**
 * @author Nuranissa Sofia Abdul Wahid
 * a class that extends to Exception and performs as an ItemNotFoundException.
 * If called on, it calls on the super constructor Exception and passes that
 * an item was not found or a passed message
 * 
 * I used the 48 hour extension on this homework
 * */
public class ItemNotFoundException extends Exception{

	/**
	 * calls on the super constructor Exception and passes the item was not found
	 * */
	public ItemNotFoundException() {
		super("Item was not found");
	}
	
	/**
	 * calls on the super constructor Exception and passes the String message passed
	 * from an outside class
	 * */
	public ItemNotFoundException(String message) {
		super(message);
	}
	
}
