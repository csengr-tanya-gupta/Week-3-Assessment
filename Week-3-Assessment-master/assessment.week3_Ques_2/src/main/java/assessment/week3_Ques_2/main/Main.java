package assessment.week3_Ques_2.main;

import assessment.week3_Ques_2.service.StudentService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        int choice = 0;

        do {

            System.out.println("\n1 Add Student");
            System.out.println("2 Search Student");
            System.out.println("3 Update Course");
            System.out.println("4 Delete Student");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = sc.next();

                    System.out.print("Enter course: ");
                    String course = sc.next();

                    System.out.print("Enter semester: ");
                    int sem = sc.nextInt();

                    service.addStudent(name, course, sem);

                    break;

                case 2:

                    System.out.print("Enter student id: ");
                    int id = sc.nextInt();

                    service.searchStudent(id);

                    break;

                case 3:

                    System.out.print("Enter student id: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.next();

                    service.updateCourse(sid, newCourse);

                    break;

                case 4:

                    System.out.print("Enter student id: ");
                    int del = sc.nextInt();

                    service.deleteStudent(del);

                    break;

                case 5:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid choice");

            }

        } while (choice != 5);

        sc.close();
    }
}