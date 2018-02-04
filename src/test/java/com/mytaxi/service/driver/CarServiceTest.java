package com.mytaxi.service.driver;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mytaxi.AbstractMytaxiServerApplicationTest;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.EntityNotFoundException;

public class CarServiceTest extends AbstractMytaxiServerApplicationTest {

	@Mock
	private CarService carService;

	@InjectMocks
	private DefaultCarService defaultCarService;

	@BeforeClass
	public static void setUp() {
		MockitoAnnotations.initMocks(DefaultCarService.class);
	}

	@Test
	public void testFindCarById() throws EntityNotFoundException {
		CarDO car = getCar();
		when(carService.findCarById(any(Long.class))).thenReturn(car);
		defaultCarService.findCarById(any(Long.class));
		verify(carService, times(1)).findCarById(any(Long.class));
	}

}
