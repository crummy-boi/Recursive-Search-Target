/**
 * Name: Nuranissa Sofia Abdul Wahid
 * CSS 143 A
 * Assignment: RecursiveBinarySearch, part two of Recursion. To track,
 * compare, and find word target in the file "longwords.txt" and to
 * practise using recursion.
 * 
 * I used the 48 hour extension on this homework
 */
package Recursion;
/**
 * @author Nuranissa Sofia Abdul Wahid
 * A class that searches the target word from the file "longwords.txt" through
 * the behaviour of a linear search by using both iterative and recursion. It
 * retains the methods of its superclass SearchAlgorithm. It finds the target
 * word from the passed String Array of words by sequentially checking each
 * element of the passed array words until it finds the target word in a usual
 * behaviour of a linear search. Using recursion for this is an experiment
 * 
 * I used the 48 hour extension on this homework
 */
public class LinearSearch extends SearchAlgorithm{
	/**
	 * Overrides the search method in SearchAlgorithm. It finds the target
	 * word from the passed String Array of words by sequentially checking each
	 * element of the passed array words until it finds the target word. Increments
	 * count for every occurrence of a loop/comparison. Returns the target word from the
	 * passed array. If the target word is not found in the array, throw an ItemNotFoundException
	 * */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException{
		/*Checks through every element in the passed array to find if the element matches
		 * the target word*/
		for(int i = 0; i < words.length - 1; i++) {
			/*Increments each time it compares (for each loop)*/
			this.incrementCount();
			/*returns the element if it matches the target word*/
			if(words[i].equals(wordToFind)) {
				return i;
			}
		}
		/*if target word is not found, throw an ItemNotFoundException*/
		throw new ItemNotFoundException();
	}
	
	/**
	 * Overrides the recSearch method in SearchAlgorithm. Its parameters are passed to the
	 * its overloaded recSearch counterpart. This is to properly perform a recursion method
	 * of a linear search
	 * */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{	
		return recSearch(words, wordToFind, 0, words.length - 1);
	
	}
	
	/**
	 * Overloads the recSearch method(String[], String). To attempt a recursion of a linear
	 * search; However, a StackOverflow occurs here. Throws ItemNotFoundException if there is
	 * no String to be found.
	 * */
	public int recSearch(String[] words, String wordToFind, int lowIndex, int highIndex) throws ItemNotFoundException{
		/*if no String is found, throw an ItemNotFoundException*/
		if(lowIndex > highIndex) {
			throw new ItemNotFoundException();
		}
		/*if the target word matches the end of the word array, return the last index*/
		if(wordToFind.equals(words[highIndex])) {
			return highIndex;
		}else {
			/*Increments each time it compares (for each recursion)*/
			this.incrementCount();
			/*a StackOverflow Error occurs with this return. An infinite recursion
			 * error is executed, with LinearSearch.java:[line number of this return]*/
			return recSearch(words, wordToFind, lowIndex, highIndex - 1);
		}
	}
	
	
}
