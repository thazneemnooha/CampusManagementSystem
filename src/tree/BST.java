package tree;
import model.Student;

public class BST {

private BSTNode root;
public BST() {
root = null;
}
public void insert(Student student) {
root = insertRecursive(root, student);
}

private BSTNode insertRecursive(BSTNode node, Student student) {

if (node == null) {
return new BSTNode(student);
}

if (student.getStudentId().compareTo(node.student.getStudentId()) < 0) {
node.left = insertRecursive(node.left, student);
} else if (student.getStudentId().compareTo(node.student.getStudentId()) > 0) {
node.right = insertRecursive(node.right, student);
}

return node;
}
public void displayStudents() {
inorderTraversal(root);
}
private void inorderTraversal(BSTNode node) {

if (node != null) {

inorderTraversal(node.left);

System.out.println(node.student);

inorderTraversal(node.right);
}
}

public Student search(String studentId) {
return searchRecursive(root, studentId);
}
private Student searchRecursive(BSTNode node, String studentId) {

if (node == null) {
return null;
}

if (studentId.equals(node.student.getStudentId())) {
return node.student;
}

if (studentId.compareTo(node.student.getStudentId()) < 0) {
return searchRecursive(node.left, studentId);
}

return searchRecursive(node.right, studentId);
}


}
