package co.micol.prj;

import co.micol.prj.listTest.MapTest;
import co.micol.prj.listTest.SetTest;

public class MainApp {

	public static void main(String[] args) {
		//java project 시작 및 종료
//		ListTest list = new ListTest();
//		list.listTest();
//		System.out.println("===================");
//		list.studentList();
		
//		SetTest setTest = new SetTest();
//		setTest.setTest();
		
		MapTest mapTest = new MapTest();
		mapTest.mapTest();
		mapTest.studentMap();
	}
}
