package com.logcheck.logcheck.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class newController {
    private static final Logger logger = LoggerFactory.getLogger(newController.class);
    @GetMapping("/log2")
    public String testLogging() {
        logger.info("This is an INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is an ERROR log");
        return "Logging done!";
    }

    @GetMapping("/log3")
    public String testLogging2() {
        logger.info("This is an INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is an ERROR log");
        return "Logging done!";
    }
}
