package co.micol.prj.listTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.dto.StudentVO;

public class ListTest {
	public void listTest() {
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박기자");
		list.add("이승리");
		
		//String으로 읽겠다 list구조를
		for(String str : list) {
			System.out.println(str);
		}
	}
	
	public void studentList() {
		//List를 StudentVO타입으로 ArrayList를 생성
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student = new StudentVO();
		
		student.setStudentId("202204001");
		student.setName("홍길동");
		student.setAge(20);
		//Date.valueOf 스트링을 날짜형식으로 변환
		student.setBirthDay(Date.valueOf("2002-03-01"));
		student.setGender("F");
		//리스트에 추가
		students.add(student);
		
		//객체 초기화
		student = new StudentVO();
		student.setStudentId("202204002");
		student.setName("박기자");
		student.setAge(20);
		student.setBirthDay(Date.valueOf("2002-04-01"));
		student.setGender("W");
		students.add(student);
		
		//StudentVO타입의 students의 한 행을 읽음
		for(StudentVO vo : students) {
			vo.toString();
		}
	}
}
