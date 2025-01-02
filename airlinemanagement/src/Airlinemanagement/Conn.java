package Airlinemanagement;
import java.sql.*;
public class Conn {

    Connection C;
    Statement S;
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            C=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root","12345");
            S=C.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
