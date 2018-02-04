package com.mytaxi.service.driver;

import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.controller.mapper.ManufacturerMapper;
import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.UsageStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

@Service
public class DefaultCarService implements CarService {
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(DefaultCarService.class);

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

	@Override
	public CarDO createNewCar(CarDO carDO) throws ConstraintsViolationException {
		CarDO car;
		try {
			car = carRepository.save(carDO);
		} catch (DataIntegrityViolationException e) {
			log.warn("Some constraints are thrown due to driver creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
		
		return car;
	}

	@Override
	public List<CarDO> findCarByUsageStatus(UsageStatus usageStatus) {
		return carRepository.findCarByUsageStatus(usageStatus);
	}

	@Override
	@Transactional
	public void updateCarById(long carId, CarDTO givenCarDTO) throws EntityNotFoundException {
		CarDO carDO = findCarById(carId);
		carDO.setConvertible(givenCarDTO.getConvertible());
		carDO.setDateUpdated(ZonedDateTime.now());
		carDO.setEngineType(givenCarDTO.getEngineType());
		carDO.setLicensePlate(givenCarDTO.getLicensePlate());
		carDO.setManufacturer(ManufacturerMapper.makeManufacturerDO(givenCarDTO.getManufacturer()));
		carDO.setRating(givenCarDTO.getRating());
		carDO.setSeatCount(givenCarDTO.getSeatCount());
		carDO.setUsageStatus(givenCarDTO.getUsageStatus());
	}

	@Override
	@Transactional
	public void deleteCarById(long carId) throws EntityNotFoundException {
		CarDO carDO = findCarById(carId);
		carDO.setDeleted(true);
	}

}
