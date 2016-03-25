package de.filiberry.PiInitializer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class GPIOWriter {

	public static final String KERNEL_EXPORT_PATH = "/sys/class/gpio/export";
	public static final String KERNEL_DIRECTION_PATH = "/sys/class/gpio{ID}/export";
	public static final String DIRECTION_OUT = "out";
	public static final String DIRECTION_IN = "in";
	private static Logger log = Logger.getLogger(GPIOWriter.class.getName());

	/**
	 * 
	 * @param gpioPort
	 * @return
	 */
	public static boolean setGPIOtoOutput(int gpioPort) {
		try {
			FileUtils.writeStringToFile(new File(KERNEL_EXPORT_PATH), "" + gpioPort);
			Thread.sleep(1500);
			String direction = StringUtils.replace(KERNEL_DIRECTION_PATH, "{ID}", "" + gpioPort);
			FileUtils.writeStringToFile(new File(direction), DIRECTION_OUT);
		} catch (IOException e) {
			log.info("Exception: " + e.getMessage());
			return false;
		} catch (InterruptedException e) {
			log.info("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

}
