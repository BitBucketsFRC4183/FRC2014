package org.bitbuckets.frc2014;

import java.util.Hashtable;
import java.io.IOException;
import javax.microedition.io.Connector;
import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataInputStream;


/**
 * CSV constants class.
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
 * 
 * @author forbesk
 */
public class Constants {
    private static Hashtable vars = new Hashtable();
    
    private Constants() {
        
    }
    
    /*
    parseCVS
    Reads a comma-separated values file and stores each line as a new constant.
    Because a hash table is used, values are overwritten if parseCSV is called
    more than once, allowing on-the-fly adjusting of constants.
    The csv should be formatted as such:
        <constantName>,<value>
    where constantName is in lowerCamelCase and value is a double. Each constant
    should be on its own line.
    
    Returns true if the operation was successful and false otherwise.
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
    
    /*
    isSet
    Returns true if the given constant name is loaded.
    */
    public static boolean isSet(String name) {
        return vars.containsKey(name);
    }
    
    /*
    get
    Returns the given constant's value as a double.
    */
    public static double get(String name) {
        Double value = (Double)vars.get(name);
        return value.doubleValue();
    }
    
    /*
    getInt
    Returns the given constant's value as an integer.
    */
    public static double getInt(String name) {
        Double value = (Double)vars.get(name);
        return (int)value.doubleValue();
    }
}
