package domain;

import dataSource.*;
import java.util.ArrayList;

/**
 *
 * @author hyber
 */
public class Controller
{

    private final DBFacade dbf;
    private static Controller instance = null;
    private ArrayList<Room> currentList;
    private Guest currentGuest;
    private Booking currentBooking;
    private Bookings_Guests currentBG;
    private ArrayList<Booking> currentBList;
    private Travelagency_guests currentTAG;

    private Controller()
    {
        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }
        return instance;
    }

    public ArrayList<Room> getAllFreeRooms(String sDate, String eDate)
    {
        currentList = dbf.getAllFreeRooms(sDate, eDate);
        return currentList;
    }

    public ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        currentList = dbf.getSizeFreeRooms(sDate, eDate, rSize);
        return currentList;
    }

    public Guest createNewGuest(String firstname, String familyname, String address,
            String country, int phone, String email, int travel_agency, String username, String password)
    {
        //== create guest object with guest id = 0
        currentGuest = new Guest(0, firstname, familyname, address, country, phone, email, travel_agency, username, password);

        //== save and get DB-generated unique guest id
        boolean status = dbf.saveNewGuest(currentGuest);
        if (!status) //fail!
        {
            currentGuest = null;
        }
        return currentGuest;
    }

    public Booking createNewBooking(String start_date, String end_date, int room_id, String reg_date)
    {
        currentBooking = new Booking(0, start_date, end_date, room_id, "no", reg_date);

        boolean status = dbf.saveNewBooking(currentBooking);
        if (!status)
        {
            currentBooking = null;
        }
        return currentBooking;
    }

    public Bookings_Guests createNewBookingsGuests(int guestid)
    {
        currentBG = new Bookings_Guests(0, guestid);

        boolean status = dbf.saveNewBookingsGuests(currentBG);
        if (!status)
        {
            currentBG = null;
        }
        return currentBG;
    }
    
    public ArrayList<Booking> getBookedRooms(String type)
    {
        currentBList = dbf.getBookedRooms(type);
        return currentBList;
    }
    
    public Booking confirmBooking(int room_id, String startdate)
    {
        currentBooking = new Booking(0, startdate, null, room_id, null, null);

        boolean status = dbf.confirmBooking(currentBooking);
        if (!status)
        {
            currentBooking = null;
        }
        return currentBooking;
    }
    
    public Travelagency_guests createNewTAGUEST(int travel_id, int guest_id)
    {
        currentTAG = new Travelagency_guests(travel_id, guest_id);
        
        boolean status = dbf.saveNewTAGUEST(currentTAG);
        if (!status)
        {
            currentTAG = null;
            
        }
        return currentTAG;
    }
}
