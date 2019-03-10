package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CityCode {
	public String getCityCode(String cityName) {
		InputStream in = getClass().getClassLoader().getResourceAsStream("city.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		String cityCode = prop.getProperty(cityName);
		return cityCode;
	}
}
