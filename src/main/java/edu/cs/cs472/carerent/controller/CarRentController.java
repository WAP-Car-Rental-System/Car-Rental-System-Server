package edu.cs.cs472.carerent.controller;

<<<<<<< HEAD
import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarCopy;
import edu.cs.cs472.carerent.model.CarRental;
import edu.cs.cs472.carerent.repository.CarRepository;
import edu.cs.cs472.carerent.service.CarRentService;
import edu.cs.cs472.carerent.service.CarService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
=======
import edu.cs.cs472.carerent.service.CarRentService;

import javax.servlet.ServletConfig;
>>>>>>> 8260399802235a74bc29d587d928d45a8c78bda9
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

<<<<<<< HEAD
@WebServlet(name = "CarRentController", urlPatterns = {"/rent/list", "/rent/carRent"})
public class CarRentController extends HttpServlet {
    private CarRentService carRentService;
    private CarService carService;
=======
@WebServlet(name = "CarRentController", urlPatterns = {"/car/rent", "/carRent"})
public class CarRentController extends HttpServlet {
    private CarRentService carRentService;
>>>>>>> 8260399802235a74bc29d587d928d45a8c78bda9
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carJSONData = carRentService.getAllRegisteredCarCopyJSON();
<<<<<<< HEAD
       // String carJSONData = carService.getAllRegisteredCarsJSON();
=======
>>>>>>> 8260399802235a74bc29d587d928d45a8c78bda9
        System.out.println(carJSONData);
        setAccessControlHeaders(response);
        response.setContentType("application/json");
        response.setBufferSize(4096);
<<<<<<< HEAD
        response.getWriter().println(carJSONData);
=======
       // response.getWriter().println(carJSONData);
>>>>>>> 8260399802235a74bc29d587d928d45a8c78bda9
    }
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
<<<<<<< HEAD
        List<CarRental> cars = List.of(
                new CarRental(new Date(),new Date(),new CarCopy()),
                new CarRental(new Date(), new Date(), new CarCopy()));

        ServletContext servletContext = config.getServletContext();
        if(servletContext.getAttribute("carCopyList") == null) {
            List<CarRental> dataStore = new Vector<>();
            this.carRentService = new CarRentService(dataStore);
            servletContext.setAttribute("carCopyList", dataStore);
        }
=======
>>>>>>> 8260399802235a74bc29d587d928d45a8c78bda9
    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5502");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5500");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST");
    }
}
