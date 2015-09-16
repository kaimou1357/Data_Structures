package Project1;

import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
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
    private Comparator<ZipCode> largestZip = new Comparator<ZipCode>(){

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
    private Comparator<ZipCode> largestDeath = new Comparator<ZipCode>(){

        public int compare(ZipCode c1, ZipCode c2){
            if(c1.getInjuries()>c2.getInjuries()){
                return -1;
            }
            else if(c1.getInjuries()<c2.getInjuries()){
                return 1;
            }
            else{
                return 0;
            }
        }

    };
    private Comparator<ZipCode> cyclistInjury = new Comparator<ZipCode>(){
        public int compare(ZipCode c1, ZipCode c2){
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

    public CollisionList(){
        list = new ArrayList<Collision>();
    }

    public void addToList(Collision c){
        list.add(c);
    }

    /**This method computes the number of injuries and fatalalities and sorts them from ascending to descending and then return the string
     * representation of the three highest zip codes with the highest number of injuries and fatalities.
     * @return a String that denotes the zip codes with the highest number of injuries and fatalities.
     */
    public String zipNumDeath(){
        //Need to first sort from largest to smallest.
        int totalAddedCounter = 0;
        ArrayList<ZipCode> zipList= returnCollisionZipArray();
        String result = "";


        Collections.sort(zipList,largestDeath);

        //Check for other cases.
        result+="\t" + zipList.get(0).getZip() + "      " + zipList.get(0).getInjuries() + " Collisions"+ "\n";
        int minAccidents = zipList.get(0).getInjuries();
        int countedValues = 0;
        for(int i = 1; i<zipList.size(); i++){
            if(zipList.get(i).getInjuries() == minAccidents){
                result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getInjuries() + " Collisions"+ "\n";

            }

            if(zipList.get(i).getInjuries() <zipList.get(i-1).getInjuries()){
                countedValues++;
                minAccidents = zipList.get(i).getInjuries();
                if(countedValues == 3){
                    break;
                }
                else{
                    result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getInjuries() + " Collisions"+ "\n";
                }


            }
        }

        return result;

    }
    /**This method returns a String with the rows of the zip codes with the highest number of cyclist injuries.
     * @return
     */
    public String zipLargestCyclistInjury(){
        //Need to first sort from largest to smallest.
        int totalAddedCounter = 0;
        ArrayList<ZipCode> zipList= returnCollisionZipArray();
        String result = "";


        Collections.sort(zipList,cyclistInjury);

        //Check for other cases.
        result+="\t" + zipList.get(0).getZip() + "      " + zipList.get(0).getCyclistsInjured() + " Collisions"+ "\n";
        int minAccidents = zipList.get(0).getCyclistsInjured();
        int countedValues = 0;
        for(int i = 1; i<zipList.size(); i++){
            if(zipList.get(i).getCyclistsInjured() == minAccidents){
                result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getCyclistsInjured() + " Collisions"+ "\n";

            }

            if(zipList.get(i).getCyclistsInjured() <zipList.get(i-1).getCyclistsInjured()){
                countedValues++;
                minAccidents = zipList.get(i).getCyclistsInjured();
                if(countedValues == 3){
                    break;
                }
                else{
                    result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getCyclistsInjured() + " Collisions"+ "\n";
                }


            }
        }

        return result;

    }

    /**
     * This method returns in a string format the zip codes with the highest number of collisions.
     * @return
     */
    public String zipBiggestNumCollisions(){
        String result = "";
        ArrayList<ZipCode> zipList = returnCollisionZipArray();
        //Sort the zip codes by largest to smallest, then traverse down the arrayList and add to codes and occurences.

        Collections.sort(zipList, largestZip);
        //Check for other cases.
        result+="\t" + zipList.get(0).getZip() + "      " + zipList.get(0).getNumCollisions() + " Collisions"+ "\n";
        int minAccidents = zipList.get(0).getNumCollisions();
        int countedValues = 0;
        for(int i = 1; i<zipList.size(); i++){
            if(zipList.get(i).getNumCollisions() == minAccidents){
                result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getNumCollisions() + " Collisions"+ "\n";

            }

            if(zipList.get(i).getNumCollisions() <zipList.get(i-1).getNumCollisions()){
                countedValues++;
                minAccidents = zipList.get(i).getNumCollisions();
                if(countedValues == 3){
                    break;
                }
                else{
                    result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getNumCollisions() + " Collisions"+ "\n";
                }


            }
        }


        return result;
    }

    /**
     * This method returns the a string format with the zip codes with the fewest number of collisions.
     * @return
     */
    public String zipFewestCollisions(){
        String result = "";
        ArrayList<ZipCode> zipList = returnCollisionZipArray();
        //Sort the zip codes by largest to smallest, then traverse down the arrayList and add to codes and occurences.

        Collections.sort(zipList, largestZip.reversed());
        //Check for other cases.
        result+="\t" + zipList.get(0).getZip() + "      " + zipList.get(0).getNumCollisions() + " Collisions"+ "\n";
        int minAccidents = zipList.get(0).getNumCollisions();
        int countedValues = 0;
        for(int i = 1; i<zipList.size(); i++){
            if(zipList.get(i).getNumCollisions() == 0 ){
                continue;
            }
            if(zipList.get(i).getNumCollisions() == minAccidents){
                result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getNumCollisions() + " Collisions"+ "\n";

            }

            if(zipList.get(i).getNumCollisions() >zipList.get(i-1).getNumCollisions()){
                countedValues++;
                minAccidents = zipList.get(i).getNumCollisions();
                if(countedValues == 3){
                    break;
                }
                else{
                    result+="\t" + zipList.get(i).getZip() + "      " + zipList.get(i).getNumCollisions() + " Collisions"+ "\n";
                }


            }
        }
        return result;

    }

    /**
     * A method that returns a string format of the percentage of vehicles that caused accidents.
     * @return
     */
    public String percentageOfCollisions(){
        int[] vehicleTypes = new int[5];
        String result = "";
        int totalCollisions = list.size();
        /**
         * 0 is taxi
         * 1 is bus
         * 2 is bicycle
         * 3 is firetruck
         * 4 is ambulance
         *
         */

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getVehicleType().contains("TAXI")){
                vehicleTypes[0]++;
            }
            else if(list.get(i).getVehicleType().contains("BUS")){
                vehicleTypes[1]++;
            }
            else if(list.get(i).getVehicleType().contains("BICYCLE")){
                vehicleTypes[2]++;
            }
            else if(list.get(i).getVehicleType().contains("FIRETRUCK")){
                vehicleTypes[3]++;
            }
            else if(list.get(i).getVehicleType().contains("AMBULANCE")){
                vehicleTypes[4]++;
            }
        }

        DecimalFormat formatter = new DecimalFormat("#0.00%");
        result += "\t" + "Taxi      " + formatter.format((vehicleTypes[0]/(totalCollisions)* 100.0))+ "\n";
        result += "\t" + "Bus      " + formatter.format((vehicleTypes[1]/(totalCollisions)* 100.0))+ "\n";
        result += "\t" + "Bicycle      " + formatter.format(vehicleTypes[2]/(totalCollisions* 100.0))+ "\n";
        result += "\t" + "Fire Truck      " + formatter.format(vehicleTypes[3]/(totalCollisions* 100.0))+ "\n";
        result += "\t" + "Ambulance      " + formatter.format(vehicleTypes[4]/(totalCollisions* 100.0))+ "\n";


        return result;
    }


    /**
     * This is a helper method that turns the list from the Collisions arraylist into the Zipcode array list.
     * @return
     */
    private ArrayList<ZipCode> returnCollisionZipArray(){
        ArrayList<ZipCode> zipList = new ArrayList<ZipCode>();

        //zipList.add(new ZipCode(list.get(0).getZipCode()));
        for(int i = 0; i<list.size(); i++){
            boolean inList = false;
            for(int j = 0; j<zipList.size(); ++j){
                if(zipList.get(j).getZip() == list.get(i).getZipCode()){
                    zipList.get(j).addCollision();
                    zipList.get(j).addInjuries(list.get(i).getInjuryAndFatalities());
                    zipList.get(j).addCyclistInjury(list.get(i).getCyclistsInjured());
                    inList = true;
                }
            }
            if(!inList){
                zipList.add(new ZipCode(list.get(i).getZipCode(), list.get(i).getInjuryAndFatalities(), list.get(i).getCyclistsInjured()));
                inList = true;
            }

        }

        return zipList;
    }



    //Don't forget task 6, find something that interests you and report on it.


}
