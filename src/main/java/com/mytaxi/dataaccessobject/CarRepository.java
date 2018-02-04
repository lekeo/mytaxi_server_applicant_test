package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.UsageStatus;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarDO, Long> {

	List<CarDO> findCarByUsageStatus(UsageStatus usageStatus);
	
}
