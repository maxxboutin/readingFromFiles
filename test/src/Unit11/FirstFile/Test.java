package Unit11.FirstFile;

import java.util.*;
import java.io.*;

public class Test
{

    public static void main(String[] args) throws FileNotFoundException
    {
        PrintWriter outputFile = new PrintWriter("StudentData.txt");

        Scanner input = new Scanner(System.in);
        System.out.println("enter the filename: ");
        String filename = input.nextLine();
        outputFile.close();

        PrintWriter outputfile = new PrintWriter(filename + ".txt");
        outputfile.println("Writing stuff again");
        outputfile.close();

        try
        {
            //FileWriter fw = new FileWriter("StudentData.txt", true);
            //PrintWriter output = new PrintWriter(fw);
            File file = new File("StudentData.txt");
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNext()) {
                String s = fileInput.nextLine();
                System.out.println(s);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error couldn't write to file");
        }

    }

}