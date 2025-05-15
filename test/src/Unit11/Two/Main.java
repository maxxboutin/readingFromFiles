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

            ArrayList<String> list = new ArrayList<>();
            list = inputData(file,list);

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public static ArrayList <String> getList(ArrayList<String> list)
    {
        return list;
    }

    public static ArrayList<String> inputData(File file, ArrayList<String> list) throws IOException
    {
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