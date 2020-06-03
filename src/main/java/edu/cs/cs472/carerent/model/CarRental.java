package edu.cs.cs472.carerent.model;

import java.sql.Date;

import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRental {
    private static final AtomicInteger carRentId = new AtomicInteger(0);
    private Integer carRentalID;
    private Date pickUpDate;
    private Date returnDate;
    private CarCopy carCopy;

    public CarRental( Date pickUpDate, Date returnDate, CarCopy carCopy) {
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.carCopy = carCopy;
//        this.carRentalID = carRentalID;
    }

    public CarRental(){this(null,null,null);}

    public CarRental(java.util.Date date, java.util.Date date1, CarCopy carCopy) {
    }

    public Integer getCarRentalID(int car_rental_id) {
        return carRentalID;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public CarCopy getCarCopy() {
        return carCopy;
    }

    public String toString(){
        return new StringJoiner(",",Car.class.getSimpleName()+ "[", "]")
                .add("quantity='" + pickUpDate + "'")
                .add("available='" + returnDate + "'")
                .add("carCopyId='" + carCopy.getCarCopyId())
                .toString();
    }
}
