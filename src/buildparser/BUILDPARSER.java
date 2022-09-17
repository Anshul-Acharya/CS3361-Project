/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildparser;

/**
 *
 * @author anshu
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BUILDPARSER {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args)throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        //ENTER THE FILE LOCATION IN THE LINE BELOW
        BufferedReader infile = new BufferedReader(new FileReader("C:\\Users\\anshu\\Documents\\input.txt"));
        String infileData = "";
         Parser parse = new Parser();
        if(infile != null)
        {
            int j = 0;
            System.out.println("ANSHUL AND JORGE PRESENTS THE PARSER");
            System.out.println(".......The file exists in your desktop");
            System.out.println("..................The Parse tree is displayed below:\n\n");
            parse.programStart();
            while ((infileData = infile.readLine())!= null) //while the last character of line is not a null
               {
               
               String[] word = infileData.split(" ");       //when the line is empty case
                if(word[0].isEmpty()){
                    System.out.println("");
                }
                 else   
               parse.Parser(word);                      //object scanner called
               
               j++;
            }
            parse.programEnd();                 //calling program end
        }
    }
    }
    

