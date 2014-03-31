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
public class Travelagency_guests
{
    private int travel_id, guest_id;

    public Travelagency_guests(int travel_id, int guest_id)
    {
        this.travel_id = travel_id;
        this.guest_id = guest_id;
    }

    public int getTravel_id()
    {
        return travel_id;
    }

    public void setTravel_id(int travel_id)
    {
        this.travel_id = travel_id;
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
