package de.filiberry.PiInitializer;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator, ManagedService {

	private ServiceRegistration serviceReg;
	private Logger log = Logger.getLogger(this.getClass().getName());
	private static final String PINS_CONFIG_KEY = "GPIO_OUTPUT_PINS";

	/**
	 * 
	 */
	@Override
	public void updated(Dictionary properties) throws ConfigurationException {
		if (properties == null) {
			log.info("PiInitializer config is null - Please give me a config File in KARAF/etc : PiInitializer.cfg");
			return;
		}
		log.info("PiInitializer Config was set.");
		String[] ports = StringUtils.split("" + properties.get(PINS_CONFIG_KEY), ",");
		for (String port : ports) {
			log.info("Set Port:" + port + " to Out...");
			if (GPIOWriter.setGPIOtoOutput(new Integer(port))) {
				log.info("GPIO : " + port + " is set to Output Port.");
			} else {
				log.info("Exception when setting GPIO : " + port + " to Output.");
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		log.info("Bundle : PiInitializer startet");
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		properties.put(Constants.SERVICE_PID, "PiInitializer");
		serviceReg = context.registerService(ManagedService.class.getName(), this, properties);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("Bundle : PiInitializer stop");
	}

}
