/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
    Authors: Alex Patterson
    Date Created: 13/03/2020
    Last modified: 13/03/2020
*/

//This class will let the user delete logs by entering the corresponding id

public class DeleteLogs extends MainMenu
{
    private static ArrayList<String[]> logs = new ArrayList<String[]>(); // new array list to store logs

    public void main() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
        getLogs(); // copy of logs from HandleLogs to the logs of this class
        // checks if there is no log entries
        if(logs.size()==0)
        {
            System.out.println("\n*Error no log entries*");
            super.mainMenu();
        }
        String userInput = getUserInput(); // get the users input
        removeLog(userInput); // remove log which matches the user's input
        // go back to main menu
        super.mainMenu();
    }

    private void getLogs()
    {
        logs = (ArrayList<String[]>) HandleLogs.getLogs();
    }

    private String getUserInput() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
        //show all logs to choose from
        Display callShowAllLogs = new Display();
        callShowAllLogs.displayLogs();
        System.out.print("\nEnter the Asset ID of the entry to delete: ");
        String userInput = null;

        try
        {
            // read user input
            userInput = MainMenu.userInput.nextLine();
            Scanner validate = new Scanner(userInput);

            // regular expression first letter must be P/p/T/t/M/m along with 5 digits
            userInput = validate.next("[PpTtMm]+\\d{5}").toUpperCase();
        }
        catch (InputMismatchException ex) // input doesn't match regex pattern
        {
            System.out.println("\n*Enter a Valid Asset ID*");
            main(); // calls main again in order to re obtain user input
        }
        catch(NoSuchElementException ex) // input is whitespace
        {
            System.out.println("\n*Enter a Valid Selection*");
            main(); // calls mainMenu again in order to re obtain user input
        }

        return userInput.toUpperCase();
    }

    private void removeLog(String userInput)
    {
        // uses i to iterate through all logs in the logs arraylist
        for(int i = 0; i<logs.size(); i++)
        {
            String check = logs.get(i)[1]; // [1] is the element were the asset id is stored for each log
            if(check.equals(userInput)) // if the user's input matches check
            {
                // remove the log from logs and trim the arraylist
                logs.remove((i));
                logs.trimToSize();

                System.out.println("\n----Log successfully deleted----");
                break;
            }
            // needed to check the last element of logs to inform the log the user was searching for wasn't found
            else if((i==(logs.size()-1))&&(check!=userInput))
            {
                System.out.println("\n*Error* *Entry not Found*");
                break;
            }
        }
    }
}


