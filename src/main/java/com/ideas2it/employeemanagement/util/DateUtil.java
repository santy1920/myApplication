package com.ideas2it.employeemanagement.util;

import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.service.EmployeeService;

/* 
 * <p>
 * This class is used to perform functions on date related
 * operations using util classes.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class DateUtil {
 
    /**
     * <p>
     * This method is used to calculate the difference in
     * the years.
     * </p>
     * 
     * @param inputDate String input date.
     * 
     * return value difference in dates.
     */
    public static int getDateDifference(Date inputDate) {
        int age;
        Calendar birthDate = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();
        age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);   
        if (birthDate.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH)) {
            age--;
        }
        return age;
    }
          
    /*
     * <p>
     * This method is used to validate whether the given date of
     * birth is correct or not.
     * </p>
     *
     * @param date Date contains date.
     *
     * @return either true or false.
     */
    public static boolean isValidDate(String date) {
        Pattern pattern = Pattern.compile(Constants.DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    } 
 
    /** 
     * <p>
     * This is used to convert a given date into sql date format 
     * </p>
     *
     * @param date Date
     *
     * @return sqlDate Date format
     */ 
    public static java.sql.Date convertToSqlDateFormat(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    /** 
     * This method is used to convert a given date string input 
     * into date format. 
     * 
     * @param  inputDate String 
     *
     * @return date Date
     */
    public static Date convertStringToDateFormat(String inputDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat(Constants.GET_DATE_FORMAT).
                parse(inputDate);
        }  
        catch (ParseException exception) {
            System.out.println(exception);
        }
        return date;
    }
    
    /** 
     * This method is used to convert a given date input 
     * into string format. 
     * 
     * @param date Date 
     *
     * @return string format of the date
     */
    public static String convertDateToStringFormat(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(Constants.GET_DATE_FORMAT);  
        return dateFormat.format(date);
    }
}
