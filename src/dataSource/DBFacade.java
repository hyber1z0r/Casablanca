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
import java.sql.Connection;
import java.util.ArrayList;


public class DBFacade {

    
    private final RoomMapper rm;
    private final Connection con;
    private final GuestMapper gm;
    private static DBFacade instance;
    
    private DBFacade()
    {
        rm = new RoomMapper();
        gm = new GuestMapper();
        con = new DBConnector().getConnection();  	  
    }
    
    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }
    
    public ArrayList<Room> getAllFreeRooms(String sDate, String eDate)
    {
        return rm.getAllFreeRooms(sDate, eDate, con);
    }
    
    public ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        return rm.getSizeFreeRooms(sDate, eDate, rSize, con);
    }
    
    public boolean saveNewGuest(Guest g)
    {
        return rm.saveNewGuest(g, con);
    }
    
    public boolean saveNewBooking(Booking b)
    {
        return rm.saveNewBooking(b, con);
    }
    
    public boolean saveNewBookingsGuests(Bookings_Guests bg)
    {
        return rm.saveNewBookingsGuests(bg, con);
    }
    
    public ArrayList<Booking> getBookedRooms(String type)
    {
        return rm.getBookedRooms(type, con);
    }
    public boolean confirmBooking(Booking b)
    {
        return rm.confirmBooking(b, con);
    }
    
    public boolean saveNewTAGUEST(Travelagency_guests tg)
    {
        return rm.saveNewTAGUEST(tg, con);
    }
    
    public boolean deleteGuest(Booking b)
    {
        return rm.deleteguests(b, con);
    }
    
    public ArrayList<TodayGuest> getTodaysGuests(String date)
    {
        return rm.getTodaysGuests(date, con);
    }
    
    public ArrayList<Guest> showRegInfo(int room_id, String start_date)
    {
        return rm.showRegInfo(room_id, start_date, con);
    }
    
    public Guest checkLogin(String username, String password)
    {
        return gm.checkLogin(username, password, con);
    }
    
    public boolean updateguest(Guest g)
    {
        return rm.updateGuest(g, con);
    }
    
    public boolean saveNewInstructor(Instructor i)
    {
        return rm.saveNewInstructor(i, con);
    }
    
    public ArrayList<Instructor> getAllInstructors()
    {
        return rm.getAllInstructors(con);
    }
    
    public boolean deleteInstructor(int id)
    {
        return rm.deleteInstructor(id, con);
    }
    
    public boolean saveNewFBooking(Facility_Booking fb)
    {
        return gm.saveNewFBooking(fb, con);
    }
    
    public boolean saveNewFBookingGuests(Fbooking_Guests fbg)
    {
        return gm.saveNewFBookingsGuests(fbg, con);
    }
    
    public ArrayList<Fbooking> getFbookings(int gID)
    {
        return gm.getFBookings(gID, con);
    }
    
    public ArrayList<GuestDates> getGuestDates(int gID)
    {
        return gm.getGuestDates(gID, con);
    }
    
    public ArrayList<String> getNonFreeDates(String start_date, int FID)
    {
        return gm.getNonFreeDates(start_date, FID, con);
    }
    
    public ArrayList<String> getNonFreeDatesIns(String start_date, int FID)
    {
        return gm.getNonFreeDatesIns(start_date, FID, con);
    }
    
    public boolean deleteFbooking(String start_date, int FID)
    {
        return gm.deleteFbooking(start_date, FID, con);
    }
}

