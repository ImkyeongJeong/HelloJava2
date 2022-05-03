package co.micol.student.dto;

import java.sql.Date;

import lombok.Data;

@Data
//DTO:데이터를 교환할 때 사용
public class StudentVO {
	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;

	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(name + " : ");
		System.out.print(birthday + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		return null;
	}
}
