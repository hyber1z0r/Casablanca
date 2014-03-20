package dataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class DBFacade {

    
    private final RoomMapper rm;
    private final Connection con;
//    private static OrderMapperInterface om; 
    private static DBFacade instance;
    
    private DBFacade()
    {
        rm = new RoomMapper();
        con = new DBConnector().getConnection();  // the connection will be released upon program 
        // termination by the garbage collector		  
    }
    
    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }
    //== Singleton end
    
    public ArrayList<String> getRooms(String type)
    {
        return rm.getRooms(type, con);
    }
}

