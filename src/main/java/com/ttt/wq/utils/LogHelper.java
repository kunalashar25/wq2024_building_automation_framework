package com.ttt.wq.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LogHelper {

    public static Logger getLogger() {
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(callingClassName);
    }

    public static synchronized void testLogger(String testName) {
        ThreadContext.put("logFilename", testName);
    }
}