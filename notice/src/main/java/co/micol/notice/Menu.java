package co.micol.notice;

import java.util.Scanner;

public class Menu {
	//1. 학생관리 (등록,수정,삭제,조회) / 2.공지사항 (등록,조회,상세조회,삭제)/ 3.종료
	private Scanner sc = new Scanner(System.in);
	
	private void mainTitle() {
		System.out.println("===========");
		System.out.println("=1.학생관리 =");
		System.out.println("=2.공지사항 =");
		System.out.println("=3.종   료 =");
		System.out.println("===========");
	}
	
	private void studentTitle() {
		System.out.println("===============");
		System.out.println("=1.전체학생목록 =");
		System.out.println("=2.학생정보조회 =");
		System.out.println("=3.학생정보등록 =");
		System.out.println("=4.학생정보수정 =");
		System.out.println("=5.학생정보삭제 =");
		System.out.println("=6.메인메뉴가기 =");
		System.out.println("===============");
	}
	
	private void noticeTitle() {
		System.out.println("===============");
		System.out.println("=1.공지사항목록 =");
		System.out.println("=2.공지사항조회 =");
		System.out.println("=3.공지사항등록 =");
		System.out.println("=4.공지사항수정 =");
		System.out.println("=5.공지사항삭제 =");
		System.out.println("=6.메인메뉴가기 =");
		System.out.println("===============");
	}
	
	private void mainMenu() {
		boolean b = true;
		do {
			mainTitle();
			System.out.println("메뉴를 선택하세요.");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:
					studentMenu();
					break;
				case 2:
					noticeMenu();
					break;
				case 3:
					System.out.println("bye bye!");
					b = false;
					break;
			}
		}
		while(b);
	}
	
	//학생관리
	private void studentMenu() {
		boolean b = true;
		do {
			studentTitle();
			System.out.println("메뉴를 선택하세요.");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
					//전체학생목록
					break;
				case 2:
					//학생정보조회
					break;
				case 3:
					//학생정보등록
					break;
				case 4:
					//학생정보수정
					break;
				case 5:
					//학생정보삭제
					break;
				case 6:
					//메인메뉴가기
					mainMenu();
					b = false;
					break;
			}
		}
		while(b);
	}

	
	//공지사항
	private void noticeMenu() {
		boolean b = true;
		do {
			noticeTitle();
			System.out.println("메뉴를 선택하세요.");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				//공지사항목록
				break;
			case 2:
				//공지사항조회
				break;
			case 3:
				//공지사항등록
				break;
			case 4:
				//공지사항수정
				break;
			case 5:
				//학생정보삭제
				break;
			case 6:
				//메인메뉴가기
				mainMenu();
				b = false;
				break;
			}
		}
		while(b);
	}
	
	public void run() {
		mainMenu();
	}
}
