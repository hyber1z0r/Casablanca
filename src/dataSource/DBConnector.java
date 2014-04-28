package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{

    private static final String id = "SEM2_GR01";
    private static final String pw = "SEM2_GR01";
    private static Connection connection;

    public static void initializeConnection()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
        } catch (SQLException e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("Could not create a Connection in DBConnector.getConnection(): " + e);
        }
    }

    public static Connection getConnection()
    {
        if (connection == null)
        {
            initializeConnection();
        }
        return connection;
    }

    public static void releaseConnection(Connection con)
    {
        try
        {
            connection.close();
        } catch (SQLException e)
        {
            System.err.println(e);
        }
    }
}
