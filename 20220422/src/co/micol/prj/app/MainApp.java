package co.micol.prj.app;


import co.micol.prj.SelectionSort;

public class MainApp {
	public static void main(String[] args) {
		SelectionSort selectSort = new SelectionSort();
		int data[] = {5,1,4,3,2};
		selectSort.sort(data);
	}
}
