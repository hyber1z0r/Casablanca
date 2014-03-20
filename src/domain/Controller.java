package domain;

import dataSource.*;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<String> getRooms(String type)
    {
        currentList = dbf.getRooms(type);
        return currentList;
    }
}
