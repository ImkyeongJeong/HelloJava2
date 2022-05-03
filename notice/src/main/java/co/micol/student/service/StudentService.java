package co.micol.student.service;

import java.util.List;

import co.micol.student.dto.StudentVO;

public interface StudentService {
	//전체 학생목록(select로 조회한 것을 List<StudentVO>에 담아서 보여줌)
	List<StudentVO> selectListStudent();
	//한명 학생목록
	StudentVO selectStudent(StudentVO student);
	//한명 추가(VO객체를 던지면 insert한다)
	int insertStudent(StudentVO student);
	//한명 갱신
	int updateStudent(StudentVO student);
	//한명 삭제
	int deleteStudent(StudentVO student);	
}
