package co.micol.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.notice.dao.DataSource;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	//DataSource객체 연결
	private DataSource dao = DataSource.getInstance();
	//커넥션 연결(한 건 보내고 닫아주기 위함)
	private Connection conn; // = dao.getConnection();
	
	//sql문을 실행 시키기위한 객체
	private PreparedStatement psmt;
	//sql문이 select일 때 결과 받기위한
	private ResultSet rs;
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		//전체조회
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		try {
			//커넥션 객체 열어준다.
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			//select
			rs = psmt.executeQuery();
			
			while(rs.next()) {		//돌아오는 결과 몇개인지 모르니 next로 읽음
				vo = new NoticeVO(); //add한 후 초기화 하고 다시 추가하기 위함 
				vo.setId(rs.getInt("id")); //db컬럼이름
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				//한 set을 읽어서 리스트에 추가
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결된 커넥션 끊어주고 list반환
			close();
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		//한건조회(세부조회)
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId()); //id값 담아서 전달
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new NoticeVO(); //값을 실어보내기 위한 초기화
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				
				hitUpdate(vo.getId()); //조회수 증가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결된 커넥션 끊기
			close();
		}
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		String sql = "INSERT INTO NOTICE VALUES(?,?,?,?,?,?)";
		int n = 0;
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getSubject());
			psmt.setDate(5, vo.getWdate());
			psmt.setInt(6, vo.getHit());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return n;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		String sql = "DELETE FROM NOTICE WHERE ID = ?";
		int n = 0;
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return 0;
	}
	
	private void close() {
		// 연결순서: conn > psmt > rs
		// 닫는순서: rs > psmt > conn
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void hitUpdate(int id) {
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
