/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/*
************************************
// Author: Matthew Edwards
// Student ID: B00774765
// Date created: 09/03/2020
// Last modified: 30/03/2020
************************************
*/
public class NewLog extends MainMenu
{

    // create your private methods
    private  String date = null;
    private String assID;
    private String hours;
    private String exitVal;
    private String upperAssID;

    // setup the scanner
    public static final Scanner newInput = new Scanner(System.in);

    private static ArrayList<String[]> logs = new ArrayList<String[]>();   // new array list to store logs

    public void main() throws IOException, ParseException, StackOverflowError
    {

        getLogs(); // call the getlogs method from
        NewLog myNewLog = new NewLog(); // create an instance of the new log
        myNewLog.getUserInput(myNewLog); // call the get user input method
        super.mainMenu(); // return to main menu

    }

    // this method will get the logs from the handle log class
    private void getLogs() { logs = (ArrayList<String[]>) HandleLogs.getLogs(); }

    private String getDate()
    {
        try
        {

            System.out.print("Enter date (YYYYMMDD): ");

            // allow the entry to be stored
            date = MainMenu.userInput.nextLine();

            // this will force a parse exception to happen, to make sure the date matches the date format
            DateFormat myDateFormat = new SimpleDateFormat("yyyyMMdd");
            myDateFormat.setLenient(false); // make sure it is lenient or not
            myDateFormat.parse(date); // this will force the parse exception, if incorrect

        }

        catch (InputMismatchException ed)

        {

            // allow the user to enter the input again
            System.out.println("\n*Invalid input*\n");
            getDate(); // force entry

        }

        catch(NoSuchElementException ex) // input is whitespace
        {

            // allow the user to enter the input again
            System.out.println("*Invalid input!*");
            getDate(); // force entry

        }

        catch (ParseException e)
        {

            System.out.println("\n*Error* *Conform to the YYYYMMDD format*\n");
            getDate(); // force entry

        }
        return date;
    }

    private String getAssID()
    {
        try
        {
            // this gets the correct asset id
            System.out.print("Enter Asset ID (P/T/M followed by five digits): ");

            // allow the entry to be stored
            assID = newInput.nextLine();

            // this will parse the date into the scanner
            Scanner validate = new Scanner(assID);

            assID = validate.next("[PpTtMm]+\\d{5}");

            // this will go through each of the logs and match one if a user enters the id again.
            for(int a = 0; a < logs.size(); a++){

                if(assID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssID(); // force entry

                }

                else
                {

                    upperAssID = assID.toUpperCase();

                }
            }
            // this will check the pattern of the asset ID
            upperAssID = assID.toUpperCase();

        }


        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a valid asset ID*\n");
            // System.out.print("Please enter the Asset ID number: ");
            getAssID(); // force entry

        }

        catch (NoSuchElementException ef)

        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            // System.out.print("Please enter the Asset ID number: ");
            getAssID(); // force entry

        }

        return upperAssID;

    }
    private String getHours()
    {

        try
        {
            // this gets the correct asset id
            System.out.print("Enter number of hours: ");

            // allow the entry to be stored
            hours = newInput.nextLine();

            // this will parse the date into the scanner
            Scanner validate = new Scanner(hours);

            // this will check the pattern of the asset ID
            assID = validate.next("[0-9]+");

        }

        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Numerical values only*\n");
            getHours(); // force entry

        }


        catch (NoSuchElementException ef)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            getHours(); // force entry

        }
        catch (StackOverflowError m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a 1-99 value*\n");
            getHours(); // force entry

        }
        return hours;
    }


    private void getUserInput(NewLog myNewLog) throws NullPointerException, IOException, ParseException, NoSuchElementException
    {

        System.out.println("=======================================================================");

        // add each of the return methods to the array in the append log method
        appendLog(myNewLog.getDate(), myNewLog.getAssID(), myNewLog.getHours());

    }

    // This is the new array that will be added to the logs
    private void appendLog(String date1, String assID1, String hours1) throws IOException, ParseException
    {

        // this will append the new log to the logs
        String[] newLog = {date1, assID1, String.valueOf(hours1)};
        // this will add the new log and it can be used in this method, to add it
        goToMainMenu(newLog);

    }
    // this will allow the user to confirm to the log or not
    private void goToMainMenu(String[] theNewLog) throws IOException, ParseException
    {
        try
        {

            System.out.print("\nAre you sure you want to add this entry (Y or N)?: ");

            // read user input
            exitVal = newInput.nextLine().toUpperCase();

            if (exitVal.equals("")) // if the entry is empty
            {

                System.out.println("\n*Invalid input*");
                goToMainMenu(theNewLog); // go back to the main menu

            }

            else if (exitVal.equals("Y") || exitVal.equals("YES"))
            {

                System.out.println("\n----Entry added successfully----");
                logs.add(theNewLog); // add the log to the log file

            }
            else if (exitVal.equals("N") || exitVal.equals("NO"))
            {

                super.mainMenu(); // go back to main menu

            }
            else if (!exitVal.equals("N") || !exitVal.equals("NO") || !exitVal.equals("Y") || !exitVal.equals("YES"))
            {

                System.out.println("\n*Invalid input*");
                goToMainMenu(theNewLog); // force re-entry

            }

        }

        catch (NoSuchElementException eu) // input is whitespace
        {
            System.out.print("\nAre you sure you want to add this entry (Y or N)?: ");
             exitVal = newInput.nextLine().toUpperCase(); // convert user input to uppercase

            if (exitVal.equals(""))
            {

                System.out.println("\n*Invalid input*");
                goToMainMenu(theNewLog); //force re-entry

            }
            else if (exitVal.equals("Y") || exitVal.equals("YES"))
            {

                System.out.println("\n----Entry added successfully----");
                logs.add(theNewLog); // add the log to the log file

            }
            else if (exitVal.equals("N") || exitVal.equals("NO"))
            {

                super.mainMenu(); // go back to the main menu

            }
            else if (!exitVal.equals("N") || !exitVal.equals("NO") || !exitVal.equals("Y") || !exitVal.equals("YES"))
            {
                
                System.out.println("\n*Invalid input*");
                goToMainMenu(theNewLog); // force re-entry

            }

        }

    }

}
