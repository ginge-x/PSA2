import java.util.Scanner;

public class enrolementRegister {
    private final int MAX_STUDENTS = 20;
    private int studentCount = 0;
    private Student[] students = new Student[MAX_STUDENTS];
    private Scanner ip = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        enrolementRegister myEnrolementRegister = new enrolementRegister();
        myEnrolementRegister.start();
    }

    private void start() {
        this.menu();
    }

    private void menu() {
        while (true) {
            System.out.println("\nCourse Enrollement System");
            System.out.println("1. Enroll Student");
            System.out.println(("2. View Student details"));
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = ip.nextInt();

            switch (choice) {
                case 1:
                    enrollStudent(ip);
                    break;
                case 2:
                    viewStudentDetails(ip);
                    break;
                case 3:
                    deleteStudent(ip);
                    break;
                case 4:
                    System.out.println("\nProgram Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid Choice! Please choose again!");
            }
        }
    }

    private void enrollStudent(Scanner ip) {
        if (studentCount == MAX_STUDENTS) {
            System.out.println("\nSorry! The maximum number of students have already been enrolled.");
            return;
        }

        System.out.println("\nEnter Student first name: ");
        String fName = ip.next();
        System.out.println("Enter Student second name: ");
        String sName = ip.next();
        System.out.println("Enter Student Date of Birth: ");
        String dob = ip.next();
        System.out.println("Enter Student Gender (M/F): ");
        char gender = ip.next().charAt(0);
        System.out.println("Enter Student Study Mode (PT/FT): ");
        String studyMode = ip.next();
        System.out.println("Enter Student Year (1-4): ");
        int year = ip.nextInt();
        System.out.println("Enter Number of Modules to be taken (1-6): ");
        int numModules = ip.nextInt();

        double tuitionFee = calculateTuitionFee(studyMode, year, numModules);

        students[studentCount] = new Student(fName, sName, dob, gender, studyMode, year, numModules, tuitionFee);
        studentCount++;

        System.out.println("\nStudent Enrolled Successfully!");
    }

    private void viewStudentDetails(Scanner ip) {
        if (studentCount == 0) {
            System.out.println("\nSorry! No students have been enrolled yet.");
            return;
        }

        System.out.println("\nEnter Student Name: ");
        String name = ip.next();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getFirstName().equals(name)) {
                students[i].displayDetails();
                return;
            }
        }

        System.out.println("\nSorry! No student has been found with that given name.");
    }

    private double calculateTuitionFee(String studyMode, int year, int numModules) {
        double tuitionFee = 0;

        if (studyMode.equals(("FT"))) {
            if (year == 3) {
                tuitionFee = 2500;
            } else {
                tuitionFee = 5000;
            }
        } else if (studyMode.equals(("PT"))) {
            tuitionFee = numModules * 750;
        }

        return tuitionFee;
    }

    private void deleteStudent(Scanner ip) {
        if (studentCount == 0) {
            System.out.println("\nSorry! No students have been enrolled yet.");
            return;
        }

        System.out.println("\nEnter Student First Name: ");
        String fName = ip.next();
        System.out.println("Enter Student Second Name: ");
        String sName = ip.next();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getFirstName().equals(fName) && students[i].getSecondName().equals(sName)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                System.out.println("\nStudent Deleted Successfully!");
                return;
            }
        }
    }
}
