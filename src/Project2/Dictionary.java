package Project2;

import java.util.ArrayList;

/**
 * Created by Kai on 9/24/2015.
 */
public class Dictionary implements DictionaryInterface {
    private ArrayList<String> listOfWords;
    public Dictionary(){
        listOfWords = new ArrayList<String>();
    }

    @Override
    /**
     * Recursive binary search algorithm.
     */
    public boolean findWord(String word){
        return findBinaryWord(listOfWords, word,0, listOfWords.size()-1);

    }

    /**
     * Helper recursive function
     * @param list List of words
     * @param word Word to be searched
     * @param low Lowest index
     * @param high Highest index
     * @return return whether the word is in the list of not.
     */
    private boolean findBinaryWord(ArrayList<String> list, String word, int low, int high){
        if(low>high){
            return false;
        }
        int mid = (low+high)/2;
        if(list.get(mid).equals(word)){
            //If the word is equal, then that's the base case.
            return true;
        }

        else if (list.get(mid).compareTo(word)<0){
            return findBinaryWord(list, word, mid+1, high);
        }
        else
            return findBinaryWord(list, word, low, mid-1);
    }


    @Override
    /**
     * Finds prefix of a word.
     */
    public boolean findPrefix(String Prefix){
        return findBinaryPrefix(listOfWords, Prefix,0, listOfWords.size()-1, 0);
    }

    /**
     * Helper function for findPrefix.
     * @param list arraylist
     * @param prefix prefix you want to find
     * @param low lowest index
     * @param high highest index of the array.
     * @return returns true if prefix is in the dictionary, else false.
     */
    private boolean findBinaryPrefix(ArrayList<String> list, String prefix, int low, int high, int prefixLength){
        int charCounter = prefixLength;
        if(prefix.length() ==1) {
            //We don't want an array out of bounds.
            charCounter=1;
        }
        else if(prefix.length() == 2){
            charCounter =2;
        }
        if(low>high){
            return false;
        }
        int mid = (low+high)/2;
        if(list.get(mid).substring(0, charCounter).equals(prefix.substring(0, charCounter))){
            //If the word is equal, then that's the base case.
            return true;
        }

        else if (list.get(mid).substring(0, charCounter).compareTo(prefix.substring(0, charCounter)) < 0){
            return findBinaryPrefix(list, prefix, mid+1, high, charCounter);
        }
        else
            return findBinaryPrefix(list, prefix, low, mid-1, charCounter);
    }

    /**
     * Adds word to Dictionary
     * @param s
     */
    public void addWord(String s){
        listOfWords.add(s);
    }

    public boolean isEmpty(){
        return listOfWords.size() == 0;
    }

}




/**
 * Interface I have to implement for this project that helps sort through queries using recursive binary search.
 */
interface DictionaryInterface{
    boolean findWord(String word);

    boolean findPrefix(String Prefix);
}


