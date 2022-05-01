package co.micol.prj.game;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	// 1게임: 1000원 / 1~45 숫자6개 추출 중복X
	// lotto번호 비교 후 금주번호, 내번호, 맞는 번호 출력
	private Scanner sc = new Scanner(System.in);
	private int[] lotto = new int[6];
	private int[] userLotto = new int[6];
	
	
	private void insertMoney() {
		System.out.println("금액을 입력하세요. (1게임당 1,000원)");
		int gameMoney = sc.nextInt();
		
		if(gameMoney < 1000) {
			System.out.println("금액이 부족합니다. (1게임당 1,000원");
		} else {
			System.out.println(gameMoney/1000 + "회 진행합니다.");
			for (int i = 0; i < gameMoney/1000; i++) {
				System.out.println("1~45범위의 숫자를 6개를 입력해주세요.");
				for (int j = 0; j < userLotto.length; j++) {
					int userNum = sc.nextInt();
					if(userNum <= 45) {
						userLotto[j] = userNum;
					} else {
						System.out.println("범위를 벗어난 숫자입니다.");
						j--;
					}
				}
				
				lottoNum();
				System.out.println("사용자 선택 번호");
				for (int j = 0; j < userLotto.length; j++) {
					System.out.print(userLotto[j] + " ");
				}
				System.out.println();
				System.out.println("-----------------");
				System.out.println("일치하는 번호");
				for (int j = 0; j < lotto.length; j++) {
					for (int k = 0; k < userLotto.length; k++) {
						if(lotto[j] == userLotto[k]) {
							System.out.print(userLotto[k] + " ");
						}
					}
				}
			}
		}
	}
	
	//시스템 로또 번호 생성
	private void lottoNum() {
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("-----------------");
		System.out.println("금주의 로또 번호");
		Arrays.sort(lotto);
		for (int j = 0; j < lotto.length; j++) {
			System.out.print(lotto[j] + " ");
		}
		System.out.println();
		System.out.println("-----------------");
	}
	
	public void run() {
		insertMoney();
		System.out.println();
	}
}
