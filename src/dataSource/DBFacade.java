package dataSource;
import domain.Booking;
import domain.Guest;
import domain.Room;
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
}

