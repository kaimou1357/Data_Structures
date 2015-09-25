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
        return findBinaryWord(listOfWords, word,0, listOfWords.size());

    }
    private boolean findBinaryWord(ArrayList<String> list, String word, int low, int high){
        if(low>high){
            return false;
        }
        int mid = (low+high)/2;

        if(list.get(mid).equals(word)){
            //If the word is equal, then that's the base case.
            return true;
        }

        else if (list.get(mid).compareTo(word) == -1){
            return findBinaryWord(list, word, mid+1, high);
        }
        else
            return findBinaryWord(list, word, low, mid-1);
    }


    @Override
    public boolean findPrefix(String Prefix){
        return true;
    }

    /**
     * Adds word to Dictionary
     * @param s
     */
    public void addWord(String s){
        listOfWords.add(s);
    }
}

/**
 * Interface I have to implement for this project that helps sort through queries using recursive binary search.
 */
interface DictionaryInterface{
    boolean findWord(String word);

    boolean findPrefix(String Prefix);
}


