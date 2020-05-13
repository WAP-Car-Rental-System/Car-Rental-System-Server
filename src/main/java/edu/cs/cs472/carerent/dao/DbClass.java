package edu.cs.cs472.carerent.dao;

import edu.cs.cs472.carerent.model.Car;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;

public class DbClass {

    //public static final String url = "jdbc:mysql://localhost:3306/mycarrent?autoReconnect=true&useSSL=false";
   // public static final String url = "jdbc:mysql://localhost:3306/mycarrent";
    //public static final String user = "root";
    //public static final String pass="root1234";
    //public static  Connection conn = null;

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mycarrent","root","root1234");
        }catch(Exception e){System.out.println(e);}
        return conn;
    }
    public void  saveData(Car car) {
        //String tableName = car.getClass().getSimpleName();
        //System.out.println("Table Name =" +tableName);


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

//    public static Connection myConnection() throws SQLException {
//            //Connection conn = DriverManager.getConnection(url,user,pass);
//            //Statement myState = conn.createStatement();
//            //String sql = "select * from mycarrent.car";
//            //ResultSet rs = myState.executeQuery(sql);
//            return conn;
//    }
    public static void main(String[] args){
        try {
           // Connection conn = DriverManager.getConnection(url,user,pass);
            Connection conn = getConnection();
            Statement myState = conn.createStatement();
            String sql = "select * from mycarrent.car";
            ResultSet rs = myState.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("carid"));
                System.out.println(rs.getString("brand"));
                System.out.println(rs.getString("model"));
            }

            //Connection conn = DriverManager.getConnection(url,user,pass);
            //String sql = "INSERT INTO car(brand, model, production_year, mileage,color,transmission) VALUES (?, ?, ?, ?,?,?)";
            String sql2 = "INSERT INTO car(brand, model, production_year, mileage,color,transmission) values (?,?,?,?,?,?)";
            //String sql2 ="select * from car";
            PreparedStatement statement = conn.prepareStatement(sql2);
            statement.setString(1, "Ford");
            statement.setString(2, "Ford-XX");
            statement.setInt(3, 2010);
            statement.setInt(4, 1000);
            statement.setString(5,"White");
            statement.setString(6,"Automatic");

            int rowsInserted = statement.executeUpdate();
            System.out.println("Inserted Row" +rowsInserted);
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
