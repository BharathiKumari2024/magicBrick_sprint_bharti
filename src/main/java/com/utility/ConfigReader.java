package com.utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader extends Config {
	private Properties prop;

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(filePath);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

}
}
