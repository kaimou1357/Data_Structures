package Project2;

import java.util.ArrayList;

/**
 * Created by Kai on 9/24/2015.
 */
public class LetterBag implements LetterBagInterface {
    private String userInput;


    public ArrayList<String> getAllWords(Dictionary dict){
        return new ArrayList<String>();

    }
}

interface LetterBagInterface{
    /**
     * determines list of words that can be created from a given Letterbag object.
     * @param dict
     * @return list of valid words in alphabetical order.
     */
    ArrayList<String> getAllWords (Dictionary dict);
}

