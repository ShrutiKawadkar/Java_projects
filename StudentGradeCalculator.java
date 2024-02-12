import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" STUDENT GRADE CACULATOR");
        System.out.println("Enter marks obtained in each subject (out of 100):");
        String subjects[]={"Java","C++","html","Javascript","Python"};
        int[] marks = new int[subjects.length]; // Assuming 5 subjects
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i]+": ");
            marks[i] = scanner.nextInt();
        }
        int totalMarks = 0;
        for (int i=0; i<marks.length; i++) {
            totalMarks += marks[i];
        }
        double averagePercentage =  (double)totalMarks / marks.length;

        // Grade calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'E';
        }
        System.out.println("\nStudent Results:");
        System.out.println("Total Marks obtained from 500: " + totalMarks);
        System.out.printf("Average Percentage: "+"%.2f%%\n",averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}