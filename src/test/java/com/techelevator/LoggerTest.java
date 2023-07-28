package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    Logger logger;
    File file;

    @Before
    public void setup(){
        file = new File("testlog.txt");
        try {
            logger = new Logger("testlog.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File cannot be created");
        }
    }

    @Test
    public void can_write_to_log(){
        logger.write("Test");
        assertTrue(file.exists());
        assertNotNull("testlog.txt");
    }

}
