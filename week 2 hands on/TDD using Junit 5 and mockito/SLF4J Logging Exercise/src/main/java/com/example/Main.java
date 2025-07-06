package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting application...");

        try {
            int dummy = 10 / 0; // Will cause ArithmeticException
        } catch (ArithmeticException e) {
            logger.error("An error occurred: Division by zero", e);
        }

        logger.warn("This is a warning - disk space low!");
        logger.info("Application finished.");
    }
}