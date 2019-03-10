package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import util.CityCode;
import util.HttpUtil;

@Controller
@RequestMapping("australian")
public class WeatherController {
	@Value("#{cityProperties.url}")
	private String url;
	@RequestMapping(value = "/city", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String cityWeather(String cityName){
		if (cityName != null && !cityName.equals("")) {
			CityCode cityCode = new CityCode();
			String code = cityCode.getCityCode(cityName);
			return HttpUtil.doGet(url + code + ".html");
		}
		return "";
	}
}
