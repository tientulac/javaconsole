package DAO;

import Config.ConnectDatabase;
import Model.City;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    ConnectDatabase cnn = new ConnectDatabase();
    public List<City> findAll() throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        // get data from table 'student'
        ResultSet rs = stmt.executeQuery("select * from City");
        // show data
        ArrayList<City> list = new ArrayList<>();

        while (rs.next()) {
            City city = new City();
            city.setCityId(rs.getInt(1));
            city.setCityName(rs.getString(2));
            list.add(city);
        }
        // close connection
        return list;
    }
}
