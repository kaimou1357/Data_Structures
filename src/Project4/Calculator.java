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
    public static void main(String[] args) throws PostFixException{

        System.out.println(ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix("( 5 + 2 ) * ( 3 * 5 )")));


//        if(args.length == 0){
//            System.out.println("Missing name of the input file");
//            System.exit(1);
//        }
//        if(args.length == 1){
//            System.err.println("Missing name of the output file");
//            System.exit(1);
//        }
//        if(args.length > 1){
//            String fileName = args[0].substring(args[0].indexOf('/') + 1);
//            File input = new File(args[0]);
//
//            try{
//                Scanner scan = new Scanner(input);
//                File outFile = new File(args[1]);
//                PrintWriter pw = new PrintWriter(outFile);
//                while(scan.hasNextLine()){
//                    try{
//                        ExpressionTools.postFixEvaluate(scan.nextLine());
//                        pw.println("hello");
//                    }catch(PostFixException e){
//                        e.getMessage();
//                    }catch(ArithmeticException e){
//                        if(e.getMessage().equals("Divide by Zero error")){
//                            pw.println("UNDEF");
//                        }
//                    }
//
//                }
//
//            }catch(FileNotFoundException e) {
//
//                System.out.println(fileName + " does not exist!");
//                System.exit(1);
//
//            }
//
//        }
    }
}
