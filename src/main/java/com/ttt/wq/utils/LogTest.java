package com.ttt.wq.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.error("Hello error");
        logger.info("Hello info");
        LogHelper.getLogger().warn("Hello warn");
    }
}
