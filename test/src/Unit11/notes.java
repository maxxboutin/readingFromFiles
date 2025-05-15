package Unit11;

import java.util.Scanner;

public class notes
{

    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Character's name");
        String characterName = userInput.nextLine();

        System.out.println("Where does " + characterName + "live now?");
        String newHome = userInput.nextLine();

        Utils.updateRecord(characterName, newHome);

    }

}