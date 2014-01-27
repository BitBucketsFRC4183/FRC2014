package org.bitbuckets.frc2014;

import java.util.Hashtable;

/**
 *
 * @author forbesk
 */
public class Constants {
    private String filepath;
    private Hashtable vars;
    
    public Constants(String file) {
        filepath = "file:///" + file;
        vars = new Hashtable();
    }
    
    /*
    parseCVS
    Reads a comma-separated values file and stores each line as a new constant.
    First step is to remove all current constants, should the user desire to 
    reload all constants.
    The csv should be formatted as such:
        <constantName> <value>
    where constantName is in lowerCamelCase and value is a double. Each constant
    should be on its own line.
    
    Returns true if the operation was successful and false otherwise.
    */
    public boolean parseCSV() {
        //TODO: implement comma separated value parsing here
        return false;
    }
    
    /*
    isSet
    Returns true if the given constant name is loaded.
    */
    public boolean isSet(String name) {
        return vars.containsKey(name);
    }
    
    /*
    get
    Returns the given constant's value as a double.
    */
    public double get(String name) {
        Double value = (Double)vars.get(name);
        return value.doubleValue();
    }
    
    /*
    getInt
    Returns the given constant's value as an integer.
    */
    public double getInt(String name) {
        Double value = (Double)vars.get(name);
        return (int)value.doubleValue();
    }
}
