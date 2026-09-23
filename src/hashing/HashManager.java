package hashing;

import java.util.HashMap;
import model.Student;

public class HashManager {

private HashMap<String, Student> studentMap;
public HashManager() {
studentMap = new HashMap<>();
}

public void addStudent(Student student) {
studentMap.put(student.getStudentId(), student);
}
public Student searchStudent(String studentId) {
return studentMap.get(studentId);
}
public void displayAllStudents() {

for (Student student : studentMap.values()) {
System.out.println(student);
}
}


}
