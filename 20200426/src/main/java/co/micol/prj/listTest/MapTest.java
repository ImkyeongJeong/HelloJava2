package co.micol.prj.listTest;

import java.util.HashMap;
import java.util.Map;

import co.micol.prj.dto.StudentVO;

public class MapTest {
	public void mapTest() {
		//<key값 String, Value값 String>
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("address", "대구광역시");
		
		//출력할 때 key값을 주면 value값을 받는다.
		System.out.println(map.get("name"));
		System.out.println(map.get("address"));
	}
	
	public void studentMap() {
		Map<Integer, StudentVO> map = new HashMap<Integer, StudentVO>();
		//StudentVO 초기화
		map.put(1, new StudentVO());
		map.put(2, new StudentVO("박승리"));
		
		System.out.println(map.get(2));
	}
}
