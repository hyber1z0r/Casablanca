/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Booking;
import domain.Bookings_Guests;
import domain.Guest;
import domain.Instructor;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
import java.util.ArrayList;

/**
 *
 * @author jakobgaardandersen
 */
public interface RoomMapperInterface
{
    ArrayList<Room> getAllFreeRooms(String sDate, String eDate);

    
    ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize);    

    
    boolean saveNewGuest(Guest g);

    
    boolean saveNewBooking(Booking b);
    

    boolean saveNewBookingsGuests(Bookings_Guests bg);
    
    
    ArrayList<Booking> getBookedRooms(String type);
    

    boolean confirmBooking(Booking b);
    

    boolean saveNewTAGUEST(Travelagency_guests tg);
    

    boolean deleteguests(Booking b);
    

    ArrayList<TodayGuest> getTodaysGuests(String date);
    
    
    ArrayList<Guest> showRegInfo(int room_id, String start_date);
    

    boolean updateGuest(Guest g);
    

    boolean saveNewInstructor(Instructor i);
   

    ArrayList<Instructor> getAllInstructors();
   

    boolean deleteInstructor(int id);
    
}
