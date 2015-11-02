package Project4;

import Project2.Dictionary;
import Project2.LetterBag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kai on 11/1/2015.
 * @author Kai Mou
 *
 */
public class Calculator {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Missing name of the input file");
            System.exit(1);
        }
        if(args.length == 1){
            System.err.println("Missing name of the output file");
            System.exit(1);
        }
        if(args.length > 1){
            String fileName = args[0].substring(args[0].indexOf('/') + 1);
            File input = new File(args[0]);

            try{
                Scanner scan = new Scanner(input);
                while(scan.hasNextLine()){

                }

            }catch(FileNotFoundException e) {

                System.out.println(fileName + " does not exist!");
                System.exit(1);

            }

            File outFile = new File(args[1]);
            try{
                //Write the results to the file here.
                PrintWriter pw = new PrintWriter(outFile);

            }catch(FileNotFoundException j){
                System.err.println(args[1] + "could not be created");
                System.exit(1);
            }



        }
    }
}
