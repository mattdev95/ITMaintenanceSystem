/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;

/*
<<<<<<< HEAD
    Authors: Alex Patterson (B00777593)
=======
    Authors: Alex Patterson
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
    Date Created: 13/03/2020
    Last modified: 13/03/2020
*/

/*
This class will save all changes made within the program to the Logs.csv
 */

public class SaveChanges extends MainMenu
{
<<<<<<< HEAD
    //From a personal project (Alex Patterson, 2020)
=======

>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
    private static ArrayList<String[]> logs = new ArrayList<String[]>();  // new array list to store logs
    private static ArrayList<String[]> ogLogs = new ArrayList<String[]>();  // new array list to store original logs

    public void main() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
<<<<<<< HEAD
        this.getLogs();  // gets the logs from handlelogs
=======
        getLogs();  // gets the logs from handlelogs
>>>>>>> 22cde5f6a5d4de0563fc81d8c94e39abcc6b64c4
        // checks if there is no changes
        if(ogLogs.equals(logs))
        {
            System.out.println("\n*No Changes to make*");
            super.mainMenu(); // go back to main menu
        }

        saveToFile(); // saves the logs to Logs.csv
    }

    private void getLogs()
    {
        // sets the logs from handle logs to the one of the SaveChanges class
        logs = (ArrayList<String[]>) HandleLogs.getLogs();
        ogLogs = (ArrayList<String[]>) HandleLogs.getOgLogs();
    }

    private void saveToFile() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
        Writer writeToFile = new FileWriter("logfile.txt"); // used to see what file to write to
        String allLogs = "";

        // adds all items of logs to a large string abiding by the format date,id,hours
        for(String[] items : logs)
        {
            allLogs += items[0] + ",";
            allLogs += items[1] + ",";
            allLogs += items[2] + "\n";
        }

        // removes the \n at the end (if there)
        if(allLogs==null)
        {
            String rmvNewLine = allLogs.substring(0, allLogs.length()-1);

            // writes all logs to Logs.csv
            writeToFile.write(rmvNewLine);
        }
        else
        {
            // writes all logs to Logs.csv
            writeToFile.write(allLogs);
        }
        writeToFile.close();

        System.out.println("\n*Changes made successfully*");
        super.mainMenu(); // go back to main menu
    }
}