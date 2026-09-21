package linkedlist;
import model.Student;

public class StudentLinkedList {

    private StudentNode head;

    public StudentLinkedList() {
    head = null;
    }

    public void addStudent(Student student) {

        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        StudentNode current = head;

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    public Student searchStudent(String studentId) {

        StudentNode current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public boolean updateStudent(String studentId,
                                String newName,
                                String newProgramme,
                                double newMarks) {

        StudentNode current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {

                current.student.setName(newName);
                current.student.setProgramme(newProgramme);
                current.student.setMarks(newMarks);

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean deleteStudent(String studentId) {

        if (head == null) {
            return false;
        }

        if (head.student.getStudentId().equals(studentId)) {
            head = head.next;
            return true;
        }

        StudentNode current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId().equals(studentId)) {

                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
