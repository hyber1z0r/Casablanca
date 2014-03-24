/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hyber
 */
public class DateValidator
{

    public boolean isDateValid(String dateToValidate, String dateFromat)
    {

        if (dateToValidate == null)
        {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try
        {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e)
        {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean isDateHigher(String dateToEvalue1, String dateToEvalue2, String dateFromat) 
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
            sdf.setLenient(false);
            Date date1 = sdf.parse(dateToEvalue1);
            Date date2 = sdf.parse(dateToEvalue2);
            if (date1.before(date2))
            {
                return true;
            } 
        } catch (ParseException ex)
        {
            Logger.getLogger(DateValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;


    }
}
