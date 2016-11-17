package group.aim.framework.helper;

/**
 * Created by Nattapongr on 9/28/2016 AD.
 */

public class PrimitiveHelper {
    /**
     * Change the boolean string representative to actual boolean variable
     * "true", "t", 1   => true
     * "false", "f", 0  => false
     *
     * @param booleanString the string representative of boolean
     * @return the boolean format of input data
     */
    public static boolean boolFromString(String booleanString) {
        return booleanString.trim().equalsIgnoreCase("1") ||
                booleanString.trim().equalsIgnoreCase("t") ||
                booleanString.trim().equalsIgnoreCase("true");
    }
}
