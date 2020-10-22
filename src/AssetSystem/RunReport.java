/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/*
************************************
// Author: Matthew Edwards
<<<<<<< HEAD
// Student ID: B00774765
=======
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
// Date created: 09/03/2020
// Last modified: 30/03/2020
************************************
*/
public class RunReport extends MainMenu {

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    //From a personal project (Alex Patterson, 2020)
    private static ArrayList<String[]> logs = new ArrayList<String[]>();  // new array list to store logs

    // create your local variables
    private int totalHours = 0;
    private int count = 0;
    private int averageHrs = 0;
<<<<<<< HEAD
    private int countHr = 0;
    private String hourPosition = "";
=======
    private int countHr = 0;
    private String hourPosition = "";
=======

    private static ArrayList<String[]> logs = new ArrayList<String[]>();  // new array list to store logs

    // create your instance variables
    private int totalHours = 0;
    private int count;
    private int averageHrs;
    private int countHr = 0;
    private String hourPosition;
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

    public void main() throws IOException, ParseException
    {

<<<<<<< HEAD
        this.getLogs(); // call the getLogs copy from the HandleLogs class
=======
<<<<<<< HEAD
        this.getLogs(); // call the getLogs copy from the HandleLogs class
=======
        getLogs(); // from the handle log class
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
        RunReport myReport = new RunReport(); // create an instance of the RunReport class
        myReport.printReport(myReport); // print the report

        // this will go back to the main menu
        super.mainMenu();

    }
    // this will get use the handle logs class
    private void getLogs() { logs = (ArrayList<String[]>) HandleLogs.getLogs(); }

    // get a count of all the logs
    private int getCount()
    {

        // this get the number of lines in the log
        count = logs.size();
        return count;

    }

    // this will get the average hours of all the logs and return a value
    private int getAverage() throws IOException, ParseException
    {
        try
        {

            for(int i = 0; i < logs.size(); i++) // for each of the records in the logs

            {

                // this will get the position in the logs for the hours
                String hours = logs.get(i)[2];
                // parse the hours location and change into an int
                int conHours = Integer.parseInt(hours);
                // add the the total of the hours
                totalHours = totalHours + conHours;

            } // end of the for loop

            // get the average hours
            averageHrs = totalHours / getCount();

        }

        catch(NoSuchElementException ty)
        {

            System.out.print("Error has occurred");
            super.mainMenu(); // this will call the main menu to appear

        }
        return averageHrs;

    }

<<<<<<< HEAD
    // this will return a count of all the tasks greater than 4 hours to complete.
=======
<<<<<<< HEAD
    // this will return a count of all the tasks greater than 4 hours to complete.
=======
    // this will return a count of all the task greater than 4 hours to complete.
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
    private int getFourHrTasks() throws ParseException, IOException
    {
        try
        {

            for(int i = 0; i < logs.size(); i++)

            {
                // this will get the index position 2 of each lines of the logs and if its equal 4 hr or more it will print out
                hourPosition = logs.get(i)[2];

                // parse the hours location and change into an int
                int conHours = Integer.parseInt(hourPosition);

                // then if the hours are greater then four print out
                if(conHours > 4)
                {

<<<<<<< HEAD
                    countHr++; // get a count of the hours
=======
<<<<<<< HEAD
                    countHr++; // get a count of the hours
=======
                    countHr++;
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74

                }

            } // end of the for loop
        }
<<<<<<< HEAD
        catch(NoSuchElementException er)
=======
<<<<<<< HEAD
        catch(NoSuchElementException er)
=======
        catch(NoSuchElementException eu)
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
        {

            System.out.print("Error has occurred");
            super.mainMenu(); // call the main menu

        }

        return countHr;
    }

    // this will print out the report
    private void printReport(RunReport myReport) throws ParseException, IOException
    {
        try
        {

            System.out.println("=======================================================================");

            if(logs.size() == 0) // if there is no logs
            {

                System.out.print("");
                System.out.println("*Error* *No log entries*");

            }

            // else there are logs, print out the report
            else
            {

                System.out.println("Log entry count: " + myReport.getCount() +
                        "\nAverage hours for entries: " + myReport.getAverage() +
                        "\nCount of entries greater than four hours: " + myReport.getFourHrTasks());

            }
        }

        catch(NoSuchElementException ei)
        {

            System.out.print("Error has occurred");
            super.mainMenu(); // call the main menu to appear

        }

    }

}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
>>>>>>> 740f161f91e41030b167d58e0f0a6dd38763dd74
