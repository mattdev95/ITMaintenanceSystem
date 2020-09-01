/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
    Authors: Matthew Edwards (B00774765)
             Alex Patterson (B00777593)
    Date Created: 11/03/2020
    Last modified: 30/03/2020
*/

/*
This class will be able to get and run the each of the operations
This will inherit the classes into the main class, so you can gain access to each of the start methods in the classes
 */

public class MainMenu
{

    // create your local variable
    private String exitEntryVal;

    // create the scanner object
    public static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {

        // reads the log file into the program
        HandleLogs handle = new HandleLogs();
        handle.main();

        // Main menu class
        System.out.println("888       888          888                                          888 \n" +
                "888   o   888          888                                          888 \n" +
                "888  d8b  888          888                                          888 \n" +
                "888 d888b 888  .d88b.  888  .d8888b  .d88b.  88888b.d88b.   .d88b.  888 \n" +
                "888d88888b888 d8P  Y8b 888 d88P\"    d88\"\"88b 888 \"888 \"88b d8P  Y8b 888 \n" +
                "88888P Y88888 88888888 888 888      888  888 888  888  888 88888888 Y8P \n" +
                "8888P   Y8888 Y8b.     888 Y88b.    Y88..88P 888  888  888 Y8b.      \"  \n" +
                "888P     Y888  \"Y8888  888  \"Y8888P  \"Y88P\"  888  888  888  \"Y8888  888"); // welcome message
        // loads the menu
        MainMenu callMain = new MainMenu();
        callMain.mainMenu();

    }

    public void mainMenu() throws IOException, ParseException, NoSuchElementException // IOexception is needed for writing to a file in SaveChanges.java
    {
        System.out.println("======================================================================="); // for better program formatting
        System.out.println("[1] Display all log entries\n[2] Create new log entry\n[3] Delete a log entry\n[4] Run report\n" +
                "[5] Save all changes\n[6] Exit" );
        System.out.print("\nEnter an option: ");

        String option = userInput.nextLine(); // get user input

        try
        {

            // checks if the input is 1/2/3/4/5/6
            Scanner validate = new Scanner(option);
            option = validate.next("[123456]");

        }

        catch(InputMismatchException ex) // input doesn't match regex pattern
        {

            System.out.println("\n*Enter a valid selection*");
            mainMenu(); // calls mainMenu again in order to re obtain user input

        }
        catch(NoSuchElementException ex) // input is whitespace
        {

            System.out.println("\n*Enter a valid selection*");
            mainMenu(); // calls mainMenu again in order to re obtain user input

        }

        switch (option)
        {


            case "1":

                Display callDisplay = new Display(); // create an instance of the Display class
                callDisplay.main(); // calls the main method in the display class
                break;

            case "2":

                NewLog callNewLog = new NewLog(); // create an instance of the NewLog class
                callNewLog.main(); // calls the main method in the NewLog class
                break;

            case "3":

                DeleteLogs callDeleteLog = new DeleteLogs();  // create an instance of the DeleteLogs class
                callDeleteLog.main(); // calls the main method in the DeleteLogs class
                break;

            case "4":

                RunReport myReport = new RunReport(); // create an instance of the RunReport class
                myReport.main(); // calls the main method in the RunReport class
                break;

            case "5":

                SaveChanges callSaveChanges = new SaveChanges(); // create an instance of the SaveChanges class
                callSaveChanges.main(); // calls the main method in the SaveChanges class
                break;

            case "6":

                MainMenu myMenu = new MainMenu(); // create an instance of the MainMenu class
                myMenu.exitMenu(); // calls the exitMenu method

        }

    }

    public void exitMenu() throws IOException, ParseException
    {
        try
        {

            System.out.print("\nAre you sure you want to exit?: ");

            exitEntryVal = userInput.nextLine().toUpperCase(); // read user input

            if(exitEntryVal.equals("")) // if there is an empty value entered
            {

                System.out.println("\n*Invalid input*");
                exitMenu(); // force entry

            }

            else if(exitEntryVal.equals("Y") || exitEntryVal.equals("YES"))
            {

                System.out.println("=======================================================================");
                System.out.println(" .d8888b.                         888 888888b.                     888 \n" +
                        "d88P  Y88b                        888 888  \"88b                    888 \n" +
                        "888    888                        888 888  .88P                    888 \n" +
                        "888         .d88b.   .d88b.   .d88888 8888888K.  888  888  .d88b.  888 \n" +
                        "888  88888 d88\"\"88b d88\"\"88b d88\" 888 888  \"Y88b 888  888 d8P  Y8b 888 \n" +
                        "888    888 888  888 888  888 888  888 888    888 888  888 88888888 Y8P \n" +
                        "Y88b  d88P Y88..88P Y88..88P Y88b 888 888   d88P Y88b 888 Y8b.      \"  \n" +
                        " \"Y8888P88  \"Y88P\"   \"Y88P\"   \"Y88888 8888888P\"   \"Y88888  \"Y8888  888 \n" +
                        "                                                      888              \n" +
                        "                                                 Y8b d88P              \n" +
                        "                                                  \"Y88P\"               "); // exit message
                System.exit(0); // exit program

            }

            else if(exitEntryVal.equals("N") || exitEntryVal.equals("NO"))
            {

                this.mainMenu(); // go back to the main menu

            }

            else if(!exitEntryVal.equals("N") || !exitEntryVal.equals("NO") || !exitEntryVal.equals("Y") || !exitEntryVal.equals("YES") )
            {

                System.out.println("\n*Invalid input*"); // newline for nicer formatting
                exitMenu(); // force entry

            }

        }


        catch(NoSuchElementException eu) // input is whitespace
        {

            System.out.print("Please enter Y, N, Yes or No: ");
            exitEntryVal = userInput.nextLine().toUpperCase(); // get the user's input

            if(exitEntryVal.equals(""))
            {

                exitMenu(); // force entry

            }

            else if(exitEntryVal.equals("Y") || exitEntryVal.equals("YES"))
            {

                System.out.println(" .d8888b.                         888 888888b.                     888 \n" +
                        "d88P  Y88b                        888 888  \"88b                    888 \n" +
                        "888    888                        888 888  .88P                    888 \n" +
                        "888         .d88b.   .d88b.   .d88888 8888888K.  888  888  .d88b.  888 \n" +
                        "888  88888 d88\"\"88b d88\"\"88b d88\" 888 888  \"Y88b 888  888 d8P  Y8b 888 \n" +
                        "888    888 888  888 888  888 888  888 888    888 888  888 88888888 Y8P \n" +
                        "Y88b  d88P Y88..88P Y88..88P Y88b 888 888   d88P Y88b 888 Y8b.      \"  \n" +
                        " \"Y8888P88  \"Y88P\"   \"Y88P\"   \"Y88888 8888888P\"   \"Y88888  \"Y8888  888 \n" +
                        "                                                      888              \n" +
                        "                                                 Y8b d88P              \n" +
                        "                                                  \"Y88P\"               "); // exit message
                System.exit(0); // exit the program

            }

            else if(exitEntryVal.equals("N") || exitEntryVal.equals("NO"))
            {

                this.mainMenu(); // go back to the main menu

            }
            else if(!exitEntryVal.equals("N") || !exitEntryVal.equals("NO") || !exitEntryVal.equals("Y") || !exitEntryVal.equals("YES") )
            {

                System.out.println("*Invalid input*");
                exitMenu(); // force entry

            }

        }
    }
}
