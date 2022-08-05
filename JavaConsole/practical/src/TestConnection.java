import DAO.CityDAO;
import Model.City;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        CityDAO cityDAO = new CityDAO();
        ArrayList<City> list = (ArrayList<City>) cityDAO.findAll();
        for (City c : list)
        {
            System.out.println(c.getCityId() + " " + c.getCityName());;
        }
//        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setUser("tien123");
//        ds.setPassword("123");
//        ds.setServerName("ADMIN-PC");
//        ds.setPortNumber(1433);
//        ds.setDatabaseName("MovieTheater");
//        try (Connection conn = ds.getConnection()) {
//            // crate statement
//            Statement stmt = conn.createStatement();
//            // get data from table 'student'
//            ResultSet rs = stmt.executeQuery("select * from City");
//            // show data
//            ArrayList<City> list = new ArrayList<>();
//
//            while (rs.next()) {
//                City city = new City();
//                city.setCityId(rs.getInt(1));
//                city.setCityName(rs.getString(2));
//                list.add(city);
//            }
//            for (City c : list)
//            {
//                System.out.println(c.getCityId() + " " + c.getCityName());;
//            }
//            // close connection
//            System.out.println("Connect successful !");
//            System.out.println(conn.getMetaData());
//        }
//        catch (SQLServerException throwables) {
//            throwables.printStackTrace();
//        }
//        catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
