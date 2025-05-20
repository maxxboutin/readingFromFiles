package Unit11.Three;

import java.io.*;
import java.util.Scanner;


public class Utils
{
    private static final String FILE_NAME = "user.txt";
    private static final String DELIMITER = ",";

    public static void createUser(User user)
    {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true)))
        {
            writer.println(user.getUserInfo());
        }

        catch(IOException e)
        {
            System.out.println("error adding to file" + e.getMessage());
        }
    }


    public static User fetchUser(String name, String password)
    {
        try (Scanner fileInput = new Scanner(new FileReader(FILE_NAME)))
        {
            while (fileInput.hasNext())
            {
                String line = fileInput.nextLine();
                String[] splitLine = line.split(DELIMITER);

                if (splitLine.length != 2)
                {
                    //System.out.println("Bad data on line: " + lineCount);
                    continue;
                }

                String splitName = splitLine[0];
                String splitPass = splitLine[1];

                if (splitName.equalsIgnoreCase(name) && splitPass.equals(password))
                {
                    return new User(splitName, splitPass);

                }
            }
        }
        catch (IOException e)
        {
            System.out.println("error writing file" + e.getMessage());
        }

        return null;
    }

    public static void updateUser(User updatedUser)
    {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("tempUser.txt");

        try( Scanner fileInput = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))
            )
        {
            while (fileInput.hasNext())
            {
                String currentLine = fileInput.nextLine();
                String[] splitLine = currentLine.split(DELIMITER);

                if (splitLine.length != 2)
                {
                    System.out.println();

                    String splitName = splitLine[0];

                    if (splitName.equalsIgnoreCase(updatedUser.getName()));
                    {
                        writer.println(updatedUser.getUserInfo());
                    }
                    //else
                    {
                        //writer.println(currentLine);
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("error updating file" + e.getMessage());
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}