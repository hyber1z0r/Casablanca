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
public class TodayGuest
{
    private int room_id;
    private String firstname, familyname, username, password;

    public TodayGuest(int room_id, String firstname, String familyname, String username, String password)
    {
        this.room_id = room_id;
        this.firstname = firstname;
        this.familyname = familyname;
        this.username = username;
        this.password = password;
    }

    public int getRoom_id()
    {
        return room_id;
    }

    public void setRoom_id(int room_id)
    {
        this.room_id = room_id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getFamilyname()
    {
        return familyname;
    }

    public void setFamilyname(String familyname)
    {
        this.familyname = familyname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    
}
