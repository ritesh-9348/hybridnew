package Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logs {
public Logger logs;
public Logger createlog() {
	logs=Logger.getLogger(getClass());
	PropertyConfigurator.configure(System.getProperty("user.dir")+"log4j.properties");
	return logs;
}
}
