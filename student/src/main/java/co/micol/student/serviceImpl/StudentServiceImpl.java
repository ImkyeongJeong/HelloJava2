package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dao.DataSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private DataSource dataSource = DataSource.getInstance();//싱글톤클래스 dao인스턴스 갖고 옴
	private Connection conn = dataSource.getConnection();	//connection연결
	private PreparedStatement psmt;							//sql보내고 명령실행요청
	private ResultSet rs;									//select 결과를 담는 구문(select구문은 ResultSet /나머지는 int)
	
	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 학생 목록 가져오기 (리턴값 받을 List)
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student; //한 명의 정보
		String sql = "SELECT * FROM STUDENT";	//ctl + shift + x
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//sql을 실행하고 결과를 담음
			//다음 값이 있으면 true, 없으면 false
			while(rs.next()) {
				student = new StudentVO(); 	//StudentVO객체 깨끗하게 초기화
				student.setStudentId(rs.getString("studentid")); //rs.get컬럼타입("컬럼명")
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);		//리스트에 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		//한명조회
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?"; // ?에 대응해주는 코드 작성한다.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId()); //psmt.setTpye(물음표자리, 들어갈 값)첫 번째 물음표에 student의 studentid를 담는다.
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertStudent(StudentVO student) {
		//한명 추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		// 한명 정보 변경
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?,"
					+ "TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		//한명 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
