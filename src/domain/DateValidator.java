/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hyber
 */
public class DateValidator
{
    public boolean isDateValid(String dateToValidate, String dateFromat){
 
		if(dateToValidate == null){
			return false;
		}
 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
 
		try {
 
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
 
		} catch (ParseException e) {
 
			e.printStackTrace();
			return false;
		}
 
		return true;
	}
}
