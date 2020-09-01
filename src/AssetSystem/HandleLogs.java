/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Authors: Alex Patterson
    Date Created: 11/03/2020
    Last modified: 13/03/2020
*/

/*
This class will be read all logs from the log file and read them into an appropriate format ready for manipulating
 */
public class HandleLogs extends MainMenu
{
    /*
    logs.get(0)[0]  () is for iterating through logs and [] is for iterating through the elements in that log
    so System.out.println(logs.get(3)[1]) would print "M43567"
     */
    private static ArrayList<String[]> logs = new ArrayList<String[]>();  // list which contains a list of arrays
    private static ArrayList<String[]> ogLogs = new ArrayList<String[]>();  // new array list to store original logs

    public void main() throws IOException, ParseException // IOexception is needed for writing to a file in SaveChanges.java
    {
        File logFile = readFile();  // reads the log.csv
        parseFile(logFile);
    }

    public static List<String[]> getLogs()
    {
        return logs;
    }

    public static List<String[]> getOgLogs()
    {
        return ogLogs;
    }

    private static File readFile()
    {
        return new File("logfile.txt");
    }

    private static void parseFile(File logFile)
    {
        try
        {
            Scanner read = new Scanner(logFile); // new scanner for reading the log file

            // for each log puts all attributes into an array and adds to the log list
            while(read.hasNext())
            {
                String file = read.next();
                String[] values = file.split(","); // splits strings in line by "," and adds them to a array of 3 elements
                logs.add(values);
                ogLogs.add(values);
            }
            read.close();
        }
        catch(FileNotFoundException ex) // handles error if file isn't found
        {
            System.out.println("*File Not Found, Please Restart.*");
            System.exit(-1); // exits the program with exit code (-1) which means the program exited with an error
        }
    }
    //public static void setLogs(ArrayList<String[]> updateLogs) can be used if only 1 log arraylist is better
}
