import java.util.Scanner;

public class Testcase1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        input.nextLine();

        String[] studentNames = new String[numStudents];
        double[] averageScores = new double[numStudents];
        char[] letterGrades = new char[numStudents];

        System.out.print("Enter the number of assignments: ");
        int numAssignments = input.nextInt();

        for (int i = 0; i < numStudents; i++) {
            input.nextLine();
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = input.nextLine();

            double totalScore = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                totalScore += input.nextDouble();
            }

            averageScores[i] = totalScore / numAssignments;

            if (averageScores[i] >= 90) {
                letterGrades[i] = 'A';
            } else if (averageScores[i] >= 80) {
                letterGrades[i] = 'B';
            } else if (averageScores[i] >= 70) {
                letterGrades[i] = 'C';
            } else if (averageScores[i] >= 60) {
                letterGrades[i] = 'D';
            } else {
                letterGrades[i] = 'F';
            }
        }

        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames[i] + ": Average Score = " + averageScores[i] + ", Grade = " + letterGrades[i]);
        }

        double classTotal = 0;
        for (double score : averageScores) {
            classTotal += score;
        }
        double classAverage = classTotal / numStudents;
        System.out.println("\nClass Average Score: " + classAverage);

        double highestScore = averageScores[0];
        double lowestScore = averageScores[0];
        for (double score : averageScores) {
            if (score > highestScore) {
                highestScore = score;
            }
            if (score < lowestScore) {
                lowestScore = score;
            }
        }
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);
    }
}
