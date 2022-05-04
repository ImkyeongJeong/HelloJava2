package com.yedam.app.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //모든 필드를 이용해서 생성자를 추가
public class PropertiesPair {
	private String key;
	private String value;
	
	public static String getQuery(List<PropertiesPair> params) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		
		for(PropertiesPair param : params) {
			if(isFirst) { //처음은 건너띄우고, 두번째 key value에 "&" 붙인다.
				isFirst = false; 
			} else {
				sb.append("&");
			}
			//한글일 수 있어서 변환형식 지정
			sb.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			sb.append("=");
			sb.append(URLEncoder.encode(param.getValue(), "UTF-8"));
		}
		
		return sb.toString();
	}
}
