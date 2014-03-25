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
public class Booking
{
    private int id;
    private String start_date;
    private String end_date;
    private int room_id;
    private int guest_id;

    public Booking(int id, String start_date, String end_date, int room_id, int guest_id)
    {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.room_id = room_id;
        this.guest_id = guest_id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStart_date()
    {
        return start_date;
    }

    public void setStart_date(String start_date)
    {
        this.start_date = start_date;
    }

    public String getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date(String end_date)
    {
        this.end_date = end_date;
    }

    public int getRoom_id()
    {
        return room_id;
    }

    public void setRoom_id(int room_id)
    {
        this.room_id = room_id;
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
