package com.mytaxi;

import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.ManufacturerDO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MytaxiServerApplicantTestApplication.class)
public class MytaxiServerApplicantTestApplicationTests
{

    @Test
    public void contextLoads()
    {
    }
    
    @Test
    public void getCar()
    {
    	CarDO car = new CarDO();
        car.setId(1L);
        car.setSeatCount(2);
        car.setRating(11.0F);
        car.setDateCreated(ZonedDateTime.now());
        car.setLicensePlate("ABV101");
        car.setEngineType("test");
        car.setConvertible(true);
        ManufacturerDO manufacturer = new ManufacturerDO();
        manufacturer.setManufacturerName("Audi");
        manufacturer.setId(1L);
        manufacturer.setDateCreated(ZonedDateTime.now());
        car.setManufacturer(manufacturer);
    }
    
    
    
    
}
