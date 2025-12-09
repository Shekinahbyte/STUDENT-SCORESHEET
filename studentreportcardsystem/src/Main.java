import java.util.Scanner;

public class Main {

    public static char computeGrade(double mark) {
        if (mark >= 80) return 'A';
        else if (mark >= 70) return 'B';
        else if (mark >= 60) return 'C';
        else if (mark >= 50) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== School Details =====
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter Grade: ");
        int grade = sc.nextInt();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        // ===== Student Count =====
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        String[] names = new String[n];
        double[] eng = new double[n];
        double[] math = new double[n];
        double[] hist = new double[n];
        double[] geo = new double[n];
        double[] sci = new double[n];
        double[] prog = new double[n];
        double[] total = new double[n];
        char[] gradeLetter = new char[n];

        // Grade counters
        int countA=0, countB=0, countC=0, countD=0, countF=0;

        // ===== Input Student Data =====
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("English: ");
            eng[i] = sc.nextDouble();
            System.out.print("Math: ");
            math[i] = sc.nextDouble();
            System.out.print("History: ");
            hist[i] = sc.nextDouble();
            System.out.print("Geography: ");
            geo[i] = sc.nextDouble();
            System.out.print("Science: ");
            sci[i] = sc.nextDouble();
            System.out.print("Programming: ");
            prog[i] = sc.nextDouble();
            sc.nextLine();

            total[i] = eng[i] + math[i] + hist[i] + geo[i] + sci[i] + prog[i];
            gradeLetter[i] = computeGrade(total[i] / 6);

            // Count Grades
            switch (gradeLetter[i]) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                default: countF++; break;
            }
        }

        // ===== Compute Class Statistics =====
        double sumEng=0, sumMath=0, sumHist=0, sumGeo=0, sumSci=0, sumProg=0, sumTotal=0;

        for (int i = 0; i < n; i++) {
            sumEng += eng[i];
            sumMath += math[i];
            sumHist += hist[i];
            sumGeo += geo[i];
            sumSci += sci[i];
            sumProg += prog[i];
            sumTotal += total[i];
        }

        // ===== OUTPUT SECTION =====
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                  School Name:   " + schoolName);
        System.out.println("                      Teacher:   " + teacherName);
        System.out.println("                        Grade:   " + grade);
        System.out.println("                         Year:   " + year);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-20s %8s %8s %8s %10s %8s %12s %10s %6s\n",
                "Student Name", "English", "Math", "History",
                "Geography", "Science", "Programming", "Total", "Rank");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %10.2f %6c\n",
                    names[i], eng[i], math[i], hist[i], geo[i],
                    sci[i], prog[i], total[i], gradeLetter[i]);
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %10.2f\n",
                "Totals:", sumEng, sumMath, sumHist, sumGeo, sumSci, sumProg, sumTotal);

        System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %10.2f\n",
                "Averages:", sumEng/n, sumMath/n, sumHist/n, sumGeo/n, sumSci/n, sumProg/n, sumTotal/n);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Grade Counts:");
        System.out.println("A's: " + countA + "   B's: " + countB + "   C's: " + countC +
                "   D's: " + countD + "   F's: " + countF);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}