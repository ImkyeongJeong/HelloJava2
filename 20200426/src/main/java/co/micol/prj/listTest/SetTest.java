package co.micol.prj.listTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public void setTest() {
		Set<String> name = new HashSet<String>();
		name.add("홍길동");
		name.add("박승리");
		name.add("이기자");
		name.remove("이기자");
		
		//Iterator: 인터페이스(무작위의 값을 나란히한다.)
		Iterator<String> iterator = name.iterator();
		while(iterator.hasNext()) {
			//set구조 출력(나올 때는 순서 다르다.)
			System.out.println(iterator.next());
		}
	}
}
