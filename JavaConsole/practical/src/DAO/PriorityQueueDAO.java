package DAO;

import Config.ConnectDatabase;
import Model.Book;
import Model.PriorityQueue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueDAO {
    ConnectDatabase cnn = new ConnectDatabase();
    public List<PriorityQueue> findAll() throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from PriorityQueue");
        // show data
        ArrayList<PriorityQueue> list = new ArrayList<>();

        while (rs.next()) {
            PriorityQueue pq = new PriorityQueue();
            pq.setReservationID(rs.getInt(1));
            pq.setPassengerName(rs.getString(2));
            pq.setAddress(rs.getString(3));
            pq.setPhone(rs.getString(4));
            pq.setDateOfDeparture(rs.getDate(5));
            pq.setDateOfReturn(rs.getDate(6));
            list.add(pq);
        }
        // close connection
        return list;
    }


    public PriorityQueue findById(int id) throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from PriorityQueue WHERE  ReservationID = " + id);
        // show data
        PriorityQueue pq = new PriorityQueue();

        while (rs.next()) {
            pq.setReservationID(rs.getInt(1));
            pq.setPassengerName(rs.getString(2));
            pq.setAddress(rs.getString(3));
            pq.setPhone(rs.getString(4));
            pq.setDateOfDeparture(rs.getDate(5));
            pq.setDateOfReturn(rs.getDate(6));
        }
        // close connection
        return pq;
    }

    //type = 1: Insert, type = 2:Update
    public PriorityQueue save(PriorityQueue pq, int type) throws SQLException {
        if (type == 1) {
            String sql = "INSERT INTO PriorityQueue(PassengerName,Address,Phone,DateOfDeparture,DateOfReturn) VALUES(?,?,?,?,?)";
            PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
            ps.setString(1, pq.getPassengerName());
            ps.setString(2, pq.getAddress());
            ps.setString(3, pq.getPhone());
            ps.setDate(4, pq.getDateOfDeparture());
            ps.setDate(5, pq.getDateOfReturn());
            if (ps.executeUpdate() > 0) {
                return pq;
            }
            else {
                return null;
            }
        }
        else {
            String sql = "UPDATE PriorityQueue SET PassengerName = ?,Address = ?,Phone = ?,DateOfDeparture = ?,DateOfReturn=?  WHERE ReservationID = ?";
            PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
            ps.setString(1, pq.getPassengerName());
            ps.setString(2, pq.getAddress());
            ps.setString(3, pq.getPhone());
            ps.setDate(4, pq.getDateOfDeparture());
            ps.setDate(5, pq.getDateOfReturn());
            ps.setInt(6, pq.getReservationID());
            if (ps.executeUpdate() > 0) {
                return pq;
            }
            else {
                return null;
            }
        }
    }

    public boolean deleteOne(int id) throws SQLException {
        String sql = "DELETE FROM PriorityQueue WHERE ReservationID = ?";
        PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
        ps.setInt(1, id);
        if (ps.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int findByName(String name) throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from PriorityQueue WHERE  PassengerName = '" + name + "'");
        // show data
        PriorityQueue pq = new PriorityQueue();

        while (rs.next()) {
            pq.setReservationID(rs.getInt(1));
        }
        // close connection
        if (pq.getReservationID() > 0) {
            return pq.getReservationID();
        }
        else {
            return 0;
        }
    }
}
