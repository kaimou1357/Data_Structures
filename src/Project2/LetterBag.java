package Project2;

import java.util.ArrayList;

/**
 * Created by Kai on 9/24/2015.
 */
public class LetterBag implements LetterBagInterface {
    private String userInput;
    private ArrayList<String> finishedList;

    public LetterBag(String userEntry){
        this.userInput = userEntry;
    }

    /**
     * Returns an arrayList of anagrams.
     * @param dict Dictionary object read in from the file.
     * @return returns ArrayLIst of Anagrams.
     */
    public ArrayList<String> getAllWords(Dictionary dict){
        ArrayList<String> emptyList = new ArrayList<String>();
        //Pass in empty list to store the words from each recursion.
        ArrayList<String> finishedList = generateWords(dict, emptyList, "", userInput);

        return finishedList;

    }

    /**
     * Helper method for recursion call.
     * @param dict A dictionary object
     * @param list list to store the recursive calls.
     * @param prefix prefix of the word
     * @param seq the word the user entered.
     * @return an ArrayList that has all the anagrams of the user entered word.
     */
    private ArrayList<String> generateWords(Dictionary dict,ArrayList<String> list, String prefix, String seq){
        ArrayList<String> resultList = list;
        if(seq.length() == 0){
            if(dict.findWord(prefix))
                resultList.add(prefix);
        }


        else{
            for(int i = 0;i<seq.length(); i++){
                if(!dict.findPrefix(prefix)){
                    continue;
                }
                generateWords(dict, resultList, prefix + seq.charAt(i) ,seq.substring(0,i) + seq.substring(i+1, seq.length()));

            }
        }

        return resultList;
    }

    /**
     * Method to sort the arraylist before returning it to the user.
     * @param list
     */
    private void sortTheList(ArrayList<String> list){

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

