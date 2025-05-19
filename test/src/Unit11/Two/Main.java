package Unit11.Two;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Main
{

    public static void main(String[] args) throws IOException {

        //makes File reference to the path
        File file = new File("C:\\Users\\boutinm\\Documents\\GitHub\\readingFromFiles\\test\\src\\2_lotrMagicWord.txt");
        if (!file.exists())
        {
            System.out.println("No file");
            System.exit(0);
        }

        try
        {
            //makes arraylist and prints out all the names in the list
            ArrayList <String> listOfNames = firstNameGetter(file);
            ArrayList <String> listOfPasswords = (listOfNames, )


            for (String s : listOfNames)
            {
                System.out.println(s);
            }

            //prints random name from the list
            String passwordName = findRandName(listOfNames);
            System.out.println("\nRandom Name Selected: " + passwordName);





            /*
            System.out.println(passwordName);

            //gets the name of the random person
            System.out.println(passwordName);

            String password = findPassword(listOfNames, passwordName);
            System.out.println("Password: " + password);
             */

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public static ArrayList<String> firstNameGetter(File file) throws IOException
    {
        //scanner to read the files
        Scanner reader = new Scanner(file);

        //variable to save data
        String data;

        //makes a String array
        ArrayList <String> tempList = new ArrayList<>();

        //loops array and saves the data to array
        while (reader.hasNextLine())
        {
            data = reader.nextLine();
            String fName = data.split(":")[0];
            tempList.add(fName);
        }

        reader.close();
        return tempList;
    }

    public static String findRandName(ArrayList <String> listOfNames)
    {

        int randomNameNum = (int) (Math.random() * 10);
        String randName = listOfNames.get(randomNameNum);
        return randName;

        //randName = randName.substring(0, (randName.length() + 1 ) / 2);

    }

    //public static String getRandName(randomName){return "null"}

    public static String findPassword(ArrayList <String> listOfNames, String passwordName)
    {

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < listOfNames.size() - 1; i++)
        {
            String userInfo = reader.nextLine();

            if (userInfo.split(":")[0].equals(passwordName))
            {
                return userInfo.split(":")[1];
            }
        }
        reader.close();
        return null;
    }
}