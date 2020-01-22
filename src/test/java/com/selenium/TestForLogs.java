package com.selenium;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestForLogs {
	
	@Test(priority=0)
	public void RootLoggerDemo()
	{
		Logger log = Logger.getRootLogger();
		
		log.trace("Trace Message!");
		log.debug("Debug Message");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.fatal("Fatal Message");
		
	}
	@Test(priority=1)
	public void ManualLoggerDemo()
	{
		Logger log = Logger.getLogger("manualLogger");
		
		log.trace("Trace Message1!");
		log.debug("Debug Message2!");
		log.info("Info Message3!");
		log.warn("Warn Message4!");
		log.error("Error Message5!");
		log.fatal("Fatal Message6!");
		
	}

}
