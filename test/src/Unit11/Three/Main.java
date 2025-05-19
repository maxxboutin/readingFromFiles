package Unit11.Three;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        boolean isProgramRunning = true;

        while (isProgramRunning)
        {

            showMenu();
            String choice = userInput.nextLine();

            switch (choice)
            {
                case "1": //register

                    //gets username
                    System.out.println("Enter username:");
                    String username = userInput.nextLine();

                    //gets password
                    System.out.println("Enter password:");
                    String password = userInput.nextLine();

                    // Is password valid
                    if (!isValidPassword(password))
                    {
                        System.out.println("Password isn't valid");
                        break;
                    }

                    // Is input not null
                    if (!isNotNull(username) || !isNotNull(password))
                    {
                        System.out.println("empty username or password");
                        break;
                    }

                    //create new user
                    User user = new User(username, password);
                    Utils.createUser(user);

                    //createUser(newUser);

                    System.out.println("User registration success");

                    break;

                case "2": //login

                    //takes in username and password from user
                    System.out.println("Enter username:");
                    String loginName = userInput.nextLine();
                    System.out.println("Enter password:");
                    String loginPassword = userInput.nextLine();

                    // Is input not null
                    if (!isNotNull(loginName) || !isNotNull(loginPassword))
                    {
                        System.out.println("empty username or password");
                        break;
                    }

                    User validUser = Utils.fetchUser(loginName, loginPassword);

                    //fetchUser(loginName, loginPassword);

                    if (validUser != null)
                    {
                        System.out.println("Welcome, " + validUser.getName() + "!");
                    }
                    else
                    {
                        System.out.println("user not found");
                    }

                    break;

                case "3": //update

                    System.out.println("Enter username to update:");
                    String newUsername = userInput.nextLine();
                    System.out.println("Enter current password:");
                    String oldPassword = userInput.nextLine();

                    //if userinput is not null
                    if (!isNotNull(newUsername) || !isNotNull(oldPassword))
                    {
                        System.out.println("empty username or password");
                    }


                    User userToUpdate = Utils.fetchUser (newUsername, oldPassword);

                    if (userToUpdate != null)
                    {
                        System.out.println("Enter new password: ");
                        String updatePassword = userInput.nextLine();
                    }

                    else
                    {
                        System.out.println("user not found");
                    }


                    // if (validUser)
                    // ask for new password
                    //check for valid password
                    //check for userinput not null

                    // updateUser

                    //update user account

                    break;

                case "4": //exit
                    isProgramRunning = false;
                    System.out.println("Exiting login program");
                    break;

                default: //Error
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }

    private static void showMenu()
    {
        System.out.println("--- MENU ---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Update");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    public static boolean isValidPassword(String password)
    {
        int passwordMinimum = 4;
        return password != null && password.length() >= passwordMinimum;
    }

    public static boolean isNotNull(String input)
    {
        return input != null;
    }
}