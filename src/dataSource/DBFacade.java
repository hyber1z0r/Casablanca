package dataSource;
import java.sql.Connection;
import java.util.ArrayList;


public class DBFacade {

    
    private final RoomMapper rm;
    private final Connection con;
    private static DBFacade instance;
    
    private DBFacade()
    {
        rm = new RoomMapper();
        con = new DBConnector().getConnection();  	  
    }
    
    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }
    
    public ArrayList<String> getAllFreeRooms(String sDate, String eDate)
    {
        return rm.getAllFreeRooms(sDate, eDate, con);
    }
    
    public ArrayList<String> getSizeFreeRooms(String sDate, String eDate, int rSize)
    {
        return rm.getSizeFreeRooms(sDate, eDate, rSize, con);
    }
}

