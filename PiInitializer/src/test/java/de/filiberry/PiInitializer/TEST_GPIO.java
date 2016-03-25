package de.filiberry.PiInitializer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TEST_GPIO {

	public static void main(String[] args) {

		System.out.println("JAVA Gpio TEST...");
		System.out.println("Write 14 to /sys/class/gpio/export ");
		System.out.println("-----------------------------------");
		try {
			FileUtils.writeStringToFile(new File("/sys/class/gpio/export"), "14");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
