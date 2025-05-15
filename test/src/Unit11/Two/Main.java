package Unit11.Two;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException {

        //writing file
        //makes File reference to the path
        File file = new File("C:\\Users\\boutinm\\Documents\\GitHub\\readingFromFiles\\test\\2_lotrMagicWord.txt");
        FileWriter text = new FileWriter(file);
        PrintWriter writer = new PrintWriter(text);

        try
        {
            if (!file.exists())
            {
                System.out.println("No file");
                System.exit(0);
            }

            makeArrayList();
            inputData(file);



        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public static ArrayList<String> makeArrayList() throws IOException
    {
        //makes arraylist
        ArrayList<String> list = new ArrayList<>();

        return list;
    }

    public static ArrayList<String> inputData(File file) throws IOException
    {
        //gets access to the list
        ArrayList<String> list = makeArrayList();

        //scanner to read the files
        Scanner reader = new Scanner(file);

        //variable to save data
        String data = "";

        //loops array saves data to arraylist
        while (reader.hasNextLine())
        {
            data = reader.nextLine();
            String [] output = data.split(":");
            System.out.println(output[0]);

            list.add(data);
        }

        return list;

    }
}