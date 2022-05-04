package com.yedam.movie.vo;

import lombok.Data;

@Data //필드 선언 후 롬복 선언하면 오타 났을 때 getter/setter에서 값응ㄹ 못 가져와서null생김  
public class BoxOfficeResult { //최상위 객체
	private BoxOfficeInfo boxOfficeResult; 
}