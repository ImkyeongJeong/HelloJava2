package com.yedam.movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yedam.app.common.PropertiesPair;
import com.yedam.movie.vo.BoxOfficeInfo;
import com.yedam.movie.vo.BoxOfficeResult;
import com.yedam.movie.vo.MovieInfo;

public class MovieService {
	private static final String key = "092eff8f8fbed579969705eb6d2aec88";
	
	//일별 박스 오피스
	public static List<MovieInfo> getDaillyBoxOfficeResult(){
		//요청하려는 서비스 정보 url(get방식: url에 붙여서 데이터를 보내는 구성(url뒤 물음표를 붙여 요청자료라 표시)
		String serviceURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";
		
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("key", key));
		params.add(new PropertiesPair("targetDt", "20220429"));
		
		StringBuilder sb = new StringBuilder();
		
		try {
			
			//요청하려는 데이터 정보
			String paramURL = PropertiesPair.getQuery(params);
			//최종 요청 url
			String requestURL = serviceURL + paramURL;
			
			//문자를 URL이라 알려주기 위해 URL생성(java.net.url) / 문자열로 들어온 값을 구분(어디까지가 서비스/데이터인지)
			URL url = new URL(requestURL);
			
			//객체를 반환 받을 통로연결
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			//서버에 보낸 정보에 대해 서버 응답이 정상적인지 확인 (OK일 경우에만 데이터 가공)
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//바이트를 문자로 변환할 때 형식을 지정해줘야한다.(성능향상위해 BufferReader사용)
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String line;
				while((line=br.readLine())!= null) { //null이 아닌 경우 계속 값을 받기
					sb.append(line);
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			//외부 통신 끊기
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//파싱 전
		String jsonResult = sb.toString();
		
		//파싱 작업 / 첫 번재 매개변수 json을 클래스로 만들어준다. 
		BoxOfficeResult result = new Gson().fromJson(jsonResult, BoxOfficeResult.class);
		
		 return result.getBoxOfficeResult().getDailyBoxOfficeList();
		 
	      // BoxOfficeInfo = result.getBoxOffiveResult();
	      // List<MovieInfo> list = info.getDailyBoxOfficeList(); 이 두분장을 위처럼 줄인것임
	}
}
