package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper {

	public static CarDO makeCarDO(CarDTO carDTO) {
		return new CarDO(carDTO.getRating(), carDTO.getEngineType(), carDTO.getSeatCount(), carDTO.getConvertible(), carDTO.getLicensePlate(), ManufacturerMapper.makeManufacturerDO(carDTO.getManufacturer()));
	}
	
	public static CarDTO makeCarDTO(CarDO carDO) {
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
				.setId(carDO.getId())
				.setEngineType(carDO.getEngineType())
				.setRating(carDO.getRating())
				.setSeatCount(carDO.getSeatCount())
				.setConvertible(carDO.getConvertible())
				.setLicensePlate(carDO.getLicensePlate())
				.setManufacturer(ManufacturerMapper.makeManufacturerDTO(carDO.getManufacturer()));
		
		return carDTOBuilder.createCarDTO();
		
	}

	public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars) {
		return cars.stream().map(CarMapper::makeCarDTO).collect(Collectors.toList());
	}
	
}
