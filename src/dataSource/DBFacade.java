package dataSource;
import domain.Booking;
import domain.Bookings_Guests;
import domain.Guest;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
import java.sql.Connection;
import java.util.ArrayList;


public class DBFacade {

    
    private final RoomMapper rm;
    private final Connection con;
    private static DBFacade instance;
    
    private DBFacade()
    {
        rm = new RoomMapper();
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
}

