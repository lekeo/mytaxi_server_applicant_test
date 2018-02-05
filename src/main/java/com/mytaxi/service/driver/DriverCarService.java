package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.DriverCarDO;

public interface DriverCarService {

	DriverCarDO  saveDriverCar(DriverCarDO driverCar);
	
	DriverCarDO findByDriverIdAndCarId(Long driverId, Long carId);
	
	void deleteDriverCar(DriverCarDO driverCarDO);

	List<Object[]> findDriverByCarProperties(CarDTO carDTO);
}
