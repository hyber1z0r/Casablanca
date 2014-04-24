/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Facility_Booking;
import domain.Fbooking;
import domain.Fbooking_Guests;
import domain.Guest;
import domain.GuestDates;
import domain.Instructor;
import java.util.ArrayList;

/**
 *
 * @author jakobgaardandersen
 */
public interface GuestMapperInterface
{
    Guest checkLogin(String username, String password);
    
    //first save facilitybooking, then fbooking guests, if any fail rollback.
    boolean saveNewFBooking(Facility_Booking fb);
    

    boolean saveNewFBookingsGuests(Fbooking_Guests fbg);
    

    ArrayList<Fbooking> getFBookings(int gID);
    

    ArrayList<GuestDates> getGuestDates(int gID);
    

    ArrayList<String> getNonFreeDates(String start_date, int FID);
    

    ArrayList<String> getNonFreeDatesIns(String start_date, int FID);
    

    boolean deleteFbooking(String start_date, int FID);
    

    Instructor getInstructor(String facility);
    

    int getBookingCount(int GID, String start_date);
    

    ArrayList<String> getGuestFBookings(int GID, String start_date);
    
}
