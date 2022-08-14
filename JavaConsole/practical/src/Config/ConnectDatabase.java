package Config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDatabase {
    public Connection getConnectionDB() throws SQLServerException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("phuoc1");
        ds.setPassword("123");
        ds.setServerName("DESKTOP-8JPNURT");
        ds.setPortNumber(1433);
        ds.setDatabaseName("ADF2_Pratical");
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
