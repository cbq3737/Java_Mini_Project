package school.output;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GeneratedReport {
	School school = School.getInstance();
	public static final String Title = " 수강생 학점 \t\t\n";
	public static final String Header = " 이름  |  학번   |중점과목| 점수   \n";
	public static final String Line = "-------------------------------------\n";
	private StringBuffer buffer = new StringBuffer();
	
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList(); //학교의 모든 과목에 대한 학점 산출
		for(int i=0;i<subjectList.size();i++) {
			Subject subject = subjectList.get(i);
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString();
	}
	public void makeHeader(Subject subject) {
		buffer.append(Line);
		buffer.append("\t"+subject.getSubjectName());
		buffer.append(Title);
		buffer.append(Header);
		buffer.append(Line);
	}
	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();
		for(int i=0;i<studentList.size();i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName(	));
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName()+"\t");
			buffer.append(" | ");
			
			getScoreGrade(student,subject);
			buffer.append("\n");
			buffer.append(Line);
			
		}
	}
	//제일 중요 = 어떤 정책을 통해 학점을 가져올지 
	public void getScoreGrade(Student student, Subject subject) {
		//학생이 가진 scoreList
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();
		//define값에 따른 점수정책
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(),new MajorEvaluation(),new PassFailEvaluation()};
		
		for(int i=0;i<scoreList.size();i++) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subject.getSubjectId()) {//score의 과목번호와 매개변수의 과목번호가 같다면
				String grade;
				if(score.getSubject().getGradeType() == Define.PF_TYPE) {
					grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
				}
				else {
					if(score.getSubject().getSubjectId() == majorId) { //중점과목이라면
						grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
					}
					else {
						grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
					}	
				}
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
			}
		}
	}
	public void makeFooter() {
		buffer.append("\n");
	}
}
