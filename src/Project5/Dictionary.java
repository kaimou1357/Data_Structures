
package Project5;

import java.util.ArrayList;

/**
 * The class represent a dictionary of words. 
 * It provides a way of searching through the dictionary.
 * It also can produce a dictionary in which the words are limited
 * to a particular length. 
 * 
 * @author Joanna Klukowska
 *
 */
public class Dictionary extends BST<String> implements DictionaryInterface{
	//actual storage for the words
	private BSTNode<String> root;
	
	
	/**
	 * Creates an empty Dictionary object (no words).
	 */
	public Dictionary ( ) {

	}
	
	/**
	 * Creates a Dictionary object containing all words from the 
	 * listOfWords passed as a parameter.
	 * 
	 * @param listOfWords the list of words to be stored in the newly created 
	 * Dictionary object
	 */
	public Dictionary ( ArrayList < String > listOfWords ) {
		//TODO Implement this
	}
	

	/**
	 * Performs (binary) search in this Dictionary object for a given word.
	 * @param word  the word to look for in this Dictionary object. 
	 * @return true if the word is in this Dictionary object, false otherwise
	 */
	public boolean findWord ( String word ) {
		return true;
		//TODO Implement this
	}
	
	/*
	 * The actual method providing recursive implementation of the binary search.
	 * @param word the word to look for in this Dictionary object
	 * @param begin start of the range for the current iteration
	 * @param end   end of the range for the current iteration
	 * @return  true if the word is in this Dictionary object, false otherwise
	 */
	private boolean isWordInDictionaryRecursive ( String word ) {
		//TODO Implement this
		return true;

	}
	
	/**
	 * Performs (binary) search in this Dictionary object for a given prefix.
	 * @param prefix  the prefix to look for in this Dictionary object. 
	 * @return true if at least one word with the specified prefix exists 
	 * in this Dictionary object, false otherwise
	 */
	public boolean findPrefix (String prefix ) {

		return true;
		//TODO Implement this
	}

	/*
	 * The actual method providing recursive implementation of the binary search
	 * for the prefix. 
	 * @param prefix the prefix to look for in this Dictionary object.
	 * @param begin start of the range for the current iteration
	 * @param end end of the range for the current iteration
	 * @return true if at least one word with the specified prefix exists 
	 * in this Dictionary object, false otherwise
	 */
	private boolean isPrefixInDictionaryRecursive(String prefix, int begin, int end) {
		//TODO Implement this
			return true;
	}
	
	
	
}
