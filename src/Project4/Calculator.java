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
 * @Date 11/11/2015
 *
 */
public class Calculator {
    /**
     * Main Method
     * @param args input and output file from command line.
     * @throws PostFixException
     */
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
                File outFile = new File(args[1]);
                PrintWriter pw = new PrintWriter(outFile);
                while(scan.hasNextLine()){
                    try{
                        int result = ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(scan.nextLine()));
                        pw.println(result);
                    }catch(PostFixException e){
                        pw.println("INVALID");
                    }catch(ArithmeticException f){
                        pw.println("UNDEF");
                    }

                }
                //Close the printwriter to write to from buffer.
                pw.close();

            }catch(FileNotFoundException e) {

                System.out.println(fileName + " does not exist!");
                System.exit(1);

            }


        }
    }
}
