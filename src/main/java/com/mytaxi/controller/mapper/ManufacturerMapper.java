package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.ManufacturerDTO;
import com.mytaxi.domainobject.ManufacturerDO;

public class ManufacturerMapper {

	public static ManufacturerDO makeManufacturerDO(ManufacturerDTO manufacturerDTO) {
		return new ManufacturerDO(manufacturerDTO.getId(), manufacturerDTO.getManufacturerName());
	}
	
	public static ManufacturerDTO makeManufacturerDTO(ManufacturerDO manufacturerDO) {
		ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
		manufacturerDTO.setManufacturerName(manufacturerDO.getManufacturerName());
		manufacturerDTO.setId(manufacturerDO.getId());
		
		return manufacturerDTO;
	}
	
}
