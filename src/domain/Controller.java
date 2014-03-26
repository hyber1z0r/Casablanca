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

    public Booking createNewBooking(String start_date, String end_date, int room_id, String deposit_paid, String reg_date)
    {
        currentBooking = new Booking(0, start_date, end_date, room_id, deposit_paid, reg_date);

        boolean status = dbf.saveNewBooking(currentBooking);
        if (!status)
        {
            currentBooking = null;
        }
        return currentBooking;
    }
}
