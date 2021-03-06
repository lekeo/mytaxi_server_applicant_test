package com.mytaxi.service.driver;

import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverCarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService {

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

	private final DriverRepository driverRepository;

	@Autowired
	private CarService carService;

	@Autowired
	private DriverCarService driverCarService;

	public DefaultDriverService(final DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	/**
	 * Selects a driver by id.
	 *
	 * @param driverId
	 * @return found driver
	 * @throws EntityNotFoundException
	 *             if no driver with the given id was found.
	 */
	@Override
	public DriverDO find(Long driverId) throws EntityNotFoundException {
		return findDriverChecked(driverId);
	}

	/**
	 * Creates a new driver.
	 *
	 * @param driverDO
	 * @return
	 * @throws ConstraintsViolationException
	 *             if a driver already exists with the given username, ... .
	 */
	@Override
	public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException {
		DriverDO driver;
		try {
			driver = driverRepository.save(driverDO);
		} catch (DataIntegrityViolationException e) {
			LOG.warn("Some constraints are thrown due to driver creation", e);
			throw new ConstraintsViolationException(e.getMessage());
		}
		return driver;
	}

	/**
	 * Deletes an existing driver by id.
	 *
	 * @param driverId
	 * @throws EntityNotFoundException
	 *             if no driver with the given id was found.
	 */
	@Override
	@Transactional
	public void delete(Long driverId) throws EntityNotFoundException {
		DriverDO driverDO = findDriverChecked(driverId);
		driverDO.setDeleted(true);
	}

	/**
	 * Update the location for a driver.
	 *
	 * @param driverId
	 * @param longitude
	 * @param latitude
	 * @throws EntityNotFoundException
	 */
	@Override
	@Transactional
	public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException {
		DriverDO driverDO = findDriverChecked(driverId);
		driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
	}

	/**
	 * Find all drivers by online state.
	 *
	 * @param onlineStatus
	 */
	@Override
	public List<DriverDO> find(OnlineStatus onlineStatus) {
		return driverRepository.findByOnlineStatus(onlineStatus);
	}

	private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException {
		DriverDO driverDO = driverRepository.findOne(driverId);
		if (driverDO == null) {
			throw new EntityNotFoundException("Could not find entity with id: " + driverId);
		}
		return driverDO;
	}

	@Override
	public DriverDTO selectCarByDriver(long driverId, long carId)
			throws EntityNotFoundException, CarAlreadyInUseException {
		DriverDO driver;
		CarDO car;
		try {
			driver = findDriverChecked(driverId);
			car = carService.findCarById(carId);
			if (car != null && driver.getOnlineStatus().equals(OnlineStatus.ONLINE)) {
				DriverCarDO driverCar = new DriverCarDO();
				driverCar.setDriverId(driver.getId());
				driverCar.setCarId(car.getId());
				driverCarService.saveDriverCar(driverCar);
			} else if (null != car && OnlineStatus.OFFLINE.equals(driver.getOnlineStatus())) {
				throw new CarAlreadyInUseException("Driver is offline");
			}
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Car or Driver entity not found ");
		} catch (DataIntegrityViolationException e) {
			throw new CarAlreadyInUseException("Car is already taken by driver");
		}
		return DriverMapper.makeDriverDTO(driver, car);
	}

	@Override
	public void deSelectCarByDriver(long driverId, long carId)
			throws CarAlreadyInUseException, EntityNotFoundException {
		DriverDO driver;
		CarDO car;
		try {
			driver = findDriverChecked(driverId);
			car = carService.findCarById(carId);
			if (null != car && OnlineStatus.ONLINE.equals(driver.getOnlineStatus())) {
				DriverCarDO driverCarDO = driverCarService.findByDriverIdAndCarId(driver.getId(), car.getId());
				driverCarService.deleteDriverCar(driverCarDO);
			}
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Car or Driver entity not found ");
		} catch (InvalidDataAccessApiUsageException e) {
			throw new CarAlreadyInUseException("Car is already deselected by the driver");
		}
	}

	@Override
	public List<DriverDTO> findDriverByCarProperties(CarDTO carDTO) {
		List<DriverDTO> driverDataList = new ArrayList<>();
        List<Object[]> drivers = driverCarService.findDriverByCarProperties(carDTO);
        drivers.forEach(object -> driverDataList.add(DriverMapper.makeDriverDTO((DriverDO)object[0], (CarDO)object[1])));
        return driverDataList;
	}

}
