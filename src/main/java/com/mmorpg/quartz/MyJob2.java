package com.mmorpg.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MyJob2 {

    private static Logger logger = LoggerFactory.getLogger(MyJob.class);

    public void doSomething(){
        logger.info(new Date()+"job2 doing something...");

    }
}
