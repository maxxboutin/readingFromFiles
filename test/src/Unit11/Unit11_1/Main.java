package Unit11.Unit11_1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        //writing file
        //makes File reference to the path
        File file = new File("2_lotrMagicWord.txt");
        FileWriter text = new FileWriter(file, true);
        PrintWriter writer = new PrintWriter(text);

        try {
            //checks for a file existing
            if (!file.exists())
            {
                System.out.println("No file");
                System.exit(0);
            }

            //scanner to read the files
            Scanner reader = new Scanner(file);


            //makes arraylist and variable to save data
            String data = "";
            ArrayList<String> list = new ArrayList<>();

            //loops array saves data to arraylist
            while (reader.hasNextLine())
            {
                data = reader.nextLine();
                list.add(data);
            }

            //puts array in alphabetical order
            list.sort(null);

            //prints new alphabetical order list
            for (String word : list)
            {
                System.out.println(word);
            }

            //makes scanner to take input
            Scanner userInput = new Scanner(System.in);

            //infinite for loop until broke
            while (true)
            {
                //asks user if they want to add more names
                System.out.println("Enter a name: (Enter/Exit when completed)");

                //inputs users input into variable
                String addedName = userInput.nextLine();

                //if exit is entered the loop with break
                if (addedName.equalsIgnoreCase("Exit"))
                    break;

                //adds names to list
                list.add(addedName);
            }


            //for loop to print out the new list and write new names in file
            for (int i = 0; i < list.size(); i++)
            {
                String name = list.get(i);
                writer.println(name);
                System.out.println(name);
            }


            //closes the file
            reader.close();
            writer.close();

        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}