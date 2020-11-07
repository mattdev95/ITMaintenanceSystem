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
import java.util.Date;

/*
************************************
// Author: Matthew Edwards
// Date created: 09/03/2020
// Last modified:30/03/2020
************************************
*/
public class DisplayLogs extends MainMenu 
{

    // create instance variables
    private int count = 0;
    private int countLogs = 0;
    private String logDate = "";
    private String myDate = "";
    // setup the simple date format
    private SimpleDateFormat previousDate;
    private SimpleDateFormat newDate;
    //setup the date
    private Date parsedDate;

    // This will count each of the logs
    private final int countAllLogs = countLogs();

    //This array will store each of the logs
    private final String[] myLogs = new String[countAllLogs];
    

    private static ArrayList<String[]> logs = new ArrayList<String[]>();  // new array list to store logs

    // create the main class
    public void main() throws IOException, ParseException, IndexOutOfBoundsException
    {

        DisplayLogs myDisplay = new DisplayLogs(); // create an instance of the Display class
        myDisplay.displayLogs(); // access the display logs method
        super.mainMenu(); // go back to the main menu

    }

    // this will run all the methods in this class
    public void displayLogs() throws IOException, ParseException {


        this.getLogs(); // call the getLogs copy from the HandleLogs class
        DisplayLogs myDisplay = new DisplayLogs(); // this will create an instance of the display class
        myDisplay.convertLogs(myDisplay); // this will call the convert logs method

    }

    // this method will get the logs from the handle log class
    private void getLogs() { logs = (ArrayList<String[]>) HandleLogs.getLogs(); }

    // this method counts the logs in the file
    public int countLogs() throws IndexOutOfBoundsException
    {
        // this counts the lines in the text file
        countLogs = logs.size();
        return countLogs;

    }
    // this will replace all the commas in each of the logs with spaces.
    private void convertLogs(DisplayLogs callDisplay) throws IOException, IndexOutOfBoundsException, ParseException
    {

        try
        {
            // this will loop through until the count equals to the amount of lines in the log file
            while (count != countLogs)
            {

                // this will store each of the lines in the file as 1 index position in the array
                for(int i = 0; i < countLogs; i++)
                {

                    // this will convert all the logs to from a comma to a space an store it in myLogs array
                    myLogs[i] = logs.get(i)[0].replace(",", " ") + " " + logs.get(i)[1].replace(",", " ") + " " + logs.get(i)[2];
                    count++; // this will count each of the iterations

                } // end of for loop

            } // end of while loop

            callDisplay.printLogs(); // call the method

        }

        catch (IndexOutOfBoundsException ed)
        {

            System.out.println("Error has occurred");
            super.mainMenu(); // return to main menu, if error has occurred.

        }

    }

    // this will print out the log files
    public void printLogs() throws IOException, IndexOutOfBoundsException
    {
        try
        {
            // this will check if there are zero logs and will back to main menu
            if(countLogs == 0)
            {

                System.out.println("\n*Error* *No log entries*");
                super.mainMenu();

            }

            // this will print a message out at the top of the console
            System.out.println("=======================================================================");
            System.out.println("Date    Asset ID  Hours");
            System.out.println("=======================================================================");

            for(int i = 0; i < logs.size(); i++)  // this will loop through each of the logs
            {

                // get the position of the date
                logDate = logs.get(i)[0];

                //Pankaj. (n.d.) Java SimpleDateFormat – Java Date Format 
                //Available from: https://www.journaldev.com/17899/java-simpledateformat-java-date-format [Accessed 19 March 2020]
                // convert the old format to the new date format
                previousDate = new SimpleDateFormat("yyyyMMdd");
                parsedDate = previousDate.parse(logDate); // this will parse the date to a string 

                // convert to the new date format
                newDate = new SimpleDateFormat("dd/MM/yyyy");
                myDate = newDate.format(parsedDate); // this will change the format, to a new format

                // print out the new date format
                System.out.println(myDate + " " + logs.get(i)[1] + " " + logs.get(i)[2]);

            } // end of the for loop

        }
        // if an error occurs
        catch(IndexOutOfBoundsException | ParseException dfd)
        {

            System.out.println("\n*Error* *No log entries*");

        }

    }

}
