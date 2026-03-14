package assessment.week_3_Ques_4.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GymService service = new GymService();
        int choice = 0;

        do {

            System.out.println("\n----- Gym Workout System -----");
            System.out.println("1. Add Member");
            System.out.println("2. Search Member");
            System.out.println("3. Update Workout Duration");
            System.out.println("4. Delete Member");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    try {
                        System.out.print("Enter name: ");
                        String name = sc.next();

                        System.out.print("Enter membership type: ");
                        String membership = sc.next();

                        System.out.print("Enter exercise name: ");
                        String exercise = sc.next();

                        System.out.print("Enter duration (minutes): ");
                        int duration = sc.nextInt();

                        System.out.print("Enter workout date (yyyy-MM-dd): ");
                        String date = sc.next();

                        service.addMember(name, membership, exercise, duration, date);

                    } catch (Exception e) {
                        System.out.println("Invalid input format.");
                        sc.nextLine();
                    }

                    break;

                case 2:

                    try {
                        System.out.print("Enter Member ID: ");
                        int id = sc.nextInt();
                        service.searchMember(id);
                    } catch (Exception e) {
                        System.out.println("Invalid ID input.");
                        sc.nextLine();
                    }

                    break;

                case 3:

                    try {
                        System.out.print("Enter Member ID: ");
                        int memberId = sc.nextInt();

                        System.out.print("Enter Workout ID: ");
                        int workoutId = sc.nextInt();

                        System.out.print("Enter New Duration: ");
                        int newDuration = sc.nextInt();

                        service.updateWorkout(memberId, workoutId, newDuration);

                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }

                    break;

                case 4:

                    try {
                        System.out.print("Enter Member ID to delete: ");
                        int deleteId = sc.nextInt();
                        service.deleteMember(deleteId);
                    } catch (Exception e) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                    }

                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}