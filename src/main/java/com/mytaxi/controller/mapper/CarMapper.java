package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper {

	public static CarDO makeCarDO(CarDTO carDTO) {
		return new CarDO(carDTO.getRating(), carDTO.getEngineType(), carDTO.getSeatCount(), carDTO.getConvertible(),
				carDTO.getLicensePlate(), ManufacturerMapper.makeManufacturerDO(carDTO.getManufacturer()));
	}

	public static CarDTO makeCarDTO(CarDO carDO) {
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder().setId(carDO.getId())
				.setEngineType(carDO.getEngineType()).setRating(carDO.getRating()).setSeatCount(carDO.getSeatCount())
				.setConvertible(carDO.getConvertible()).setLicensePlate(carDO.getLicensePlate())
				.setManufacturer(ManufacturerMapper.makeManufacturerDTO(carDO.getManufacturer()));

		return carDTOBuilder.createCarDTO();

	}

	public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars) {
		return cars.stream().map(CarMapper::makeCarDTO).collect(Collectors.toList());
	}

	public static CarDTO makeCarDTOFromMap(Map<String, String> params) {
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder().setSeatCount(Integer.parseInt(params.get("seatCount")))
				.setEngineType(params.get("engineType")).setConvertible(Boolean.getBoolean(params.get("convertible")));
		return carDTOBuilder.createCarDTO();
	}
}
