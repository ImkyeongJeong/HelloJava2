package co.micol.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();	//전체조회
	NoticeVO noticeSelect(NoticeVO vo);	//한건조회
	int noticeInsert(NoticeVO vo);		//추가
	int noticeUpdate(NoticeVO vo);		//수정
	int noticeDelete(NoticeVO vo);		//삭제
}
