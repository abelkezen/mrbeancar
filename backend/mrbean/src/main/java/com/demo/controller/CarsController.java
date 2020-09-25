package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.CarDAO;
import com.demo.entity.Car;

@CrossOrigin(origins = "*")
@RestController
public class CarsController {
	
	@Autowired
	private CarDAO carDAO;
	
	@GetMapping(value = "/getcars")
	public ResponseEntity<Object> getcars() {
		List<Car> data= carDAO.findCars();
		return new ResponseEntity<>(data,HttpStatus.OK);  	
    }
	
	@PostMapping(value = "/addcar")
	public ResponseEntity<Object> insercar(@RequestBody Car body) {
		
		return new ResponseEntity<>(carDAO.addCar(body),HttpStatus.OK);  	
    }
	
	@PostMapping(value = "/updatecar")
	public ResponseEntity<Object> updatecar(@RequestBody Car body) {
		
		carDAO.update(body);
		
		return new ResponseEntity<>("ok",HttpStatus.OK);  	
    }
	
	@PostMapping(value = "/deletecar/{uid}")
	public ResponseEntity<Object> deletecar(@PathVariable("uid") String uid) {	
		
		return new ResponseEntity<>(carDAO.deletecar(uid),HttpStatus.OK);  	
    }
	
	@PostMapping(value = "/getcarfilter/{max}/{min}")
	public ResponseEntity<Object> filterprice(@PathVariable("max") Long max,@PathVariable("min") Long min) {	
		List<Car> data= carDAO.findCarsfilter(max, min);
		return new ResponseEntity<>(data,HttpStatus.OK);  	
    }
	
	

}
