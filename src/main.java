import java.util.Scanner;

import model.Student;
import linkedlist.StudentLinkedList;
import stackqueue.ActionStack;
import stackqueue.ServiceQueue;
import tree.BST;
import hashing.HashManager;
import graph.CampusGraph;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentLinkedList studentList = new StudentLinkedList();

    static ActionStack actionStack = new ActionStack(100);

    static ServiceQueue serviceQueue = new ServiceQueue(100);

    static BST bst = new BST();

    static HashManager hashManager = new HashManager();

    static CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        while (true) {

        System.out.println("\n===== University Student Record and Campus Route Management System =====");

        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records");

        System.out.println("5. Add Service Request");
        System.out.println("6. Process Next Service Request");

        System.out.println("7. Display Recent Actions");

        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");

        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");

        System.out.println("12. Add Campus Connection");
        System.out.println("13. Remove Campus Connection");

        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations (BFS)");

        System.out.println("16. Exit");

        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

                switch (choice) {

                case 1:

                System.out.print("Enter Student ID: ");
                String studentId = scanner.nextLine();

                if (hashManager.searchStudent(studentId) != null) {

                    System.out.println("Student ID already exists.");
                    break;
                }

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Programme: ");
                String programme = scanner.nextLine();

                System.out.print("Enter Marks: ");
                double marks = scanner.nextDouble();
                scanner.nextLine();

                if (marks < 0 || marks > 100) {

                    System.out.println("Invalid marks. Marks must be between 0 and 100.");

                    break;
                }

                Student student = new Student(
                        studentId,
                        name,
                        programme,
                        marks
                );

                studentList.addStudent(student);

                bst.insert(student);

                hashManager.addStudent(student);

                actionStack.push("Added Student: " + studentId);

                System.out.println("Student added successfully.");

                break;

            case 2:

                System.out.print("Enter Student ID to update: ");
                String updateId = scanner.nextLine();

                Student existingStudent = studentList.searchStudent(updateId);

                if (existingStudent == null) {
                    System.out.println("Student not found.");
                } else {

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Programme: ");
                    String newProgramme = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    if (newMarks < 0 || newMarks > 100) {

                        System.out.println("Invalid marks. Marks must be between 0 and 100.");

                        break;
                    }

                    boolean updated = studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks
                    );

                    if (updated) {

                        actionStack.push("Updated Student: " + updateId);

                        System.out.println("Student updated successfully.");
                    }
                }

                break;

            case 3:

                System.out.print("Enter Student ID to delete: ");
                String deleteId = scanner.nextLine();

                boolean deleted = studentList.deleteStudent(deleteId);

                if (deleted) {

                    hashManager.removeStudent(deleteId);

                    actionStack.push("Deleted Student: " + deleteId);

                    System.out.println("Student deleted successfully.");

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 4:

            studentList.displayStudents();

            break;

           case 5:

            System.out.print("Enter Service Request: ");
            String request = scanner.nextLine();

            serviceQueue.addRequest(request);

            actionStack.push("Added Service Request: " + request);

            System.out.println("Service request added successfully.");

            break;

            case 6:

            String processedRequest = serviceQueue.processRequest();

            if (processedRequest == null) {

                System.out.println("No pending service requests.");

            } else {

                System.out.println("Processed Request: " + processedRequest);

                actionStack.push("Processed Request: " + processedRequest);
            }

            break;

            case 7:

            actionStack.displayActions();

            break;

            case 8:

            bst.displayStudents();

            break;

            case 9:

            System.out.print("Enter Student ID to search: ");
            String searchId = scanner.nextLine();

            Student foundStudent = hashManager.searchStudent(searchId);

            if (foundStudent == null) {

                System.out.println("Student not found.");

            } else {

                System.out.println(foundStudent);
            }

            break;

            case 10:

            System.out.print("Enter Location Name: ");
            String location = scanner.nextLine();

            campusGraph.addLocation(location);

            actionStack.push("Added Location: " + location);

            System.out.println("Location added successfully.");

            break;

            case 11:

            System.out.print("Enter Location Name to Remove: ");
            String removeLocation = scanner.nextLine();

            campusGraph.removeLocation(removeLocation);

            actionStack.push("Removed Location: " + removeLocation);

            System.out.println("Location removed successfully.");

            break;

           case 12:

            System.out.print("Enter First Location: ");
            String location1 = scanner.nextLine();

            System.out.print("Enter Second Location: ");
            String location2 = scanner.nextLine();

            campusGraph.addConnection(location1, location2);

            actionStack.push("Added Connection: " + location1 + " - " + location2);

            System.out.println("Connection added successfully.");

            break;

            case 13:

            System.out.print("Enter First Location: ");
            String removeLocation1 = scanner.nextLine();

            System.out.print("Enter Second Location: ");
            String removeLocation2 = scanner.nextLine();

            campusGraph.removeConnection(removeLocation1, removeLocation2);

            actionStack.push("Removed Connection: "
                    + removeLocation1 + " - " + removeLocation2);

            System.out.println("Connection removed successfully.");

            break;

           case 14:

            campusGraph.displayConnections();

            break;

            case 15:

            System.out.print("Enter Starting Location: ");
            String startLocation = scanner.nextLine();

            campusGraph.bfsTraversal(startLocation);

            break;

            case 16:
                System.out.println("Exiting System...");
                return;

            default:
                System.out.println("Invalid Choice!");
        }

    }
}

}