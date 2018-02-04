package com.mytaxi.service.driver;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService {

	CarDO findCarById(Long carId) throws EntityNotFoundException;

}
