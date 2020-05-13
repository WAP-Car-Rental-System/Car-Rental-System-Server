package edu.cs.cs472.carerent.service;


import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarCopy;
import edu.cs.cs472.carerent.repository.CarCopyRepository;
import edu.cs.cs472.carerent.repository.CarRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CarRentService {
    private CarCopyRepository carCopRepository;
    private CarRepository carRepository;

    public CarRentService(CarCopyRepository carCopRepository, CarRepository carRepository) {
        this.carCopRepository = carCopRepository;
        this.carRepository = carRepository;
    }



    public String getAllRegisteredCarCopyJSON() {

        List<CarCopy> carCopies = this.carCopRepository.getCarList();
        int count=0;
        StringBuffer sb= new StringBuffer();
        for (CarCopy carCopy : carCopies) {
            if (carCopy.isAvailable()) {
                Integer carId;    carId = carCopy.getCarCopyId();
                Car car = carRepository.getCarBId(carId);
              //  carsToBeRented.put(carCopy.getRentPrice(), car);
                sb.append("{");
                sb.append(String.format("\"carBrand\": %s, ", car.getCarBrand()));
                sb.append(String.format("\"carModel\": %s, ", car.getCarModel()));
                sb.append(String.format("\"carProductionYear\": \"%d\", \"mileage\": \"%d\",  ",
                        car.getCarProductionYear(), car.getMileage()));
                sb.append(String.format("\"carColor\": %s, ", car.getCarColor()));
                sb.append(String.format("\"transmission\": %d, ", car.getTransmission()));
                sb.append(String.format("\"rentPrice\": %.2f, ", carCopy.getRentPrice()));
                sb.append("}");
                if(++count != carCopies.size()) {
                    sb.append(", ");
                }
            }

        }
        sb.append("]");
        return sb.toString();
    }


}
