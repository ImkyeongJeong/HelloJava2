package com.yedam.app;

import java.util.List;

import com.yedam.forecast.service.ForecastService;
import com.yedam.forecast.service.vo.WeatherInfo;

public class App {

	public static void main(String[] args) {
//		List<MovieInfo> list = MovieService.getDaillyBoxOfficeResult();
//		for(MovieInfo info : list) {
//			System.out.println(info);
//		}
		
		List<WeatherInfo> list = ForecastService.getWeatherForecast();
		for(WeatherInfo info : list) {
			System.out.println(info);
		}
	}
}
