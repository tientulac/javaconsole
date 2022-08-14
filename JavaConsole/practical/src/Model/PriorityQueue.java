package Model;

import java.sql.Date;

public class PriorityQueue {
    private int ReservationID;
    private String PassengerName;
    private String Address;
    private String Phone;
    private Date DateOfDeparture;
    private Date DateOfReturn;

    public PriorityQueue(int reservationID, String passengerName, String address, String phone, Date dateOfDeparture, Date dateOfReturn) {
        ReservationID = reservationID;
        PassengerName = passengerName;
        Address = address;
        Phone = phone;
        DateOfDeparture = dateOfDeparture;
        DateOfReturn = dateOfReturn;
    }

    public PriorityQueue() {
    }

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getDateOfDeparture() {
        return DateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        DateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfReturn() {
        return DateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        DateOfReturn = dateOfReturn;
    }
}
