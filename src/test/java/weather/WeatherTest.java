package weather;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.WeatherController;
import util.HttpUtil;

public class WeatherTest {
	/**
	 * get方式调用天气预报接口
	 */
	@Test
	public void testHpptGet(){
		String url = "http://www.weather.com.cn/data/cityinfo/601060101.html";
		HttpUtil.doGet(url);
	}
	/**
	 * 获取城市天气接口
	 */
	@Test
	public void testGetCityWeather(){
		String cityName = "Melbourne";
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		WeatherController wc = ac.getBean("weatherController",WeatherController.class);
		System.out.println(wc.cityWeather(cityName));
		
		AbstractApplicationContext aac = (AbstractApplicationContext)ac;
		aac.close();
		
	}

}
