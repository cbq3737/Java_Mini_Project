package school;

import java.util.ArrayList;

//학교는 하나이기 때문에 싱글톤 패턴으로 생성
public class School {
	private static School instance = new School();
	
	//학교에 학생 및 개설된 과목에 대한 정보 = 원래대로라면 DB로 관리를 해야하지만 지금은 그냥 배열로 관리
	private ArrayList<Student> studentList = new ArrayList<>();
	private ArrayList<Subject> subjectList = new ArrayList<>();
		
	//밖에서 만들지 못하도록 private으로 디폴트 생성자
	private School() {
		
	}
	//하나의 instance만 반환
	public static School getInstance() {
		if(instance == null) {			
			return new School();
		}
		return instance;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
