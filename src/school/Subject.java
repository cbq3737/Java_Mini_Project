package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	private int subjectId;  //과목이름
	private String subjectName;  //과목
	private int gradeType;  //과목 평가 방법, 기본 방법은 A,B방식
	
	//수강 신청한 학생 리스트
	//register() 메서드를 호출하면 리스트에 추가
	private ArrayList<Student> studentList = new ArrayList(); 
	
	public Subject(int subjectId,String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.gradeType = Define.AB_TYPE;
	}
	//수강 신청
	public void register(Student student) {
		studentList.add(student);
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getGradeType() {
		return gradeType;
	}
	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
}
