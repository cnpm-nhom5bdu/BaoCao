package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuong Nguyen
 */


public class DateFormater {
    public static String format(String date){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Date dateTemp = sdf1.parse(date);
            return sdf2.format(dateTemp);
        } catch (ParseException ex) {
            Logger.getLogger(DateFormater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String formatDateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
    public static Date formatStringToDate(String s){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(s);
        } catch (ParseException ex) {
            ex.getMessage();
            return null;
        }
    }
    
    public static java.sql.Date formatStringToSqlDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return java.sql.Date.valueOf(sdf.format(date));
    }
    
    public static void main(String[] args) {
        Date date = DateFormater.formatStringToDate("15-07-1999");
        System.out.println(DateFormater.formatDateToString(date));
    }

}
