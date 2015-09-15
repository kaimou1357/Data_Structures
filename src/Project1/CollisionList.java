package Project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * This class represents a list of Collisions to process for later.
 * @author Kai
 *
 */
public class CollisionList {
    private ArrayList<Collision> list;

    public CollisionList(){
        list = new ArrayList<Collision>();
    }

    public void addToList(Collision c){
        list.add(c);
    }




    public String zipLargestNumCollisions(){
        return "hello";
    }

    public String zipSmallestNumCollisions(){
        return "hi";
    }







    /**This method computes the number of injuries and fatalalities and sorts them from ascending to descending and then return the string
     * representation of the three highest zip codes with the highest number of injuries and fatalities.
     * @return a String that denotes the zip codes with the highest number of injuries and fatalities.
     */
    public String zipLargestNumDeath(){
        //Need to first sort from largest to smallest.


        String result = "";
        //add toString of index 0, 1, and 2
        //sort from largest to smallest.
        Collections.sort(list,Collections.reverseOrder());

        result = "\t" + list.get(0).deathsToString()+ "\t" + list.get(1).deathsToString() + "\t" + list.get(2).deathsToString();



        //start comparing at the third collision number.
        int minAccidents = list.get(2).getInjuryAndFatalities();
        for(int i = 3; i<list.size(); i++){
            //start from 1 since 0 is already taken care of...
            if(list.get(i).getInjuryAndFatalities() == minAccidents){
                //make sure to indent the text.
                result += "\t" + list.get(i).deathsToString();
                minAccidents = list.get(i).getInjuryAndFatalities();

            }

        }

        return result;

    }

    /**This method returns a String with the rows of the zip codes with the highest number of cyclist injuries.
     * @return
     */
    public String zipLargestCyclistInjury(){

        String result = "";
        //add toString of index 0, 1, and 2
        //sort from largest to smallest.
        //write a Comparator object to help compare cyclistinjuries.

        Comparator<Collision> cyclistInjury = new Comparator<Collision>(){
            public int compare(Collision c1, Collision c2){
                //This will allow the program to sort in descending order.
                if(c1.getCyclistsInjured()>c2.getCyclistsInjured()){
                    //if c1 is smaller than c2, return -1. This will ensure Collections.sort will sort in descending order.
                    return -1;
                }
                else if(c1.getCyclistsInjured()<c2.getCyclistsInjured()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        };
        Collections.sort(list,cyclistInjury);

        result = "\t" + list.get(0).cyclistsToString()+ "\t" + list.get(1).cyclistsToString() + "\t" + list.get(2).cyclistsToString();
        //start comparing at the third collision number.
        int minAccidents = list.get(2).getCyclistsInjured();
        for(int i = 3; i<list.size(); i++){
            //start from 1 since 0 is already taken care of...
            if(list.get(i).getCyclistsInjured() == minAccidents){
                //make sure to indent the text.
                result += "\t" + list.get(i).cyclistsToString();
                minAccidents = list.get(i).getCyclistsInjured();

            }

        }

        return result;
    }



    //Don't forget task 6, find something that interests you and report on it.


}
