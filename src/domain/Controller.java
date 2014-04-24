package domain;

import dataSource.*;
import java.util.ArrayList;

/**
 *
 * @author hyber
 */
public class Controller
{

    private static Controller instance = null;
    private ArrayList<Room> currentList;
    private Guest currentGuest;
    private Booking currentBooking;
    private Bookings_Guests currentBG;
    private ArrayList<Booking> currentBList;
    private Travelagency_guests currentTAG;
    private ArrayList<TodayGuest> currentTodayGuests;
    private ArrayList<Guest> currentGuests;
    private Instructor currentInstructor;
    private ArrayList<Instructor> currentIList;
    private Facility_Booking currentFBooking;
    private Fbooking_Guests currentFBooking_Guests;
    private final DBFacade dbf;

    public Controller()
    {
        dbf = new DBFacade();
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
            String country, int phone, String email, int age, String username, String password)
    {
        //== create guest object with guest id = 0
        currentGuest = new Guest(0, firstname, familyname, address, country, phone, email, age, username, password);

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

    public Booking deleteGuest(int room_id, String startdate)
    {
        currentBooking = new Booking(0, startdate, null, room_id, null, null);

        boolean status = dbf.deleteGuest(currentBooking);
        if (!status)
        {
            currentBooking = null;
        }
        return currentBooking;
    }

    public ArrayList<TodayGuest> getTodaysGuest(String date)
    {
        currentTodayGuests = dbf.getTodaysGuests(date);
        return currentTodayGuests;
    }

    public ArrayList<Guest> showRegInfo(int room_id, String start_date)
    {
        currentGuests = dbf.showRegInfo(room_id, start_date);
        return currentGuests;
    }

    public Guest checkLogin(String username, String password)
    {
        Guest g = dbf.checkLogin(username, password);
        return g;
    }

    public Guest updateguest(int guest_id, String firstname, String familyname, String address, String Country, int phone, String email, int age, String username, String password)
    {
        currentGuest = new Guest(guest_id, firstname, familyname, address, Country, phone, email, age, username, password);

        boolean status = dbf.updateguest(currentGuest);
        if (!status)
        {
            currentGuest = null;
        }
        return currentGuest;
    }

    public Instructor createNewInstructor(String name, String lastname, String email, int phone, String sport)
    {
        //== create instructor object with instructor id = 0
        currentInstructor = new Instructor(0, name, lastname, email, phone, sport);

        //== save and get DB-generated unique instructor id
        boolean status = dbf.saveNewInstructor(currentInstructor);
        if (!status) //fail!
        {
            currentInstructor = null;
        }
        return currentInstructor;
    }
    
    public ArrayList<Instructor> getAllInstructors()
    {
        currentIList = dbf.getAllInstructors();
        return currentIList;
    }
    
    public boolean deleteInstructor(int id)
    {
        return dbf.deleteInstructor(id);
    }
    
    public ArrayList<Fbooking> getFbookings(int gID)
    {
        return dbf.getFbookings(gID);
    }
    
    public ArrayList<GuestDates> getGuestDates(int gID)
    {
        return dbf.getGuestDates(gID);
    }
    
    public ArrayList<String> getNonFreeDates(String start_date, int FID)
    {
        return dbf.getNonFreeDates(start_date, FID);
    }
    
    public ArrayList<String> getNonFreeDatesIns(String start_date, int FID)
    {
        return dbf.getNonFreeDatesIns(start_date, FID);
    }
    
    public Facility_Booking saveNewFBooking(int FID, int IID, String start_date, String end_date, String reg_date)
    {
        currentFBooking = new Facility_Booking(0, FID, IID, start_date, end_date, reg_date);

        boolean status = dbf.saveNewFBooking(currentFBooking);
        if (!status)
        {
            currentFBooking = null;
        }
        return currentFBooking;
    }
    
    public Fbooking_Guests saveNewFbooking_Guests(int GID)
    {
        currentFBooking_Guests = new Fbooking_Guests(0, GID);

        boolean status = dbf.saveNewFBookingGuests(currentFBooking_Guests);
        if (!status)
        {
            currentFBooking = null;
        }
        return currentFBooking_Guests;
    }
    
    public boolean deleteFBooking(String start_date, int FID)
    {
        return dbf.deleteFbooking(start_date, FID);
    }
    
    public Instructor getInstructor(String facility)
    {
        currentInstructor = dbf.getInstructor(facility);
        return currentInstructor;
    }
    
    public int getBookingCount(int GID, String start_date)
    {
        return dbf.getBookingCount(GID, start_date);
    }
    
    
    public ArrayList<String> getGuestFBookings(int GID, String start_date)
    {
        return dbf.getGuestFBookings(GID, start_date);
    }
}
