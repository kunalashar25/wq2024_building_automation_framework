package com.ttt.wq.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LogHelper {

    public static Logger getLogger() {
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(callingClassName);
    }

    public static synchronized void testLogger(String testName) {
        String pattern = "[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} %c{1}:%L - %msg%n";
        String filename = "output/logs/tests/" + testName + ".log";

        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.setStatusLevel(Level.INFO);
        builder.setConfigurationName("testLogger");

        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout").addAttribute("pattern", pattern);

        AppenderComponentBuilder appenderBuilder = builder.newAppender("LogToFile", "File")
                .addAttribute("fileName", filename).addAttribute("append", false).add(layoutBuilder);

        builder.add(appenderBuilder);

        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.INFO);
        rootLogger.add(builder.newAppenderRef("LogToFile"));

        builder.add(rootLogger);
        Configurator.reconfigure(builder.build());

        ThreadContext.put("logFile", filename);
    }
}
