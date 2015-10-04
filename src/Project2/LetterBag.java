package Project2;

import java.util.ArrayList;

/**
 * Created by Kai on 9/24/2015.
 */
public class LetterBag implements LetterBagInterface {
    private String userInput;
    private ArrayList<String> finishedList;
    private ArrayList<String> permList = new ArrayList<String>();

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
        ArrayList<String> finishedList = generateWords(dict, "", userInput);
        //make sure to remove duplicates before returning the finished list.
        removeDuplicates(finishedList);
        return finishedList;
    }

    /**
     *
     * @param dict Dictionary object
     * @param prefix Empty prefix string
     * @param seq string to permute
     * @return arraylist with all permutations of string
     */
    private ArrayList<String> generateWords(Dictionary dict,String prefix, String seq){


        if(seq.length() == 0){
            if(dict.findWord(prefix)){
                permList.add(prefix);
            }

        }
        else{
            for(int i = 0;i<seq.length(); i++){
                if(!dict.findPrefix(prefix)){break;}
                //if prefix is not even in dictionary, don't bother generating.

                //generate permutations when the character is in a different position with each iteration of the loop.
                generateWords(dict, prefix + seq.charAt(i) ,seq.substring(0,i) + seq.substring(i+1, seq.length()));
            }
        }

        return permList;
    }

    /**
     * Remove duplicates from the generated permutations.
     */
    private void removeDuplicates(ArrayList<String> list){
        for(int i = 0; i<list.size(); i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }

        }

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

