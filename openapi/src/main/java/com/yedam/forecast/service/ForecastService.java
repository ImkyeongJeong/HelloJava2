package com.yedam.forecast.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.yedam.app.common.PropertiesPair;
import com.yedam.forecast.service.vo.WeatherInfo;

//심플방식
public class ForecastService {
	//동네예보 - 육상예보조회
	public static List<WeatherInfo> getWeatherForecast(){
		String key = "Wpi56+scR5jTGkHftd2DfyiO0InK3Zb5IP3NKDbFUmWLwqpLKexV0VZqoAs2ZPChLMySvOhEABf1+g3aEJPZrw==";
		
		String serviceURL = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst?";

		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("ServiceKey", key));
		params.add(new PropertiesPair("pageNo", "1"));
		params.add(new PropertiesPair("numOfRows", "10"));
		params.add(new PropertiesPair("dataType", "JSON"));
		params.add(new PropertiesPair("regId", "11A00101"));
		
		//문자열 조합은 객체가 새로 생성되지만 양이 많을 땐 비효율 /양이 많아도 객체 1개만 생성
		StringBuilder sb = new StringBuilder();
		
		try {
			String paramURL = PropertiesPair.getQuery(params);
			String requestURL = serviceURL + paramURL;
			
			//문자열로 들어온 값을 하나하나 구분한다. (어디까지가 서비스/데이터인지 구분)
			URL url = new URL(requestURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			//setRequestProperty헤더를 구성할 때 여러가지 정보로 구성 (Content-type: 받는쪽이 이 데이터가 text인지 file인지 등 알 수 있도록 정보를 줌 / application/json 제이슨형태임을 알림
			con.setRequestProperty("Content-type", "application/json");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line; //임시로 받을 변수
				while((line=br.readLine())!= null) { //null이 아닌 경우 계속 값을 받기
					sb.append(line); //읽은 걸 담음
				}
				br.close();
			}else {
				System.out.println(con.getResponseMessage());
			}
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsonResult = sb.toString();
		return getWeatherData(jsonResult);
	}
	
	private static List<WeatherInfo> getWeatherData(String jsonData) {
		List<WeatherInfo> list = new ArrayList<WeatherInfo>();
		try {
			JSONParser parser = new JSONParser();
			JSONObject forecastData = (JSONObject)parser.parse(jsonData);
			JSONObject response = (JSONObject)forecastData.get("response");
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
			JSONArray item = (JSONArray)items.get("item");
			
			for(int i=0; i < item.size(); i++) {
				JSONObject data = (JSONObject)item.get(i);
				WeatherInfo info = new WeatherInfo();
				//발표시간 - 필수
				info.setAnnounceTime((long)data.get("announceTime"));
				//발표번호 - 옵션(존재하지 않을 수 있기 때문에)
				info.setNumEf((data.get("numEf") == null)? 0 : (long)data.get("numEf"));
				//예보구역코드 - 필수
				info.setRegId((String)data.get("regId"));
				//강수확률 - 옵션
				info.setRnSt((data.get("rnSt")== null)? 0 : (long)data.get("rnSt"));
				//강수형태 - 필수
				info.setRnYn((long)data.get("rnYn"));
				//예상기온 - 옵션
				info.setTa((data.get("ta") == null)? "" : (String)data.get("ta"));
				//날씨 - 필수
				info.setWf((String)data.get("wf"));
				//하늘상태 - 필수
				info.setWfCd((String)data.get("wfCd"));
				//풍속 강도코드 - 필수
				info.setWsIt((String)data.get("wsIt"));
				
				list.add(info);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
}
