package edu.cs.cs472.carerent.controller;

import edu.cs.cs472.carerent.model.Car;
import edu.cs.cs472.carerent.model.CarCopy;
import edu.cs.cs472.carerent.model.CarRental;
import edu.cs.cs472.carerent.repository.CarRepository;
import edu.cs.cs472.carerent.service.CarRentService;
import edu.cs.cs472.carerent.service.CarService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "CarRentController", urlPatterns = {"/rent/list", "/rent/carRent"})
public class CarRentController extends HttpServlet {
    private CarRentService carRentService;
    private CarService carService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carJSONData = carRentService.getAllRegisteredCarCopyJSON();
       // String carJSONData = carService.getAllRegisteredCarsJSON();
        System.out.println(carJSONData);
        setAccessControlHeaders(response);
        response.setContentType("application/json");
        response.setBufferSize(4096);
        response.getWriter().println(carJSONData);
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
        List<CarRental> cars = List.of(
                new CarRental(new Date(),new Date(),new CarCopy()),
                new CarRental(new Date(), new Date(), new CarCopy()));

        ServletContext servletContext = config.getServletContext();
        if(servletContext.getAttribute("carCopyList") == null) {
            List<CarRental> dataStore = new Vector<>();
            this.carRentService = new CarRentService(dataStore);
            servletContext.setAttribute("carCopyList", dataStore);
        }
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
