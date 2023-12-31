package com.cmaksymenko.playground.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartupApplicationListener.class);

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("Server started with context path '{}' on port '{}'", contextPath, serverPort);
    }
}