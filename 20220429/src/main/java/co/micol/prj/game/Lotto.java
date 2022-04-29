package co.micol.prj.game;

import java.util.Scanner;

public class Lotto {
	// 배열 / 1게임: 1000 / 1~45 숫자6개 추출 / 금액입력 받고 몇 게임인가 / Arraylist, sort/ 출력: 1장당 5게임
	private Scanner sc = new Scanner(System.in);
	private int[] lotto = new int[6];
	private int money;
	
	private void lottoTitle() {
		System.out.println("================");
		System.out.println("로또게임을 시작합니다.");
		System.out.println("================");
	}
	
	private void lottoGame() {
		lottoTitle();
		System.out.println("금액을 입력하세요.");
		int money = sc.nextInt();
		int game = money/1000;
		
		//game 수
		for (int i = 0; i < game; i++) {
			//랜덤숫자 추출
			for (int j = 0; j < lotto.length; j++) {
				lotto[j] = (int)(Math.random()*45)+1;
				//중복값 처리
				for (int k = 0; k < j; k++) {
					if(lotto[j]==lotto[k]) {
						j--;
						break;
					}
				}
				
			}
			System.out.println(i+"번째 로또 출력 : ");
			for (int j = 0; j < lotto.length; j++) {
				System.out.print(lotto[j] + " ");
			}
			System.out.println();
		}
	}


	public void run() {
		lottoGame();
		System.out.println();
	}
}
