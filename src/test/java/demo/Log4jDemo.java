package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger1 = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("This is a sample for Log4j.");
		
		logger1.info("This is an information message");
		logger1.error("This is an error message");
		logger1.warn("This is a warning message");
		logger1.fatal("This is a fatal message");

		System.out.println("This is completed");
	} // end main method

} // end class Log4jDemo
