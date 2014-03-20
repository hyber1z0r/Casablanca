/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Neno
 */
public class Room
{
    private int roomnumber;
    private int roomsize;
    
    public Room(int rn, int rs)
    {
        roomnumber = rn;
        roomsize = rs;
    }

    public int getRoomnumber()
    {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber)
    {
        this.roomnumber = roomnumber;
    }

    public int getRoomsize()
    {
        return roomsize;
    }

    public void setRoomsize(int roomsize)
    {
        this.roomsize = roomsize;
    }

    public String toString()
    {
        return  roomnumber + " " + roomsize;
    }
    
    
}
