package Unit11.One;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //writing file
        //FileWriter text = new FileWriter("Lotr.txt", true);
        //PrintWriter writer = new PrintWriter(text);
        try {
            //read File

            File file = new File("Lotr.txt");
            if (!file.exists()){
                System.out.println("No file");
                System.exit(0);
            }
            Scanner reader = new Scanner(file);

            //makes arraylist and variable to save data
            String data = "";
            ArrayList<String> list = new ArrayList<>();

            //loops array
            while (reader.hasNextLine())
            {
                System.out.println("dfgh");

                data = reader.nextLine();
                System.out.println(data);

            }

            reader.close();
            System.out.println("ad;gkjkljh");
            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}