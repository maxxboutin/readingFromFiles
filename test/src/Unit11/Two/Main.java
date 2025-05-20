package Unit11.Two;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
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

            //prints random name from the list
            String randName = findRandName(listOfNames);
            System.out.println("\nRandom Name Selected: " + randName);

            //finds the password of the random name that is found
            String password = findPassword(randName, file);

            //scanner for intake of the user's password
            Scanner userPassword = new Scanner(System.in);

            //makes a String to take in the user's password
            String userInputPassword = "null";

            //if the password that the user enters isn't equal to the saved
            //one, it will continue asking until its correct
            while (userInputPassword != password)
            {
                System.out.print("Enter Your Password: ");

                userInputPassword = userPassword.nextLine();

                if (userInputPassword.equals(password))
                {
                    System.out.println("\nPassword Correct.");
                    break;
                }
                else
                {
                    System.out.println("Password Incorrect. Try again.\n");
                }
            }

            //prints out the password the correct password of the name selected
            System.out.println("Password Selected: " + password);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //this method will get the first name of all the people in the file
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
            System.out.println(fName);
            tempList.add(fName);
        }

        reader.close();
        return tempList;
    }

    //gets a random name from the file
    public static String findRandName(ArrayList <String> listOfNames)
    {

        int randomNameNum = (int) (Math.random() * 10);
        String randName = listOfNames.get(randomNameNum);
        return randName;

    }

    //finds the password of the random name that is selected
    public static String findPassword(String randName, File file) throws FileNotFoundException
    {
        //scanner to read the files
        Scanner reader = new Scanner(file);

        //variable to save the file input
        String fileInput;

        //loops array and saves the data to array
        while (reader.hasNextLine())
        {
            fileInput = reader.nextLine();
            String pass = fileInput.split(":")[1];
            if (fileInput.contains(randName))
            {
                return pass;
            }

        }
        return null;
    }
}