/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import dataSource.RoomMapperInterface;
import domain.Booking;
import domain.Bookings_Guests;
import domain.Guest;
import domain.Instructor;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author jakobgaardandersen
 */
public class RoomMapperMock implements RoomMapperInterface
{

    Map<Integer, Guest> guests;
    Map<Integer, Booking> bookings;
    Map<Integer, Room> rooms;
    Map<Integer, Booking> confirmedbookings;
    Map<Integer, Instructor> instructors;
    Map<Integer, Integer> bguests;
    Map<Integer, Integer> taguests;

    public RoomMapperMock()
    {
        this.bguests = new HashMap();
        this.instructors = new HashMap();
        this.confirmedbookings = new HashMap();
        this.rooms = new HashMap();
        this.bookings = new HashMap();
        this.guests = new HashMap();
        this.taguests = new HashMap();
    }

    public void setInstructors(Map<Integer, Instructor> ins)
    {
        this.instructors = ins;
    }

    public void setGuests(Map<Integer, Guest> g)
    {
        this.guests = g;
    }

    public void setBookings(Map<Integer, Booking> b)
    {
        this.bookings = b;
    }

    public Map<Integer, Guest> getAllGuests()
    {
        return guests;
    }

    public Map<Integer, Booking> getAllBookings()
    {
        return bookings;
    }

    public Map<Integer, Booking> getAllConfirmedBookings()
    {
        return confirmedbookings;
    }

    @Override
    public boolean saveNewGuest(Guest g)
    {
        if (!guests.containsKey(g.getGuest_id()))
        {
            guests.put(g.getGuest_id(), g);
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public boolean saveNewBooking(Booking b)
    {
        if (!bookings.containsKey(b.getId()))
        {
            bookings.put(b.getId(), b);
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public ArrayList<Room> getAllFreeRooms(String sDate, String eDate)
    {
        ArrayList<Room> roomList = new ArrayList<>();
        for (Room r : rooms.values())
        {
            roomList.add(r);
        }
        return roomList;
    }

    @Override
    public ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        ArrayList<Room> roomList = new ArrayList<>();
        for (Room r : rooms.values())
        {
            if (r.getRoomsize() == rSize)
            {
                roomList.add(r);
            }
        }
        return roomList;
    }

    @Override
    public boolean saveNewBookingsGuests(Bookings_Guests bg)
    {
        Iterator it = bguests.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pairs = (Map.Entry) it.next();
            if (!pairs.getKey().equals(bg.getBooking_id()) && !pairs.getValue().equals(bg.getGuest_id()))
            {
                bguests.put(bg.getBooking_id(), bg.getGuest_id());
                return true;

            } else
            {
                it.remove(); // avoids a ConcurrentModificationException
                return false;
            }
        }
        bguests.put(bg.getBooking_id(), bg.getGuest_id());
        return true;
    }

    @Override
    public ArrayList<Booking> getBookedRooms(String type)
    {
        ArrayList<Booking> bookinglist = new ArrayList();

        switch (type)
        {
            case "yes":
                for (Booking b : confirmedbookings.values())
                {
                    bookinglist.add(b);
                }
                break;
            case "no":
                for (Booking b : bookings.values())
                {
                    bookinglist.add(b);
                }
                break;
        }
        return bookinglist;
    }

    @Override
    public boolean confirmBooking(Booking b)
    {
        if (!confirmedbookings.containsKey(b.getId()))
        {
            confirmedbookings.put(b.getId(), b);
            for (int key : bookings.keySet())
            {
                if (key == b.getId())
                {
                    bookings.remove(key);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean saveNewTAGUEST(Travelagency_guests tg)
    {
        Iterator it = taguests.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pairs = (Map.Entry) it.next();
            if (pairs.getKey().equals(tg.getTravel_id()) && pairs.getValue().equals(tg.getGuest_id()))
            {
                System.out.println("Findes allerede!");
                it.remove(); // avoids a ConcurrentModificationException
                return false;
            } else
            {
                taguests.put(tg.getTravel_id(), tg.getGuest_id());
                return true;
            }
        }
        taguests.put(tg.getTravel_id(), tg.getGuest_id());
        return true;
    }

    // in the applicatin it is only possible to delete a guest if his booking is on the standby list!
    @Override
    public boolean deleteguests(Booking b)
    {
        // first find guests that are related to that booking
        // then delete the guests from the guests map
        // then delete any references to them (Travelagency_Guest map, bookings_guests map, booking)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TodayGuest> getTodaysGuests(String date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Guest> showRegInfo(int room_id, String start_date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateGuest(Guest g)
    {
        if (!guests.containsKey(g.getGuest_id()))
        {
            return false;
        } else
        {
            guests.remove(g.getGuest_id());
            guests.put(g.getGuest_id(), g);
            return true;
        }
    }

    @Override
    public boolean saveNewInstructor(Instructor i)
    {
        if (!instructors.containsKey(i.getID()))
        {
            instructors.put(i.getID(), i);
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public ArrayList<Instructor> getAllInstructors()
    {
        ArrayList<Instructor> ins = new ArrayList();
        for (Instructor i : instructors.values())
        {
            ins.add(i);
        }
        return ins;
    }

    @Override
    public boolean deleteInstructor(int id)
    {
        if (instructors.containsKey(id))
        {
            instructors.remove(id);
            return true;
        }
        return false;
    }
}
