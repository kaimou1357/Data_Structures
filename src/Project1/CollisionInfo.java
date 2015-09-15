package Project1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * This entire class houses the Main method and some helper methods to provide the analysis.
 */

public class CollisionInfo {
    public static void main(String[] args){
        //create new instance of class to run with non-static methods.
      CollisionInfo a = new CollisionInfo();
        a.runProgram(args);
    }

    /**
     * This method has been taken from Joanna Klukowska's class example from review_fileIO.
     * @param textLine text read in from the CSV file.
     * @return
     */
    public static ArrayList<String> split (String textLine ) {
        ArrayList<String> entries = new ArrayList<String>();
        int lineLength = textLine.length();
        StringBuffer nextWord = new StringBuffer();
        char nextChar;
        boolean insideQuotes = false;

        for(int i = 0; i < lineLength; i++ ) {
            nextChar = textLine.charAt(i);
            //add character to the current entry
            if ( nextChar != ',' && nextChar != '"' ) {
                nextWord.append( nextChar );
            }
            //double quote found, decide if it is opening or closing one
            else if (nextChar == '"' ) {
                if ( insideQuotes ) {
                    insideQuotes = false;
                }
                else {
                    insideQuotes = true;
                }
            }
            //found comma inside double quotes, just add it to the string
            else if (nextChar == ',' && insideQuotes) {
                nextWord.append( nextChar );
            }
            //end of the current entry reached, add it to the list of entries
            //and reset the nextWord to empty string
            else if (nextChar == ',' && !insideQuotes) {
                //trim the white space before adding to the list
                entries.add( nextWord.toString().trim() );

                nextWord = new StringBuffer();
            }

            else {
                System.err.println("This should never be printed.\n");
            }
        }
        //add the last word
        //trim the white space before adding to the list
        entries.add( nextWord.toString().trim() );

        return entries;
    }

    /**
     * This is the main method of the program.
     * @param args Command line arguments passed from the main function.
     */
    public void runProgram(String[] args){
        if(args.length == 0){
            System.out.println("Missing name of the input file");

        }
        if(args.length > 0){
            CollisionList colList = new CollisionList();
            //ArrayList<ZipCode> zipList = new ArrayList<ZipCode>();

            File f = new File(args[0]);
            String editedFileName = args[0].substring(args[0].indexOf("/")+1, args[0].indexOf('.'));

            File newFile = new File(editedFileName+".out");



            try{

                Scanner scan = new Scanner(f);
                //create the new file to write to.

                if(scan.hasNext()){
                    //skip over the header row.
                    scan.nextLine();
                }


                while(scan.hasNextLine()){
                    String editText = scan.nextLine();
                    ArrayList<String> fields = new ArrayList<String>();


                    fields = split(editText);

                    if(fields.size()<21){
                        //this means there is incomplete information.
                        //go on to the next row.
                        continue;
                    }
                    //Turn the string values into Integers using the Integer class.
                    //Add to ZipList for the first couple of tasks first.
                    colList.addToList(new Collision(Integer.parseInt(fields.get(3)),Integer.parseInt(fields.get(12))+Integer.parseInt(fields.get(13)), Integer.parseInt(fields.get(8))+Integer.parseInt(fields.get(9)),fields.get(19)));
                    //zipList.add(new ZipCode(Integer.parseInt(fields.get(3)),Integer.parseInt(fields.get(12))+Integer.parseInt(fields.get(13)),Integer.parseInt(fields.get(8)) + Integer.parseInt(fields.get(9))));


                }



            }catch(FileNotFoundException e){
                System.out.println(args[0] + " does not exist!");

            }


            //try printing output to the file.
            //Will be printed in working directory of program.
            try{
                PrintWriter pw = new PrintWriter(newFile);
                /**
                 * Print zip code with the largest number of Collisions
                 *
                 */
                pw.println("Zip codes with the highest number of collisions");
                pw.println(colList.zipLargestNumCollisions());

                /**
                 * Print zip with the fewest number of collisions
                 *
                 */
                pw.println("Zip Codes with the fewest number of Collisions");
                pw.println(colList.zipSmallestNumCollisions());

                /**
                 * Print the highest # injuries and fatalities zip codes here.
                 */
                pw.println("Zip codes with the highest number of injuries and fatalities (Combined):");
                pw.println(colList.zipLargestNumDeath());
                /**
                 * Print the highest # of cyclist casualties here per zip code.
                 */

                pw.println("Zip codes with the most cyclist injuries and fatalities:");
                pw.println(colList.zipLargestCyclistInjury());



                pw.close();

                System.out.println("Printing Successful");

            }catch(FileNotFoundException e){
                System.out.println("Unable to create file " + editedFileName+".out");
            }

        }
    }

}
