package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.UsageStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService {

	CarDO findCarById(Long carId) throws EntityNotFoundException;

	CarDO createNewCar(CarDO carDO) throws ConstraintsViolationException;

	List<CarDO> findCarByUsageStatus(UsageStatus usageStatus);

	void updateCarById(long carId, CarDTO givenCarDTO) throws EntityNotFoundException;

	void deleteCarById(long carId) throws EntityNotFoundException;

}
