package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper {

	public static CarDO makeCarDO(CarDTO carDTO) {
		return new CarDO(carDTO.getRating(), carDTO.getEngineType(), carDTO.getSeatCount(), carDTO.getConvertible(), carDTO.getLicensePlate(), carDTO.getManufacturer());
	}
	
	public static CarDTO makaCarDTO(CarDO carDO) {
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
				.setId(carDO.getId())
				.setEngineType(carDO.getEngineType())
				.setRating(carDO.getRating())
				.setSeatCount(carDO.getSeatCount())
				.setConvertible(carDO.getConvertible())
				.setLicensePlate(carDO.getLicensePlate())
				.setManufacturer(carDO.getManufacturer());
		
		return carDTOBuilder.createCarDTO();
		
	}
	
}
