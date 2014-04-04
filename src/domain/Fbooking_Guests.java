/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author jakobgaardandersen
 */
public class Fbooking_Guests
{
    private int GID, FID;

    public Fbooking_Guests(int GID, int FID)
    {
        this.GID = GID;
        this.FID = FID;
    }

    public int getGID()
    {
        return GID;
    }

    public void setGID(int GID)
    {
        this.GID = GID;
    }

    public int getFID()
    {
        return FID;
    }

    public void setFID(int FID)
    {
        this.FID = FID;
    }
    
    
}
