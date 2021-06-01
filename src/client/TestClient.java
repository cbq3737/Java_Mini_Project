package client;


import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.output.GeneratedReport;
import utils.Define;

//웹 페이지가 없으므로 여기서 등록한다.
public class TestClient {
	School testSchool = School.getInstance();
	Subject korean;
	Subject math;
	
	//출력 클래스
	GeneratedReport gradeReport = new GeneratedReport();
	
	public static void main(String[] args) {
		TestClient test = new TestClient();
		test.createSubject();
		test.createStudent();
	
		String report = test.gradeReport.getReport();
		System.out.println(report);
	}
	//테스트 과목 생성
	public void createSubject() {
		//국어와 수학 과목 생성 
		korean = new Subject(Define.KOERAN,"국어");
		math = new Subject(Define.MATH,"수학");
		
		testSchool.addSubject(korean);
		testSchool.addSubject(math);
	}
	//테스트 학생 생성
	public void createStudent() {
		//학생 생성
		Student student1 = new Student(211213,"강감찬",korean);
		Student student2 = new Student(212330,"김유신",math);
		Student student3 = new Student(201518,"신사임당",korean);
		Student student4 = new Student(202360,"이순신",korean);
		Student student5 = new Student(201290,"홍길동",math);
	
		//이 아래내용은 원래 웹 페이지를 통해 받아야하는 정보들
		testSchool.addStudent(student1);
		testSchool.addStudent(student2);
		testSchool.addStudent(student3);
		testSchool.addStudent(student4);
		testSchool.addStudent(student5);
		//국어 수강한 학생 
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		//수학 수강한 학생
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		
		addScoreForStudent(student1,korean,95);
		addScoreForStudent(student1,math,56);
		
		addScoreForStudent(student2,korean,95);
		addScoreForStudent(student2,math,98);
		
		addScoreForStudent(student3,korean,100);
		addScoreForStudent(student3,math,88);
		
		addScoreForStudent(student4,korean,89);
		addScoreForStudent(student4,math,95);
		
		addScoreForStudent(student5,korean,83);
		addScoreForStudent(student5,math,56);
	}
	//학생이 받은 과목별 점수 
	public void addScoreForStudent(Student student,Subject subject,int point) {
		Score score=  new Score(student.getStudentId(),subject,point);
		student.addSubjectScore(score);
	}
}
