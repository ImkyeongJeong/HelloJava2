package co.micol.prj.menu;

import java.util.Scanner;

import co.micol.prj.game.Lotto;
import co.micol.prj.game.Mabangjin;
import co.micol.prj.game.Tetris;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Lotto lotto = new Lotto();
	private Mabangjin mabangjin = new Mabangjin();
	private Tetris tetris = new Tetris();
	
	private void mainTitle() {
		System.out.println("===============");
		System.out.println("== 게 임 모 음 ==");
		System.out.println("== 1.로또 게임 ==");
		System.out.println("== 2.마 방 진 ==");
		System.out.println("== 3.테트리스 ==");
		System.out.println("== 4.게임종료 ==");
		System.out.println("===============");
		System.out.println("하고 싶은 게임을 선택하세요.");
	}
	
	private void mainMenu() {
		boolean b = true;
		do {
			mainTitle();
			int key = sc.nextInt();
			switch(key) {
			case 1:
				//로또게임
				lotto.run();
				break;
			case 2:
				//마방진
				mabangjin.run();
				break;
			case 3:
				//테트리스
				tetris.run();
				break;
			case 4:
				b = false;
				System.out.println("Good Bye !!!!!");
				sc.close();
				break;
			}
		}
		while(b);
	}
	
	public void run() {
		mainMenu();
	}
}
