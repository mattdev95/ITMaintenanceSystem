/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
    Authors: Alex Patterson
             Matthew Edwards
    Date Created: 20/03/2020
    Last modified: 09/04/2020
*/

//This class will let the user delete logs by entering the corresponding id
public class EditLogs extends MainMenu
{
    // setup the local variables
    private String attributeToChange = "";
    private String attributeToUse = "";
    private String date = "";
    private String assetID = "";
    private String hours = "";
    private String chosenAttribute = "";
    private String userEditInput = "";
    private String userValInput = "";
    private String checkAssetID;
    //setup the Scanner
    private Scanner validateInput;
    private Scanner validateAssetID;
    private Scanner validateHours;
    //setup the simple date format
    private SimpleDateFormat myDateFormat;
    

    private static ArrayList<String[]> logs = new ArrayList<String[]>(); // new array list to store logs
    
    public void main() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {

        this.getLogs(); // copy of logs from HandleLogs to the logs of this class

        // checks if there is no log entries
        if (logs.size() == 0)
        {

            System.out.println("\n*Error no log entries*");
            super.mainMenu(); // go back to the main menu

        }

        userEditInput = getUserInput(); // get the users input
        EditLogs myEditLogEntry = new EditLogs(); // create an instance of the EditLogEntry class
        editAttribute(userEditInput, myEditLogEntry);

        // go back to main menu
        super.mainMenu();

    }
    
    // copy of logs from HandleLogs to the logs of this class - Alex Patterson
    private void getLogs() {
        logs = (ArrayList<String[]>) HandleLogs.getLogs();
    }
    
    private String getUserInput() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
        
        //Alex Patterson
        //show all logs to choose from
        DisplayLogs callShowAllLogs = new DisplayLogs(); // create an instance of the Display class
        callShowAllLogs.displayLogs(); // call the displayLogs method
        System.out.print("\nEnter the Asset ID of the entry to edit: ");
        

        try
        {

            // read user input
            userValInput = MainMenu.userInput.nextLine();
            validateInput = new Scanner(userValInput);

            // regular expression first letter must be P/p/T/t/M/m along with 5 digits
            userValInput = validateInput.next("[PpTtMmOo]+\\d{5}").toUpperCase();

        }

        catch (InputMismatchException ex) // input doesn't match regex pattern
        {

            System.out.println("\n*Enter a Valid Asset ID*");
            main(); // calls main again in order to re obtain user input

        }

        catch (NoSuchElementException ex) // input is whitespace
        {

            System.out.println("\n*Enter a Valid Selection*");
            main(); // calls mainMenu again in order to re obtain user input

        }

        return userValInput.toUpperCase();

    }
    
    
    private String attributeToChange()
            
    {   
        //Alex Patterson
        //this is the option menu to the user, to pick which attribute they want to change 
        System.out.println("====================================");
        System.out.println("[1] Date [2] Asset ID  [3] Hours");
        System.out.println("====================================");
        System.out.print("Enter the attribute you want to change: ");
            
            //Matthew Edwards
            try
            {

                // read user input
                attributeToChange = MainMenu.userInput.nextLine();

                if(attributeToChange.equals("1") || attributeToChange.equals("2") || attributeToChange.equals("3"))
                {

                    attributeToUse = attributeToChange; // the variable to return the number entered

                }
                else if (attributeToChange != "1" || attributeToChange != "2" || attributeToChange != "3")
                {

                    System.out.println("\n*Enter a Valid Number*");
                    attributeToChange(); // force re-entry

                }

            }
            
            catch (InputMismatchException ex) // if other value
            {

                System.out.println("\n*Enter a Valid Asset ID*");
                attributeToChange(); // force re-entry

            }

            catch (NoSuchElementException ex) // input is whitespace
            {

                System.out.println("\n*Enter a Valid Selection*");
                attributeToChange(); // force re-entry

            }

        return attributeToUse;

    }
    //Alex Patterson
    private void editAttribute(String userInput, EditLogs callEditLogEntry) {

        chosenAttribute = callEditLogEntry.attributeToChange(); // get the attibute the user wants to change

        for (int i = 0; i < logs.size(); i++)
        {

            checkAssetID = logs.get(i)[1]; // [1] is the element were the asset id is stored for each log
            if (checkAssetID.equals(userInput)) // if the user's input matches check

            {

                // remove the log from logs and trim the arraylist
                switch (chosenAttribute)

                {
                    //check if option 1 is selected
                    case "1":

                        date = callEditLogEntry.getDate(); // call the getDate method to validate the date
                        logs.get(i)[0] = date; // this will change the value to the new input
                        break;
                    //check if option 2 is selected
                    case "2":

                        assetID = callEditLogEntry.getAssetID(); // call the getAssetID method to validate the asset ID
                        logs.get(i)[1] = assetID; // this will change the value to the new input
                        break;
                    //check if option 3 is selected
                    case "3":

                        hours = callEditLogEntry.getHours(); // call the getHours method to validate the hours
                        logs.get(i)[2] = hours; // this will change the value to the new input
                        break;

                }

                System.out.println("\n----Log successfully changed----");
                break;

            }

            // needed to check the last element of logs to inform the log the user was searching for wasn't found
            else if ((i == (logs.size() - 1)) && (checkAssetID != userInput))
            {

                System.out.println("\n*Error* *Entry not Found*");
                break;

            }
        }

    }

    //Matthew Edwards
    // get each of the inputs and then return them.
    private String getDate(){
        try
        {

            System.out.print("Enter date (YYYYMMDD): ");

            // allow the entry to be stored
            date = MainMenu.userInput.nextLine();

           //Anon. (n.d.) How to parse a date strictly? Available from: https://stackoverflow.com/questions/13088140/java-how-to-parse-a-date-strictly [Accessed 20 March 2020]
            // this will force a parse exception to happen, to make sure the date matches the date format
            myDateFormat = new SimpleDateFormat("yyyyMMdd");
            myDateFormat.setLenient(false); // make sure it is lenient and to make sure it follows the date pattern, if not show invalid input
            myDateFormat.parse(date); // this will force the parse exception, if incorrect

        }

        catch (InputMismatchException ed)

        {

            // allow the user to enter the input again
            System.out.println("\n*Invalid input*\n");
            getDate(); // force re-entry

        }

        catch(NoSuchElementException ex) // input is whitespace
        {

            // allow the user to enter the input again
            System.out.println("*Invalid input!*");
            getDate(); // force re-entry
        }

        catch (ParseException e)
        {

            System.out.println("\n*Error* *Conform to the YYYYMMDD format*\n");
            getDate(); // force re-entry

        }
        return date;
    }
    
    //Matthew Edwards
    // if asset id is chosen run this method
    private String getAssetID()
    {
        try
        {
            // this gets the correct asset id
            System.out.print("Enter Asset ID (M/P/T/O followed by five digits): ");

            // allow the entry to be stored
            assetID = MainMenu.userInput.nextLine();

            // this will parse the date into the scanner
            validateAssetID = new Scanner(assetID);

            assetID = validateAssetID.next("[PpTtMmOo]+\\d{5}");

            // this will go through each of the logs and match one if a user enters the id again.
            for(int a = 0; a < logs.size(); a++)
            {

                if(assetID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssetID(); // force re-entry

                }

                else
                {
                    
                    this.assetID = this.assetID.toUpperCase(); // get the upper case input

                }
            }

        }


        catch (InputMismatchException m) // if other value
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a valid asset ID*\n");
            // System.out.print("Please enter the Asset ID number: ");
            getAssetID(); // force re-entry

        }

        catch (NoSuchElementException ef) // if whitespace

        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            // System.out.print("Please enter the Asset ID number: ");
            getAssetID(); // force re-entry

        }

        return assetID;

    }
    
    //Matthew Edwards
    // if hours are chosen run this method
    private String getHours()
    {

        try
        {
            // this gets the hours
            System.out.print("Enter number of hours: ");

            // allow the entry to be stored
            hours = MainMenu.userInput.nextLine();

            // this will parse the hours into the scanner
            validateHours = new Scanner(hours);

            // this will check the pattern of the asset ID
            hours = validateHours.next("[0-9]+");

        }

        catch (InputMismatchException m) // if other character
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Numerical values only*\n");
            getHours(); // force re-entry

        }


        catch (NoSuchElementException ef) // If whitespace
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            getHours(); // force entry

        }

        return hours;
    }

}


