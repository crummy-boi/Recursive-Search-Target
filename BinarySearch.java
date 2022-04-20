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
 * the behaviour of a binary search by using both iterative and recursion. It
 * retains the methods of its superclass SearchAlgorithm. It finds the target
 * word from the passed String Array of words by comparing the target word to
 * the middle element of the passed array of words
 * 
 * I used the 48 hour extension on this homework
 */
public class BinarySearch extends SearchAlgorithm {
	/**
	 * Overrides the search method in SearchAlgorithm. It finds the target
	 * word from the passed String Array of words by comparing the target word to
	 * the middle element of the passed array of words until it finds the target word.
	 * Increments count for every occurrence of a loop/comparison. Returns the target word
	 * from the passed array. If the target word is not found in the array, throw an
	 * ItemNotFoundException
	 * */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException{
		/*to be changed later as the word array changes*/
		int lowIndex = 0;
		/*to be changed later as the word array changes*/
		int highIndex = words.length - 1;
		/*to be returned as the target word later*/
		int midIndex = 0;
		/*while there is still String, compare the target word to the middle element
		 * until it matches with the middle element*/
		while(lowIndex <= highIndex) {
			/*set middle index as half of lowIndex and highIndex and to be used to compare
			 * with target word*/
			midIndex = (lowIndex + highIndex) / 2;
			/*Increments each time it compares (for each loop)*/
			this.incrementCount();
			/*returns midIndex if it matches with the target word; if the target word
			 * is found in the passed array*/
			if(wordToFind.equals(words[midIndex])) {
				return midIndex;
			}	
			/*if the target word is before the middle index, set high index to mid index - 1*/
			if(wordToFind.compareTo(words[midIndex]) < 0) {
				highIndex = midIndex - 1;
			}
			/*if the target word is after the middle index, set low index to mid index + 1*/
			if(wordToFind.compareTo(words[midIndex]) > 0 ) {
				lowIndex = midIndex + 1;
			}
		}
		/*if target word is not found or there is no String left, throw an ItemNotFoundException*/
		throw new ItemNotFoundException();
	
	}
	/**
	 * Overrides the recSearch method in SearchAlgorithm. Its parameters are passed to the
	 * its overloaded recSearch counterpart. This is to properly perform a recursion method
	 * of a binary search
	 * */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
		return recSearch(words, wordToFind, 0, words.length-1);
	
	}
	
	/**
	 * Overloads the recSearch method(String[], String). It finds the target
	 * word from the passed String Array of words by comparing the target word to
	 * the middle element of the passed array of words until it finds the target word.
	 * It recurses itself until the middle index matches the target word. Increments
	 * count for every occurrence of a recursion/comparison. Returns the target word
	 * from the passed array. If the target word is not found in the array, throw an
	 * ItemNotFoundException
	 * */
	public int recSearch(String[] words, String wordToFind, int lowIndex, int highIndex) throws ItemNotFoundException{
		int midIndex = (lowIndex + highIndex)/2;
		/*if there is still String, compare the target word to the middle element*/
		if(lowIndex <= highIndex){
			/*returns midIndex if it matches with the target word; if the target word
			 * is found in the passed array*/
			if(wordToFind.equals(words[midIndex])) {
				return midIndex;
			}
			/*if the target word is before the middle index, set high index to mid index - 1*/
			if(wordToFind.compareTo(words[midIndex]) < 0) {
				highIndex = midIndex - 1;
			}
			/*if the target word is after the middle index, set low index to mid index + 1*/
			if(wordToFind.compareTo(words[midIndex]) > 0) {
				lowIndex = midIndex + 1;
			}
			/*increments each time it compares (for each recursion)*/
			this.incrementCount();
			/*if the middle element does not match with the target word and there is still
			 * String left, recurses with the recSearch method with its new low index and
			 * high index*/
			return recSearch(words, wordToFind, lowIndex, highIndex);
		}else {
			/*if target word is not found or there is no String left, throw an ItemNotFoundException*/
			throw new ItemNotFoundException();
		}
		
	}

}
