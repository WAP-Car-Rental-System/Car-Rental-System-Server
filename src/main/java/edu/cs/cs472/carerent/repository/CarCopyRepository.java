package edu.cs.cs472.carerent.repository;

import edu.cs.cs472.carerent.dao.CarCopyDAO;
import edu.cs.cs472.carerent.dao.DbConnection;
import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarCopy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarCopyRepository {

    private CarCopyDAO carCopyDAO = new CarCopyDAO();
    private List<CarCopy> carCopyList;

    public CarCopyRepository(List<CarCopy> carCopyList){
              this.carCopyList = carCopyList;}

    public List<CarCopy> getCarList() {
        return carCopyDAO.fetchCarCopies();
        //return carCopyList;
    }

    public CarCopy addNewCarCopy(CarCopy newCarCopy){
        carCopyDAO.saveData(newCarCopy);
        //carCopyList.add(newCarCopy);
        return newCarCopy;
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
                System.out.println(carCopies);
                carCopyList.add(carCopies);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carCopyList;
    }
}
