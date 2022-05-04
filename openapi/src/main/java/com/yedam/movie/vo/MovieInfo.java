package com.yedam.movie.vo;



import java.util.Date;

import lombok.Data;

//Gson / 클래스를 구성하는 필드는 반환 받는 key값을 가져야 한다.
@Data
public class MovieInfo { //내부 객체 3
	private int rnum;
	private int rank;
	private int rankInten;
	private String rankOldAndNew;
	private String movieCd;
	private String movieNm;
	private Date openDt;
	private long salesAmt;
	private double salesShare;
	private long salesInten;
	private double salesChange;
	private long salesAcc;
	private long audiCnt;
	private long audiInten;
	private double audiChange;
	private long audiAcc;
	private long scrnCnt;
	private long showCnt;
}
