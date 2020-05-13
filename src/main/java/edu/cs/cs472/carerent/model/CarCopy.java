package edu.cs.cs472.carerent.model;

import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class CarCopy {
    private  Integer carCopyId ;
    private Integer quantity;
    private boolean available;
    private String plateNumber;
    private Integer rentPrice;
    private Integer carId;

    public CarCopy(Integer quantity, boolean available, String plateNumber, Integer rentPrice, Integer carId) {
        this.quantity = quantity;
        this.available = available;
        this.plateNumber = plateNumber;
        this.rentPrice = rentPrice;
        this.carId = carId;
    }
 public CarCopy(){this(0,false,null,0,null);}

    public Integer getQuantity() {
        return quantity;
    }

    public void setCarCopyId(Integer carCopyId) {
        this.carCopyId = carCopyId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPlateNumber() {
        return plateNumber;
    }


    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getCarCopyId() {
        return carCopyId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String toString(){
        return new StringJoiner(",",Car.class.getSimpleName()+ "[", "]")
                .add("quantity='" + quantity)
                .add("available='" + available + "'")
                .add("carProductionYear='" + plateNumber +"'")
                .add("carId='" + carId +"'")
                .add("rentPrice='" + rentPrice)
                .toString();
    }
}
