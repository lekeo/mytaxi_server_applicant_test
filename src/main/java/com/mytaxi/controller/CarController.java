package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.UsageStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.driver.CarService;

/**
 * All operations with a car will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/cars")
public class CarController {

	private final CarService carService;
	
    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }

    @GetMapping("/{carId}")
    public CarDTO getCar(@Valid @PathVariable long carId) throws EntityNotFoundException
    {
    	return CarMapper.makeCarDTO(carService.findCarById(carId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException
    {
    	CarDO carDO = CarMapper.makeCarDO(carDTO);
    	return CarMapper.makeCarDTO(carService.createNewCar(carDO));
    }
    
    @GetMapping
    public List<CarDTO> findAllCars(@RequestParam UsageStatus usageStatus) {
    	return CarMapper.makeCarDTOList(carService.findCarByUsageStatus(usageStatus));
    }
    
    @PutMapping("/{carId}")
    public void updateCarById(@Valid @PathVariable long carId, @Valid @RequestBody CarDTO givenCarDTO) throws EntityNotFoundException {
    	carService.updateCarById(carId, givenCarDTO);
    }
    
    @DeleteMapping("/{carId}")
    public void deleteCarById(@Valid @PathVariable long carId) throws EntityNotFoundException {
    	carService.deleteCarById(carId);
    }
    
    
    
}
