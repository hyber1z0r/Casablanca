/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Neno
 */
public class ReservationStatus
{
    private int ID;
    private String status;
    
    public ReservationStatus(int ID, String s)
    {
       status = s;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
       
    public String toString()
    {
        return ID + " " + status;
    }
    
}
