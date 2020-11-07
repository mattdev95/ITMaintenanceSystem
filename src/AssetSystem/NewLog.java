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
************************************
// Author: Matthew Edwards
// Date created: 09/03/2020
// Last modified: 08/04/2020
************************************
*/
public class NewLog extends MainMenu
{

    // create your instance variables 
    private String date = "";
    private String assetID = "";
    private String hours = "";
    private String exitVal = "";
    // setup the Scanner
    private Scanner validateAssetID;
    private Scanner validateHours ;
    //setup the simpledateformat
    private SimpleDateFormat myDateFormat;
    

    private static ArrayList<String[]> logs = new ArrayList<String[]>();   // new array list to store logs

    public void main() throws IOException, ParseException, StackOverflowError
    {

        this.getLogs(); // call the getLogs copy from the HandleLogs class
        NewLog myNewLog = new NewLog(); // create an instance of the new log
        myNewLog.getUserInput(myNewLog); // call the get user input method
        super.mainMenu(); // return to main menu

    }

    // this method will get the logs from the handle log class
    private void getLogs() { logs = (ArrayList<String[]>) HandleLogs.getLogs(); }
    
    // this method will get the date input and validate it
    private String getDate()
    {
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
    // this method will get the assetID input and validate it
    private String getAssetID()
    {
        try
        {
            // this gets the correct asset id
            System.out.print("Enter Asset ID (M/P/T/O followed by five digits): ");

            // allow the entry to be stored
            assetID = MainMenu.userInput.nextLine();

            // this will parse the asset ID into the scanner
            validateAssetID = new Scanner(assetID);

            assetID = validateAssetID.next("[PpTtMmOo]+\\d{5}");

            // this will go through each of the logs and match one if a user enters the id again.
            for(int a = 0; a < logs.size(); a++){

                if(assetID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssetID(); // force re-entry

                }

                else
                {
                    //get the uppercase of the AssetId input
                    this.assetID = this.assetID.toUpperCase();

                }
            }
            
        }


        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a valid asset ID*\n");
            getAssetID(); // force re-entry

        }

        catch (NoSuchElementException ef)

        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            getAssetID(); // force re-entry

        }

        return assetID;

    }
    
    // this method will get the hours input and validate it
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

            // this will check the pattern of the hours
            hours = validateHours.next("[0-9]+");

        }

        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Numerical values only*\n");
            getHours(); // force re-entry

        }


        catch (NoSuchElementException ef)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
            getHours(); // force re-entry

        }
        catch (StackOverflowError m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a 1-99 value*\n");
            getHours(); // force re-entry

        }
        return hours;
    }


    private void getUserInput(NewLog myNewLog) throws NullPointerException, IOException, ParseException, NoSuchElementException
    {

        System.out.println("=======================================================================");

        // add each of the return methods to the array in the append log method
        appendLog(myNewLog.getDate(), myNewLog.getAssetID(), myNewLog.getHours());

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
            exitVal = MainMenu.userInput.nextLine().toUpperCase();

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
             exitVal = MainMenu.userInput.nextLine().toUpperCase(); // convert user input to uppercase

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
