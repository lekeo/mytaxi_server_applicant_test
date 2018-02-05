package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.DriverCarDO;

public interface DriverCarRepository extends CrudRepository<DriverCarDO, Long> {

	DriverCarDO findByDriverIdAndCarId(Long driverId, Long carId);

	@Query("SELECT D, C FROM CarDO C, DriverDO D, DriverCarDO DC WHERE DC.carId = C.id AND D.id = DC.driverId "
			+ "AND (C.convertible = :#{#carDto.convertible} OR C.seatCount = :#{#carDto.seatCount} "
			+ "OR C.engineType = :#{#carDto.engineType})")
	List<Object[]> findDriverByCarProperties(@Param("carDto") CarDTO carDTO);

}
