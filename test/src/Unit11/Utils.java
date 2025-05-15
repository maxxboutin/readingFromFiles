package Unit11;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Utils
{
    private static final String DELIMITER = ":";

    public static void updateRecord(String character, String newHome)
    {

        File file = new File("src\\Lotr.txt");
        File tempFile = new File("src\\temp.txt");

        try(Scanner fileScanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(tempFile);)
        {

            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] section = line.split(DELIMITER);

                if (section.length < 4)
                {
                    System.out.println("File formatting error,");
                    continue;
                }

                String name = section[0].trim();
                String race = section[1].trim();
                String home = section[2].trim();
                String status = section[3].trim();

                if (name.equalsIgnoreCase(character))
                {
                    writer.println(name + DELIMITER +
                                    race + DELIMITER +
                                    newHome + DELIMITER +
                                    status);
                }

                else
                {
                    writer.println(line);
                }
            }
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        if (file.delete())
        {
            tempFile.renameTo(file);
        }

        else
        {
            System.out.println("File wasn't updated");
            tempFile.delete();
        }
    }
}