/*
 * FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 * Constants.java
 */

package org.bitbuckets.frc2014;

import java.util.Hashtable;
import java.io.IOException;
import javax.microedition.io.Connector;
import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataInputStream;


/**
 * Constants
 * @author  Kevin Forbes
 * 
 * Access and update constants on-the-fly in an external CSV file. Format the 
 * constants as follows:
 *      constant1,0.0
 *      intakeChannel,2
 *      autoRotation,45
 * place in an external file.
 * Parse the file before any constants are used:
 *      Constants.parseCSV("filepath");
 * Accessing a constant is easy:
 *      Constants.get("constant1");         //returns a double, 0.0
 *      Constants.get("intakeChannel");     //returns a double, 2.0
 *      Constants.getInt("intakeChannel");  //returns an int, 2
 */
public class Constants {
    /** 
     * vars
     * Mapping of constant names as Strings to values as Doubles. 
     * Using obsolete data structure due to Squawk limitations.
     */
    private static Hashtable vars = new Hashtable();
    
    /**
    * Constants
    * Empty private constructor for static class.
    */
    private Constants() {
        
    }
    
    /**
    * parseCSV
    * Reads a comma-separated values file and stores each line as a new constant.
    * Because a hash table is used, values are overwritten if parseCSV is called
    * more than once, allowing on-the-fly adjusting of constants.
    * The csv should be formatted as such:
    *     <constantName>,<value>
    * where constantName is in lowerCamelCase and value is a double. Each constant
    * should be on its own line.
    * 
    * @param    filepath    location of file containing constant names and values
    * @return               true on successful load, false otherwise
    */
    public static boolean parseCSV(String filepath) {
        FileConnection connection;
        DataInputStream stream;
        
        try {
            connection = (FileConnection)Connector.open(filepath, Connector.READ);
            stream = connection.openDataInputStream();
            
            while(stream.available() > 0) {
                String key = "";
                String value = "";
                char inchar;
                
                //read in a constant
                while(stream.available() > 0 && (inchar = stream.readChar()) != ',') {
                    key += inchar;
                }
                while(stream.available() > 0 && (inchar = stream.readChar()) != '\n') {
                    value += inchar;
                }
                vars.put(key, Double.valueOf(value));
            }
            
            stream.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WARNING: Couldn't read constants file!");
            return false;
        }
        
        return true;
    }
    
    /**
     * isSet
     * Determines if the given name is present in the constants table.
     * @param   name    constant name to look up
     * @return          true if found, false otherwise
     */
    public static boolean isSet(String name) {
        return vars.containsKey(name);
    }
    
    /**
     * get
     * Retrieves the stored value of the given constant name as a double
     * @param   name    constant name to look up
     * @return          value of constant as a double
     */
    public static double get(String name) {
        Double value = (Double)vars.get(name);
        return value.doubleValue();
    }
    
    /**
     * getInt
     * Retrieves the stored value of the given constant name as an integer
     * @param   name    constant name to look up
     * @return          value of constant as an integer
     */
    public static double getInt(String name) {
        Double value = (Double)vars.get(name);
        return (int)value.doubleValue();
    }
}
