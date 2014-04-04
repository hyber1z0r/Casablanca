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
public class Facility
{
    private int id, courts, players;
    private String name;

    public Facility(int id, int courts, int players, String name)
    {
        this.id = id;
        this.courts = courts;
        this.players = players;
        this.name = name;
    }

    public int getCourts()
    {
        return courts;
    }

    public void setCourts(int courts)
    {
        this.courts = courts;
    }

    public int getPlayers()
    {
        return players;
    }

    public void setPlayers(int players)
    {
        this.players = players;
    }

    

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    
}
