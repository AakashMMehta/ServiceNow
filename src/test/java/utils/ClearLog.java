package utils;

import java.io.File;
import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

public class ClearLog {
	
	public void rollLogFile(Logger logger) {
		  while (logger != null && !logger.getAllAppenders().hasMoreElements()) {
		    logger = (Logger)logger.getParent();
		  }

		  if (logger == null) {
		    return;
		  }

		  for (Enumeration e2 = logger.getAllAppenders(); e2.hasMoreElements();) {
		    final Appender appender = (Appender)e2.nextElement();
		    if (appender instanceof RollingFileAppender) {
		      final RollingFileAppender rfa = (RollingFileAppender)appender;
		      final File logFile = new File(rfa.getFile());
		      if (logFile.length() > 0) {
		        rfa.rollOver();
		      }
		    }
		  }
		}
}
