package com.mytaxi.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytaxi.AbstractMytaxiServerApplicationTest;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.service.driver.CarService;

public class CarControllerTest extends AbstractMytaxiServerApplicationTest {
	private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CarController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(carController).dispatchOptions(true).build();
    }


    @Test
    public void testGetCar() throws Exception
    {
        CarDTO carData = getCarDTO();
        doReturn(carData).when(carService).findCarById(1L);
        carController.getCar(1L);
        MvcResult result = mvc
            .perform(get("/v1/cars/1"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("1q2w3e"));
    }
}
