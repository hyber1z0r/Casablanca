package domain;

import dataSource.*;
import java.util.ArrayList;

/**
 *
 * @author hyber
 */
public class Controller
{
    private final DBFacade dbf;
    private static Controller instance = null;
    private ArrayList<String> currentList;
    
    private Controller()
    {
        dbf = DBFacade.getInstance();
    }
    
    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }
        return instance;
    }

    public ArrayList<String> getAllFreeRooms(String sDate, String eDate)
    {
        currentList = dbf.getAllFreeRooms(sDate, eDate);
        return currentList;
    }
    
    public ArrayList<String> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        currentList = dbf.getSizeFreeRooms(sDate, eDate, rSize);
        return currentList;
    }
}
