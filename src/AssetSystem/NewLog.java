/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import java.text.DateFormat;
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/*
************************************
// Author: Matthew Edwards
<<<<<<< HEAD
// Student ID: B00774765
// Date created: 09/03/2020
// Last modified: 08/04/2020
=======
// Date created: 09/03/2020
<<<<<<< HEAD
// Last modified: 08/04/2020
=======
// Last modified: 30/03/2020
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
************************************
*/
public class NewLog extends MainMenu
{

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    // create your local variables 
    private String date = "";
    private String assetID = "";
    private String hours = "";
    private String exitVal = "";
    // setup the Scanner
    private Scanner validateAssetID;
    private Scanner validateHours ;
    //setup the simpledateformat
    private SimpleDateFormat myDateFormat;
    
<<<<<<< HEAD
=======
    //From a personal project (Alex Patterson, 2020)
=======
    // setup your variables
    private  String date = null;
    private String assID;
    private String hours;
    private String exitVal;
    private String upperAssID;

    // setup the scanner
    public static final Scanner newInput = new Scanner(System.in);
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
    private static ArrayList<String[]> logs = new ArrayList<String[]>();   // new array list to store logs

    public void main() throws IOException, ParseException, StackOverflowError
    {

<<<<<<< HEAD
        this.getLogs(); // call the getLogs copy from the HandleLogs class
=======
<<<<<<< HEAD
        this.getLogs(); // call the getLogs copy from the HandleLogs class
=======
        getLogs(); // call the getlogs method from
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
        NewLog myNewLog = new NewLog(); // create an instance of the new log
        myNewLog.getUserInput(myNewLog); // call the get user input method
        super.mainMenu(); // return to main menu

    }

    // this method will get the logs from the handle log class
    private void getLogs() { logs = (ArrayList<String[]>) HandleLogs.getLogs(); }
<<<<<<< HEAD
    
    // this method will get the date input and validate it
=======
<<<<<<< HEAD
    
    // this method will get the date input and validate it
=======

>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    private String getDate()
    {
        try
        {

            System.out.print("Enter date (YYYYMMDD): ");

            // allow the entry to be stored
            date = MainMenu.userInput.nextLine();

<<<<<<< HEAD
            //Anon. (n.d.) How to parse a date strictly? Available from: https://stackoverflow.com/questions/13088140/java-how-to-parse-a-date-strictly [Accessed 20 March 2020]
            // this will force a parse exception to happen, to make sure the date matches the date format
            myDateFormat = new SimpleDateFormat("yyyyMMdd");
            myDateFormat.setLenient(false); // make sure it is lenient and to make sure it follows the date pattern, if not show invalid input
=======
<<<<<<< HEAD
            //Anon. (n.d.) How to parse a date strictly? Available from: https://stackoverflow.com/questions/13088140/java-how-to-parse-a-date-strictly [Accessed 20 March 2020]
            // this will force a parse exception to happen, to make sure the date matches the date format
            myDateFormat = new SimpleDateFormat("yyyyMMdd");
            myDateFormat.setLenient(false); // make sure it is lenient and to make sure it follows the date pattern, if not show invalid input
=======
            // this will force a parse exception to happen, to make sure the date matches the date format
            DateFormat myDateFormat = new SimpleDateFormat("yyyyMMdd");
            myDateFormat.setLenient(false); // make sure it is lenient or not
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
            myDateFormat.parse(date); // this will force the parse exception, if incorrect

        }

        catch (InputMismatchException ed)

        {

            // allow the user to enter the input again
            System.out.println("\n*Invalid input*\n");
<<<<<<< HEAD
            getDate(); // force re-entry
=======
<<<<<<< HEAD
            getDate(); // force re-entry
=======
            getDate(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }

        catch(NoSuchElementException ex) // input is whitespace
        {

            // allow the user to enter the input again
            System.out.println("*Invalid input!*");
<<<<<<< HEAD
            getDate(); // force re-entry
=======
<<<<<<< HEAD
            getDate(); // force re-entry
=======
            getDate(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }

        catch (ParseException e)
        {

            System.out.println("\n*Error* *Conform to the YYYYMMDD format*\n");
<<<<<<< HEAD
            getDate(); // force re-entry
=======
<<<<<<< HEAD
            getDate(); // force re-entry
=======
            getDate(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }
        return date;
    }
<<<<<<< HEAD
    // this method will get the assetID input and validate it
    private String getAssetID()
=======
<<<<<<< HEAD
    // this method will get the assetID input and validate it
    private String getAssetID()
=======

    private String getAssID()
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    {
        try
        {
            // this gets the correct asset id
<<<<<<< HEAD
            System.out.print("Enter Asset ID (M/P/T/O followed by five digits): ");
=======
<<<<<<< HEAD
            System.out.print("Enter Asset ID (M/P/T/O followed by five digits): ");

            // allow the entry to be stored
            assetID = MainMenu.userInput.nextLine();

            // this will parse the asset ID into the scanner
            validateAssetID = new Scanner(assetID);

            assetID = validateAssetID.next("[PpTtMmOo]+\\d{5}");
=======
            System.out.print("Enter Asset ID (P/T/M followed by five digits): ");
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

            // allow the entry to be stored
            assetID = MainMenu.userInput.nextLine();

            // this will parse the asset ID into the scanner
            validateAssetID = new Scanner(assetID);

<<<<<<< HEAD
            assetID = validateAssetID.next("[PpTtMmOo]+\\d{5}");
=======
            assID = validate.next("[PpTtMm]+\\d{5}");
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

            // this will go through each of the logs and match one if a user enters the id again.
            for(int a = 0; a < logs.size(); a++){

<<<<<<< HEAD
                if(assetID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssetID(); // force re-entry
=======
<<<<<<< HEAD
                if(assetID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssetID(); // force re-entry
=======
                if(assID.equals(logs.get(a)[1])) // if it equals the asset id index position
                {

                    System.out.println("\n*Error* *No duplicates*\n"); // show warning to the user
                    getAssID(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

                }

                else
                {
<<<<<<< HEAD
                    //get the uppercase of the AssetId input
                    this.assetID = this.assetID.toUpperCase();

                }
            }
            
=======
<<<<<<< HEAD
                    //get the uppercase of the AssetId input
                    this.assetID = this.assetID.toUpperCase();

                }
            }
            
=======

                    upperAssID = assID.toUpperCase();

                }
            }
            // this will check the pattern of the asset ID
            upperAssID = assID.toUpperCase();

>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
        }


        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a valid asset ID*\n");
<<<<<<< HEAD
            getAssetID(); // force re-entry
=======
<<<<<<< HEAD
            getAssetID(); // force re-entry
=======
            // System.out.print("Please enter the Asset ID number: ");
            getAssID(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }

        catch (NoSuchElementException ef)

        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
<<<<<<< HEAD
            getAssetID(); // force re-entry
=======
<<<<<<< HEAD
            getAssetID(); // force re-entry

        }

        return assetID;

    }
    
    // this method will get the hours input and validate it
=======
            // System.out.print("Please enter the Asset ID number: ");
            getAssID(); // force entry
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }

        return assetID;

    }
<<<<<<< HEAD
    
    // this method will get the hours input and validate it
=======
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    private String getHours()
    {

        try
        {
<<<<<<< HEAD
            // this gets the hours
=======
<<<<<<< HEAD
            // this gets the hours
            System.out.print("Enter number of hours: ");

            // allow the entry to be stored
            hours = MainMenu.userInput.nextLine();

            // this will parse the hours into the scanner
            validateHours = new Scanner(hours);

            // this will check the pattern of the hours
            hours = validateHours.next("[0-9]+");
=======
            // this gets the correct asset id
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
            System.out.print("Enter number of hours: ");

            // allow the entry to be stored
            hours = MainMenu.userInput.nextLine();

            // this will parse the hours into the scanner
            validateHours = new Scanner(hours);

<<<<<<< HEAD
            // this will check the pattern of the hours
            hours = validateHours.next("[0-9]+");
=======
            // this will check the pattern of the asset ID
            assID = validate.next("[0-9]+");
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }

        catch (InputMismatchException m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Numerical values only*\n");
<<<<<<< HEAD
            getHours(); // force re-entry
=======
<<<<<<< HEAD
            getHours(); // force re-entry
=======
            getHours(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }


        catch (NoSuchElementException ef)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Invalid input*\n");
<<<<<<< HEAD
            getHours(); // force re-entry
=======
<<<<<<< HEAD
            getHours(); // force re-entry
=======
            getHours(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }
        catch (StackOverflowError m)
        {

            // this will keep asking the user until they entered correctly
            System.out.println("\n*Error* *Enter a 1-99 value*\n");
<<<<<<< HEAD
            getHours(); // force re-entry
=======
<<<<<<< HEAD
            getHours(); // force re-entry
=======
            getHours(); // force entry
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

        }
        return hours;
    }


    private void getUserInput(NewLog myNewLog) throws NullPointerException, IOException, ParseException, NoSuchElementException
    {

        System.out.println("=======================================================================");

        // add each of the return methods to the array in the append log method
<<<<<<< HEAD
        appendLog(myNewLog.getDate(), myNewLog.getAssetID(), myNewLog.getHours());
=======
<<<<<<< HEAD
        appendLog(myNewLog.getDate(), myNewLog.getAssetID(), myNewLog.getHours());
=======
        appendLog(myNewLog.getDate(), myNewLog.getAssID(), myNewLog.getHours());
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

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
<<<<<<< HEAD
            exitVal = MainMenu.userInput.nextLine().toUpperCase();
=======
<<<<<<< HEAD
            exitVal = MainMenu.userInput.nextLine().toUpperCase();
=======
            exitVal = newInput.nextLine().toUpperCase();
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

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
<<<<<<< HEAD
             exitVal = MainMenu.userInput.nextLine().toUpperCase(); // convert user input to uppercase
=======
<<<<<<< HEAD
             exitVal = MainMenu.userInput.nextLine().toUpperCase(); // convert user input to uppercase
=======
             exitVal = newInput.nextLine().toUpperCase(); // convert user input to uppercase
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

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
