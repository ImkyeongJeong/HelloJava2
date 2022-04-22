package co.micol.prj;

public class SelectionSort {
	//내부적으로 사용할 때 get/set생성 불필요
	private int i;
	private int j;
	private int min;
	
	public void sort(int[] arr) {
		//초기데이터 출력
		arrPrint(arr);
		
		for (i = 0; i < arr.length-1; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) {	//요소 비교
				if(arr[min] > arr[j]) { 			//내림차순 (arr[min] > arr[j])
					min = j;
				}
			}
			
			//if문을 만들 때 선행조건(한 번에 해결할 수 있는 조건)주는 게 좋다
			if(min != i) { //swqp
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		//결과데이터 출력
		retulsPrint(arr);
	}


	private void retulsPrint(int[] arr) {
		System.out.println("=== 결과 데이터 ===");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("=================");
	}


	private void arrPrint(int[] arr) {
		System.out.println("=== 초기 데이터 ===");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("=================");
	}
}
