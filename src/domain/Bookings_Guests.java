/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author hyber
 */
public class Bookings_Guests
{
    private int booking_id;
    private int guest_id;

    public Bookings_Guests(int booking_id, int guest_id)
    {
        this.booking_id = booking_id;
        this.guest_id = guest_id;
    }

    public int getBooking_id()
    {
        return booking_id;
    }

    public void setBooking_id(int booking_id)
    {
        this.booking_id = booking_id;
    }

    public int getGuest_id()
    {
        return guest_id;
    }

    public void setGuest_id(int guest_id)
    {
        this.guest_id = guest_id;
    }
    
    
}
