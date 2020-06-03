package edu.cs.cs472.carerent.dao;

import edu.cs.cs472.carerent.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mycarrent","root","root1234");
        }catch(Exception e){System.out.println(e);}
        return conn;
    }

    public List<Car> fetchCars() {
        List<Car> cars = new ArrayList<>();
        Connection conn = getConnection();
        Statement myState = null;
        try {
            myState = conn.createStatement();
            String sql = "select * from mycarrent.car";
            ResultSet rs = myState.executeQuery(sql);
            while (rs.next()){
                Car newCar = new Car();
                newCar.setCarId(rs.getInt("carid"));
                newCar.setMileage(rs.getInt("mileage"));
                newCar.setCarBrand(rs.getString("brand"));
                newCar.setCarModel(rs.getString("model"));
                newCar.setCarProductionYear(rs.getInt("production_year"));
                newCar.setCarColor(rs.getString("color"));
                newCar.setTransmission(rs.getString("transmission"));
                cars.add(newCar);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void  saveData(Car car) {

        try {
            Connection conn = getConnection();
            //conn = DriverManager.getConnection(url,user,pass);
            //String sql = "INSERT INTO car(brand, model, production_year, mileage,color,transmission) VALUES (?, ?, ?, ?,?,?)";
            String sql = "insert into car(brand, model, production_year, mileage,color,transmission) values (?,?,?,?,?,?)";
            String model = car.getCarModel();
            String brand = car.getCarBrand();
            Integer production_year = car.getCarProductionYear();
            Integer mileage = car.getMileage();
            String color = car.getCarColor();
            String trans = car.getTransmission();

            System.out.println(car.getMileage());
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, brand);
            statement.setString(2, model);
            statement.setInt(3, production_year);
            statement.setInt(4, mileage);
            statement.setString(5,color);
            statement.setString(6,trans);
            statement.executeUpdate();
            //statement.close();
            //conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Data Successfully saved!");
        }

    }
}
