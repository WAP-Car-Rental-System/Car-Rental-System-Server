package edu.cs.cs472.carerent.dao;

import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarRental;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRentDAO {


    public List<CarRental> fetchRentalCars() {
        List<CarRental> carsRented = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        Statement myState = null;
        try {
            myState = conn.createStatement();
            String sql = "select * from mycarrent.car_rental INNER JOIN mycarrent.car_copy on car_copy.id = car_rental_id";
            ResultSet rs = myState.executeQuery(sql);
            while (rs.next()){
                CarRental carRental = new CarRental();

                carRental.getCarRentalID(rs.getInt("car_rental_id"));
                carRental.setPickUpDate(rs.getDate("pickup_date"));
                carRental.setReturnDate(rs.getDate("dropOff_date"));
                Integer carCopyId = rs.getInt("car_copy_id");
                String sql2 = "select * from car where car_copy_id = "+ carCopyId;

                carsRented.add(carRental);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carsRented;
    }

}
