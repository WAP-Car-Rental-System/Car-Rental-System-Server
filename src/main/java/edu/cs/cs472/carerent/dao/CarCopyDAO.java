package edu.cs.cs472.carerent.dao;

import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarCopy;
import edu.cs.cs472.carerent.model.CarRental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarCopyDAO {

    public void  saveData(CarCopy carCopy) {
        //String tableName = car.getClass().getSimpleName();
        //System.out.println("Table Name =" +tableName);


        try {
            Connection conn = DbConnection.getConnection();
            //conn = DriverManager.getConnection(url,user,pass);
            //String sql = "INSERT INTO car(brand, model, production_year, mileage,color,transmission) VALUES (?, ?, ?, ?,?,?)";
            String sql = "insert into car_copy(quantity, carid_fk, plate_number, rent_price) values (?,?,?,?)";
            Integer quantity = carCopy.getQuantity();
            Integer carId = carCopy.getCarId();
            String plateNumber = carCopy.getPlateNumber();
            Integer price = carCopy.getRentPrice();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, carId);
            statement.setInt(2, quantity);
            statement.setInt(3, price);
            statement.setString(4, plateNumber);
            statement.executeUpdate();
            //statement.close();
            //conn.close();

            /*System.out.println("Inserted Row" +rowsInserted);
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }*/
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Data Successfully saved!");
        }

    }


    public List<CarCopy> fetchCarCopies() {
        List<CarCopy> carCopyList = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        Statement myState = null;
        try {
            myState = conn.createStatement();
            String sql = "select * from car_copy INNER JOIN  car on car.carid= car_copy.carid_fk ";
            ResultSet rs = myState.executeQuery(sql);
            while (rs.next()) {
                CarCopy carCopies = new CarCopy();

                carCopies.setQuantity(rs.getInt("quantity"));

                carCopies.setCarCopyId(rs.getInt("car_copy_id"));
                carCopies.setPlateNumber(rs.getString("plate_number"));
                carCopies.setRentPrice(rs.getInt("rent_price"));

                Integer carId = rs.getInt("carid");
                String sql2 = "select * from car where carid = "+ carId;

                carCopyList.add(carCopies);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carCopyList;
    }

    public static void main(String[] args) {
        CarCopyDAO carCopyDAO = new CarCopyDAO();
        Connection conn = DbConnection.getConnection();
        Statement myState = null;
        try {
            myState = conn.createStatement();
            String sql = "select * from mycarrent.car_copy ";
            ResultSet rs = myState.executeQuery(sql);
            while (rs.next()) {
                CarCopy carCopies = new CarCopy();

               // carCopies.setQuantity(rs.getInt(""));

                //carCopies.setQuantity(rs.getInt("model"));
//                System.out.println(rs.getInt("model"));
//                carCopies.setCarCopyId(rs.getInt("car_copy_id"));
//                carCopies.setPlateNumber(rs.getString("plate_number"));
//                carCopies.setRentPrice(rs.getInt("rent_price"));
//
//                // carCopyList.add(carCopies);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
