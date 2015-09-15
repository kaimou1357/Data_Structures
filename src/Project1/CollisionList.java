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


    /**
     * Helper function in order to turn the CollisionList into a Zip List depending on what you would like to add first. Cyclist or Injuries.
     *
     * @return ArrayList with ZipCode objects.
     */
    private ArrayList<ZipCode> returnZipArray(String addFactor){

        boolean inList = false;
        ArrayList<ZipCode> zipList = new ArrayList<ZipCode>();
        for(int i = 0; i<list.size(); i++){
            //search through the zip list, if it already has the zip code, don't add it, increment the count.
            if(addFactor.equals("Collisions")){
                for(int j = 0; j<zipList.size(); j++){
                    if(zipList.get(j).getZip() == list.get(i).getZipCode()){
                        zipList.get(j).addCollision();
                        break;
                    }
                    else{
                        zipList.add(new ZipCode(list.get(i).getZipCode()));
                    }

                }

            }

            zipList.add(new ZipCode(list.get(i).getZipCode(), list.get(i).getInjuryAndFatalities(), list.get(i).getCyclistsInjured()));
        }

        return zipList;
    }



    /**
     * Gives the largest number of Collisions in a nice string format to output.
     * @return
     */
    public String zipLargestNumCollisions(){
        String result = "";
        ArrayList<ZipCode> zipList = returnZipArray("Collisions");
        //Sort the zip codes by largest to smallest, then traverse down the arrayList and add to codes and occurences.
        Comparator<ZipCode> largestZip = new Comparator<ZipCode>(){

            public int compare(ZipCode c1, ZipCode c2){
                if(c1.getNumCollisions()>c2.getNumCollisions()){
                    return -1;
                }
                else if(c1.getNumCollisions()<c2.getNumCollisions()){
                    return 1;
                }
                else{
                    return 0;
                }
            }

        };

        Collections.sort(zipList, largestZip);
        result+= "\t" + zipList.get(0).getZip() + "      " + zipList.get(0).getNumCollisions() + "   Collisions";
        result+= "\t" + zipList.get(1).getZip() + "      " + zipList.get(1).getNumCollisions() + "   Collisions";
        result+= "\t" + zipList.get(2).getZip() + "      " + zipList.get(2).getNumCollisions() + "   Collisions";


        return result;
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
        int totalAddedCounter = 0;
        ArrayList<ZipCode> zipList= returnZipArray("Collisions");


        String result = "";
        //add toString of index 0, 1, and 2
        //sort from largest to smallest.
        Collections.sort(list,Collections.reverseOrder());

        if(list.get(0).getInjuryAndFatalities() == 0){
            //there are no injuries/fatalities
            return "There are no injuries!";
        }

        result = "\t" + list.get(0).deathsToString();
        //1st one is the largest. Should be added.


        //start comparing at the third collision number.
        int minAccidents = list.get(0).getInjuryAndFatalities();
        for(int i = 1; i<list.size(); i++){

            if(list.get(i).getInjuryAndFatalities() == minAccidents){
                //make sure to indent the text.
                result += "\t" + list.get(i).deathsToString();
            }



            if(list.get(i).getInjuryAndFatalities()<minAccidents){
                if(totalAddedCounter == 2){
                    //only 2 because first one would be added by default.
                    break;
                }
                result += "\t" + list.get(i).deathsToString();
                minAccidents = list.get(i).getInjuryAndFatalities();
                totalAddedCounter++;
            }

        }

        return result;

    }

    /**This method returns a String with the rows of the zip codes with the highest number of cyclist injuries.
     * @return
     */
    public String zipLargestCyclistInjury(){
        int totalAddedCounter = 0;
        ArrayList<ZipCode> zipList = returnZipArray("Cyclists");

        String result = "";
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

        if(list.get(0).getCyclistsInjured() == 0){
            //there are no injuries/fatalities
            return "There are no cyclist injuries!";
        }

        result = "\t" + list.get(0).cyclistsToString();
        //start comparing at the third collision number.
        int minAccidents = list.get(0).getCyclistsInjured();
        for(int i = 1; i<list.size(); i++){
            //start from 1 since 0 is already taken care of...
            if(list.get(i).getCyclistsInjured() == minAccidents){
                //make sure to indent the text.
                result += "\t" + list.get(i).cyclistsToString();
            }

            if(list.get(i).getCyclistsInjured()<minAccidents){
                if(totalAddedCounter == 2){
                    //only 2 because first one would be added by default.
                    break;
                }
                result += "\t" + list.get(i).cyclistsToString();
                minAccidents = list.get(i).getCyclistsInjured();
                totalAddedCounter++;
            }

        }

        return result;
    }



    //Don't forget task 6, find something that interests you and report on it.


}
