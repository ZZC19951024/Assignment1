package Assignment8;

import java.util.List;

public interface StudentManager {

	public void addStudent(Student student) throws RuntimeException;

	public int getStudentCount();

	public void display();

	public List<Student> getStudents();
}
