package com.yedam.movie.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoxOfficeInfo { //내부객체1
	private String boxofficeType;
	private String showRange;
	private List<MovieInfo> dailyBoxOfficeList;
}
