/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.userservice.service;

import com.ladybugger.userservice.entity.User;
import com.ladybugger.userservice.feignclients.BikeFeignClient;
import com.ladybugger.userservice.feignclients.CarFeignClient;
import com.ladybugger.userservice.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author mario
 */
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userServiceImp;
    
    @Mock
    private RestTemplate restTemplate;
    
    @Mock
    private CarFeignClient carFeignClient;
    
    @Mock
    private BikeFeignClient bikeFeignClient;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getAll method, of class UserService.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List<User> expResult = new ArrayList<>();
        expResult.add(new User());
        Mockito.when(
                userRepository.findAll()
        ).thenReturn(expResult);
        assertEquals(userServiceImp.getAll(), expResult);
    }

    /**
     * Test of getUserById method, of class UserService.
     */
    @Test
    public void testGetUserById() {
        /*System.out.println("getUserById");
        int id = 0;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {
        /*System.out.println("save");
        User user = null;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.save(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getCars method, of class UserService.
     */
    @Test
    public void testGetCars() {
        /*System.out.println("getCars");
        int userId = 0;
        UserService instance = new UserService();
        List<Car> expResult = null;
        List<Car> result = instance.getCars(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getBikes method, of class UserService.
     */
    @Test
    public void testGetBikes() {
        /*System.out.println("getBikes");
        int userId = 0;
        UserService instance = new UserService();
        List<Bike> expResult = null;
        List<Bike> result = instance.getBikes(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of saveCar method, of class UserService.
     */
    @Test
    public void testSaveCar() {
        /*System.out.println("saveCar");
        int userId = 0;
        Car car = null;
        UserService instance = new UserService();
        Car expResult = null;
        Car result = instance.saveCar(userId, car);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of saveBike method, of class UserService.
     */
    @Test
    public void testSaveBike() {
        /*System.out.println("saveBike");
        int userId = 0;
        Bike bike = null;
        UserService instance = new UserService();
        Bike expResult = null;
        Bike result = instance.saveBike(userId, bike);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getUserAndVehicles method, of class UserService.
     */
    @Test
    public void testGetUserAndVehicles() {
        /*System.out.println("getUserAndVehicles");
        int userId = 0;
        UserService instance = new UserService();
        Map<String, Object> expResult = null;
        Map<String, Object> result = instance.getUserAndVehicles(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
