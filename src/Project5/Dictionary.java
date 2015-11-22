
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
public class Dictionary implements DictionaryInterface{
	//actual storage for the words
	private ArrayList < String > words;
	
	
	/**
	 * Creates an empty Dictionary object (no words).
	 */
	public Dictionary ( ) {
		words = new ArrayList < String > () ;
	}
	
	/**
	 * Creates a Dictionary object containing all words from the 
	 * listOfWords passed as a parameter.
	 * 
	 * @param listOfWords the list of words to be stored in the newly created 
	 * Dictionary object
	 */
	public Dictionary ( ArrayList < String > listOfWords ) {
		words = listOfWords;
		if (null == words) {
			words = new ArrayList <String> ();
		}
	}
	
	/**
	 * Creates a new Dictionary object from this Dictionary object that 
	 * contains words of a specified size.
	 * @param size length of the words that should be included in the new 
	 * Dictionary object
	 * @return a new Dictionary object containing only the words of specified 
	 * size
	 */
	public Dictionary getWordsBySize ( int size ) {
		ArrayList <String> wordsBySize = new ArrayList<String> ();
		for (int i = 0; i < words.size(); i++)
			if (words.get(i).length() == size)
				wordsBySize.add(words.get(i));
		return new Dictionary (wordsBySize);
	}
	
	 
	/**
	 * Performs (binary) search in this Dictionary object for a given word.
	 * @param word  the word to look for in this Dictionary object. 
	 * @return true if the word is in this Dictionary object, false otherwise
	 */
	public boolean findWord ( String word ) {
		return isWordInDictionaryRecursive( word, 0, words.size() - 1 );
	}
	
	/*
	 * The actual method providing recursive implementation of the binary search.
	 * @param word the word to look for in this Dictionary object
	 * @param begin start of the range for the current iteration
	 * @param end   end of the range for the current iteration
	 * @return  true if the word is in this Dictionary object, false otherwise
	 */
	private boolean isWordInDictionaryRecursive ( String word, int begin, int end ) {
		//TODO Implement this as a recursive function that searches the binary tree.
		return true;
	}
	
	/**
	 * Performs (binary) search in this Dictionary object for a given prefix.
	 * @param prefix  the prefix to look for in this Dictionary object. 
	 * @return true if at least one word with the specified prefix exists 
	 * in this Dictionary object, false otherwise
	 */
	public boolean findPrefix (String prefix ) {
		return isPrefixInDictionaryRecursive (prefix, 0, words.size() - 1 );
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
		//TODO Implement a search through a binary search tree in this function.
		return true;
	}
	
	
	
}
