package co.micol.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        StudentService dao = new StudentServiceImpl();
        List<StudentVO> list = new ArrayList<StudentVO>();
        list = dao.selectListStudent();
        
        for(StudentVO vo : list) {
        	vo.toString();
        }
//        
//        System.out.println("================================");
//        StudentVO student = new StudentVO();
//        student.setStudentId("ikik24@naver.com"); //찾을 아이디
//        student = dao.selectStudent(student);
//        student.toString();
    	
//    	StudentVO vo = new StudentVO();
//    	vo.setStudentId("leeto@abc.com");
//    	vo.setName("이기자");
//    	vo.setBirthday(Date.valueOf("2020-01-01"));
//    	vo.setMajor("경영학과");
//    	vo.setAddress("대구광역시 중구 중앙대로");
//    	vo.setTel("010-1234-4567");
//    	int n = dao.insertStudent(vo);
//    	if(n != 0) {
//    		System.out.println("정상적으로 입력이 되었습니다.");
//    	}else {
//    		System.out.println("입력이 실패했습니다.");
//    	}
    }
}
