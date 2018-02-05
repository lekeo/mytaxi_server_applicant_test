package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DriverMapper
{
    public static DriverDO makeDriverDO(DriverDTO driverDTO)
    {
        return new DriverDO(driverDTO.getUsername(), driverDTO.getPassword());
    }


    public static DriverDTO makeDriverDTO(DriverDO driverDO)
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder = DriverDTO.newBuilder()
            .setId(driverDO.getId())
            .setPassword(driverDO.getPassword())
            .setUsername(driverDO.getUsername());

        GeoCoordinate coordinate = driverDO.getCoordinate();
        if (coordinate != null)
        {
            driverDTOBuilder.setCoordinate(coordinate);
        }

        return driverDTOBuilder.createDriverDTO();
    }


    public static List<DriverDTO> makeDriverDTOList(Collection<DriverDO> drivers)
    {
        return drivers.stream()
            .map(DriverMapper::makeDriverDTO)
            .collect(Collectors.toList());
    }


	public static DriverDTO makeDriverDTO(DriverDO driverDO, CarDO carDO) {
		CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
				.setId(carDO.getId())
				.setEngineType(carDO.getEngineType())
				.setRating(carDO.getRating())
				.setSeatCount(carDO.getSeatCount())
				.setConvertible(carDO.getConvertible())
				.setLicensePlate(carDO.getLicensePlate())
				.setManufacturer(ManufacturerMapper.makeManufacturerDTO(carDO.getManufacturer()));
		
        DriverDTO driverDTO = makeDriverDTO(driverDO);
        driverDTO.newBuilder().setCarDTO(carDTOBuilder.createCarDTO());
        return driverDTO;
	}
}
