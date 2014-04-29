/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import dataSource.GuestMapperInterface;
import domain.Facility_Booking;
import domain.Fbooking;
import domain.Fbooking_Guests;
import domain.Guest;
import domain.GuestDates;
import domain.Instructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Neno
 */
public class GuestMapperMock implements GuestMapperInterface
{
    Map<Integer, Guest> guests;

    public GuestMapperMock()
    {
        this.guests = new HashMap();
    }

    @Override
    public Guest checkLogin(String username, String password)
    {
        Guest g = null;
       for(Guest gs : guests.values())
       {
           if(username.equals(gs.getUsername()) && password.equals(gs.getPassword()))
               return gs;
       }
       return g;
    }

    @Override
    public boolean saveNewFBooking(Facility_Booking fb)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveNewFBookingsGuests(Fbooking_Guests fbg)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fbooking> getFBookings(int gID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GuestDates> getGuestDates(int gID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getNonFreeDates(String start_date, int FID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getNonFreeDatesIns(String start_date, int FID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFbooking(String start_date, int FID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Instructor getInstructor(String facility)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getBookingCount(int GID, String start_date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getGuestFBookings(int GID, String start_date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
