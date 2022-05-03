package co.micol.notice;

import java.util.ArrayList;
import java.util.List;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.serviceImpl.NoticeServiceImpl;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
//        NoticeService dao = new NoticeServiceImpl();
//        //결과 담기 위함
//        List<NoticeVO> list = new ArrayList<>();
//        //결과가 list타입으로 오기 때문에 값 담아줌
////        list = dao.noticeSelectList();
        
        //한건조회
//        NoticeVO vo = new NoticeVO();
//        vo.setId(1);
//        vo = dao.noticeSelect(vo);
//        vo.toString();
//        
    	
        
//    	StudentService studentDao = new StudentServiceImpl();
//        List<StudentVO> list = new ArrayList<StudentVO>();
//        list = studentDao.selectListStudent();
//        for(StudentVO vo : list) {
//        	vo.toString();
//        }
//        
//        NoticeService noticeDao = new NoticeServiceImpl();
//        List<NoticeVO> nlist = new ArrayList<NoticeVO>();
//        nlist = noticeDao.noticeSelectList();
//        for(NoticeVO vo : nlist) {
//        	vo.toString();
//        }
    	
    	
    	Menu menu = new Menu();
    	menu.run();
    }
}
