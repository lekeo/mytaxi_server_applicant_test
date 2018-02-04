package com.mytaxi.service.driver;

import org.slf4j.LoggerFactory;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.EntityNotFoundException;

public class DefaultCarService implements CarService {
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(DefaultDriverService.class);

	private final CarRepository carRepository;
	
	public DefaultCarService(final CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	public CarDO findCarById(Long carId) throws EntityNotFoundException {
		CarDO carDO = carRepository.findOne(carId);
		if(carDO == null)
			throw new EntityNotFoundException("Could not find entity with id: " + carId);
		return carDO;
	}

}
