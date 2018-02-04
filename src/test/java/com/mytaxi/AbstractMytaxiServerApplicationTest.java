package com.mytaxi;

import java.time.ZonedDateTime;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.mytaxi.controller.mapper.ManufacturerMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverCarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainobject.ManufacturerDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractMytaxiServerApplicationTest {

	public CarDO getCar() {
		CarDO car = new CarDO();
        car.setId(1L);
        car.setSeatCount(2);
        car.setRating(11.0F);
        car.setDateCreated(ZonedDateTime.now());
        car.setLicensePlate("1q2w3e");
        car.setEngineType("Gas");
        car.setConvertible(true);
        ManufacturerDO manufacturer = new ManufacturerDO();
        manufacturer.setManufacturerName("Mercedes");
        manufacturer.setId(1L);
        manufacturer.setDateCreated(ZonedDateTime.now());
        car.setManufacturer(manufacturer);
		return car;
	}

	public ManufacturerDO getManufacturer() {
		ManufacturerDO manufacturer = new ManufacturerDO();
		manufacturer.setDateCreated(ZonedDateTime.now());
		manufacturer.setId(1L);
		manufacturer.setManufacturerName("Mercedes");
		return manufacturer;
	}

	public CarDTO getCarDTO() {
		ManufacturerDO manufacturerDO = new ManufacturerDO(1L, "Mercedes");
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
				.setId(1L)
				.setEngineType("Gas")
				.setRating(11.0F)
				.setSeatCount(2)
				.setConvertible(true)
				.setLicensePlate("1q2w3e")
				.setManufacturer(ManufacturerMapper.makeManufacturerDTO(manufacturerDO));
		
		return carDTOBuilder.createCarDTO();
	}

	public DriverDO getDriver() {
		DriverDO driver = new DriverDO("driver01", "driver01pw");
		driver.setId(1L);
		GeoCoordinate geoCoordinate = new GeoCoordinate(90, 90);
		driver.setCoordinate(geoCoordinate);
		return driver;
	}

	public DriverDTO getDriverDTO() {
		GeoCoordinate geoCoordinate = new GeoCoordinate(90, 90);
		DriverDTO.DriverDTOBuilder driverDTOBuilder = DriverDTO.newBuilder()
		            .setId(getDriver().getId())
		            .setPassword(getDriver().getPassword())
		            .setUsername(getDriver().getUsername())
		            .setCoordinate(geoCoordinate);
		
		return driverDTOBuilder.createDriverDTO();
	}

	public DriverCarDO getDriverCar() {
		DriverCarDO driverCar = new DriverCarDO();
		driverCar.setCarId(1L);
		driverCar.setDriverId(1L);
		driverCar.setCarId(1L);
		return driverCar;
	}
}
