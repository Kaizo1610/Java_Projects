import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of students (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int numberOfStudents;
            try {
                numberOfStudents = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
                continue;
            }

            String[] studentNames = new String[numberOfStudents];
            int[] studentScores = new int[numberOfStudents];
            String[] studentGrades = new String[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter the name of student " + (i + 1) + ": ");
                studentNames[i] = scanner.nextLine();

                System.out.print("Enter the score of " + studentNames[i] + ": ");
                while (true) {
                    try {
                        studentScores[i] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid score. Please enter a valid score for " + studentNames[i] + ": ");
                    }
                }

                studentGrades[i] = calculateGrade(studentScores[i]);
            }

            printSummary(studentNames, studentScores, studentGrades);
        }

        scanner.close();
    }

    private static void printSummary(String[] names, int[] scores, String[] grades) {
        System.out.println("\nSummary of Students and Grades:");
        System.out.println("--------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Student: " + names[i] + " | Score: " + scores[i] + " | Grade: " + grades[i]);
        }
    }

    public static String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}