/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openinfobutton.app.model;

/**
 *
 * @author rick
 */
public class AgeUnitUcumCode {

    public final static String MINUTE = "min";
    public final static String HOUR = "h";
    public final static String DAY = "d";
    public final static String WEEK = "wk";
    public final static String MONTH = "mo";
    public final static String YEAR = "a";

    public static boolean isValidCode(String code) {

        if (MINUTE.equals(code)
                || HOUR.equals(code)
                || DAY.equals(code)
                || WEEK.equals(code)
                || MONTH.equals(code)
                || YEAR.equals(code)) {
            return true;
        }

        return false;
    }
}
