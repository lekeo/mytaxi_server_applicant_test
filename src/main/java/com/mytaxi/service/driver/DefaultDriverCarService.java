package com.mytaxi.service.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytaxi.dataaccessobject.DriverCarRepository;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.DriverCarDO;

@Service
public class DefaultDriverCarService implements DriverCarService {

	@Autowired
    private DriverCarRepository driverCarRepository;
	
	@Override
	public DriverCarDO saveDriverCar(DriverCarDO driverCar) {
		return driverCarRepository.save(driverCar);
	}

	@Override
	public DriverCarDO findByDriverIdAndCarId(Long driverId, Long carId) {
		return driverCarRepository.findByDriverIdAndCarId(driverId, carId);
	}

	@Override
	public void deleteDriverCar(DriverCarDO driverCarDO) {
		driverCarRepository.delete(driverCarDO);
	}

	@Override
	public List<Object[]> findDriverByCarProperties(CarDTO carDTO) {
		return driverCarRepository.findDriverByCarProperties(carDTO);
	}

}
