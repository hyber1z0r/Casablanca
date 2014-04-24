package dataSource;

import domain.Booking;
import domain.Bookings_Guests;
import domain.Facility_Booking;
import domain.Fbooking;
import domain.Fbooking_Guests;
import domain.Guest;
import domain.GuestDates;
import domain.Instructor;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
import java.util.ArrayList;

public class DBFacade
{
    private static DBFacade instance;
    private static RoomMapperInterface rm;
    private static GuestMapperInterface gm;

    public DBFacade()
    {
        rm = new RoomMapper(DBConnector.getConnection());
        gm = new GuestMapper(DBConnector.getConnection());
    }

    /**
     * Use this constructor to provide your own OrderMapperInterface instancse
     * (for testing)
     */
    public DBFacade(RoomMapperInterface rmi)
    {
        rm = rmi;
    }
    
    public DBFacade(GuestMapperInterface gmi)
    {
        gm = gmi;
    }

    public ArrayList<Room> getAllFreeRooms(String sDate, String eDate)
    {
        return rm.getAllFreeRooms(sDate, eDate);
    }

    public ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        return rm.getSizeFreeRooms(sDate, eDate, rSize);
    }

    public boolean saveNewGuest(Guest g)
    {
        return rm.saveNewGuest(g);
    }

    public boolean saveNewBooking(Booking b)
    {
        return rm.saveNewBooking(b);
    }

    public boolean saveNewBookingsGuests(Bookings_Guests bg)
    {
        return rm.saveNewBookingsGuests(bg);
    }

    public ArrayList<Booking> getBookedRooms(String type)
    {
        return rm.getBookedRooms(type);
    }

    public boolean confirmBooking(Booking b)
    {
        return rm.confirmBooking(b);
    }

    public boolean saveNewTAGUEST(Travelagency_guests tg)
    {
        return rm.saveNewTAGUEST(tg);
    }

    public boolean deleteGuest(Booking b)
    {
        return rm.deleteguests(b);
    }

    public ArrayList<TodayGuest> getTodaysGuests(String date)
    {
        return rm.getTodaysGuests(date);
    }

    public ArrayList<Guest> showRegInfo(int room_id, String start_date)
    {
        return rm.showRegInfo(room_id, start_date);
    }

    public Guest checkLogin(String username, String password)
    {
        return gm.checkLogin(username, password);
    }

    public boolean updateguest(Guest g)
    {
        return rm.updateGuest(g);
    }

    public boolean saveNewInstructor(Instructor i)
    {
        return rm.saveNewInstructor(i);
    }

    public ArrayList<Instructor> getAllInstructors()
    {
        return rm.getAllInstructors();
    }

    public boolean deleteInstructor(int id)
    {
        return rm.deleteInstructor(id);
    }

    public boolean saveNewFBooking(Facility_Booking fb)
    {
        return gm.saveNewFBooking(fb);
    }

    public boolean saveNewFBookingGuests(Fbooking_Guests fbg)
    {
        return gm.saveNewFBookingsGuests(fbg);
    }

    public ArrayList<Fbooking> getFbookings(int gID)
    {
        return gm.getFBookings(gID);
    }

    public ArrayList<GuestDates> getGuestDates(int gID)
    {
        return gm.getGuestDates(gID);
    }

    public ArrayList<String> getNonFreeDates(String start_date, int FID)
    {
        return gm.getNonFreeDates(start_date, FID);
    }

    public ArrayList<String> getNonFreeDatesIns(String start_date, int FID)
    {
        return gm.getNonFreeDatesIns(start_date, FID);
    }

    public boolean deleteFbooking(String start_date, int FID)
    {
        return gm.deleteFbooking(start_date, FID);
    }

    public Instructor getInstructor(String facility)
    {
        return gm.getInstructor(facility);
    }

    public int getBookingCount(int GID, String start_date)
    {
        return gm.getBookingCount(GID, start_date);
    }

    public ArrayList<String> getGuestFBookings(int GID, String start_date)
    {
        return gm.getGuestFBookings(GID, start_date);
    }
}
