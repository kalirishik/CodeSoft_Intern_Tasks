import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("|    Student Grade Calculator      |");
        System.out.println("------------------------------------");
        System.out.println("Enter 5 Subject Marks (Out Of 100)");
        System.out.print("Enter Mark Subject1 : ");
        int m1=sc.nextInt();
        System.out.print("Enter Mark Subject2 : ");
        int m2=sc.nextInt();
        System.out.print("Enter Mark Subject3 : ");
        int m3=sc.nextInt();
        System.out.print("Enter Mark Subject4 : ");
        int m4=sc.nextInt();
        System.out.print("Enter Mark Subject5 : ");
        int m5=sc.nextInt();
        int totalMarks=m1+m2+m3+m4+m5;
        int averagePercentage=(totalMarks/5);
        char grade;
        if (averagePercentage >= 90 && averagePercentage <= 100) {
            grade = 'A';
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            grade = 'B';
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            grade = 'C';
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            grade = 'D';
        } else if (averagePercentage >= 50 && averagePercentage < 60) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        System.out.println("------------------------------------");
        System.out.println("|          Your Result             |");
        System.out.println("------------------------------------");
        System.out.println("Total Marks : "+totalMarks+"\nAverage Percentage : "+averagePercentage+"\nGrade : "+grade);
        System.out.println("---------------------------------------------");
        System.out.println("| Thanks for Using Student Grade Calculator |");
        System.out.println("---------------------------------------------");

    }
}
