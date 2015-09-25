package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kai on 9/24/2015.
 * Class that runs main method of Project 2
 */
public class FindWords {
    public static void main(String[] args){
        //Get out of the static context quickly.
        FindWords f = new FindWords();
        f.runProgram(args);

    }

    /**
     * Parse command line argument, read the input file, read user input, Create Dictionary/LetterBag and display results.
     * @param args
     */
    public void runProgram(String[] args){

        if(args.length == 0){
            System.out.println("Missing name of the input file");
            System.exit(1);
        }
        if(args.length > 0){
            String fileName = args[0].substring(args[0].indexOf('/') + 1);
            Dictionary dict = new Dictionary();
            LetterBag bag = new LetterBag();
            File f = new File(args[0]);
            try{
                Scanner scan = new Scanner(f);
                String userInput = getUserInput();

                while(scan.hasNextLine()){
                    dict.addWord(scan.nextLine());

                }
            }catch(FileNotFoundException e) {

                System.out.println(fileName + " does not exist!");
                System.exit(1);

            }

        }


    }

    /**
     * Helper method to process String input given by the user.
     * @return
     */
    private String getUserInput(){
        Scanner userScan = new Scanner(System.in);
        System.out.println("Enter letters you would like to test");
        String input = userScan.nextLine().toLowerCase();
        if(isAlpha(input)){
            return input;
        }
        System.err.println("You entered an invalid character, only letters can be accepted");
        System.exit(1);
        return null;
    }

    /**
     * Helper function to check if userInput is all characters.
     * @param name of string
     * @return true if string is letters.
     */
    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

}
