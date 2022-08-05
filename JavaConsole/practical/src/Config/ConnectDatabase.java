package Config;

import Model.City;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDatabase {
    public Connection getConnectionDB() throws SQLServerException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("tien123");
        ds.setPassword("123");
        ds.setServerName("ADMIN-PC");
        ds.setPortNumber(1433);
        ds.setDatabaseName("MovieTheater");
        Connection conn = ds.getConnection();
        try {
            System.out.println("Connect successful !");
            System.out.println(conn.getMetaData());
            return conn;
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
