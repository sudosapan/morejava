package com.sapan.logback.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

public class LoggerProducer {
    private static final Logger logger = LoggerFactory.getLogger(LoggerProducer.class);
    public static AtomicBoolean stop = new AtomicBoolean(false);

    public static void main(String[] args) {
        //Just keep emitting logs
        while (!stop.get()) {
            logger.debug("This is a dummy log");
        }
    }

}
