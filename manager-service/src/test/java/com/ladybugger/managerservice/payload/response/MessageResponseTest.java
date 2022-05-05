/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class MessageResponseTest {
    
    private MessageResponse message;
    
    public MessageResponseTest() {
    }
    
    @BeforeEach
    public void setUp() {
        message = new MessageResponse(null);
    }

    /**
     * Test of getMessage method, of class MessageResponse.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        MessageResponse instance = message;
        String expResult = "message";
        instance.setMessage(expResult);
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }
    
}
