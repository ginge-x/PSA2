import java.util.Scanner;

public class enrolementRegister {
    private final int MAX_STUDENTS = 20;
    private int studentCount = 0;
    private Student[] students = new Student[MAX_STUDENTS];
    private Scanner ip = new Scanner(System.in);
    private String courseName = "Computer Science";

    public static void main(String[] args) throws Exception {
        enrolementRegister myEnrolementRegister = new enrolementRegister();
        myEnrolementRegister.start();
    }

    private void start() {
        this.menu();
    }

    private void menu() {
        while (true) {
            System.out.println("\n----------------------------------");
            System.out.println("Course Enrollement System");
            System.out.println("1. Enroll Student");
            System.out.println(("2. View Student details"));
            System.out.println("3. Delete Student");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.println("---------------------------------");
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
                    generateReport(ip);
                    break;
                case 5:
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
        String gender = ip.next();
        System.out.println("Enter Student Study Mode (PT/FT): ");
        String studyMode = ip.next();
        System.out.println("Enter Student Year (1-4): ");
        int year = ip.nextInt();
        System.out.println("Enter Number of Modules to be taken (1-6): ");
        int numModules = ip.nextInt();
        double tuitionFee = calculateTuitionFee(studyMode, year, numModules);

        if (fName.equals("") || sName.equals("") || dob.equals("") || studyMode.equals("") ||
                (gender != "M" && gender != "F") || year < 1 || year > 4 || numModules < 1
                || numModules > 6) {
            System.out.println("Error! All fields are required to enroll.");
            // return;
        } else {
            students[studentCount] = new Student(fName, sName, dob, gender, studyMode, year, numModules, tuitionFee);
            studentCount++;

            System.out.println("\nStudent Enrolled Successfully!");
        }

    }

    private void viewStudentDetails(Scanner ip) {
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
                students[i].displayDetails();
                return;
            }
        }

        System.out.println("\nSorry! No student has been found with that given name.");
    }

    private double calculateTuitionFee(String studyMode, int year, int numModules) {
        double tuitionFee = 0;

        if (studyMode.equalsIgnoreCase(("FT"))) {
            if (year == 3) {
                tuitionFee = 2500;
            } else {
                tuitionFee = 5000;
            }
        } else if (studyMode.equalsIgnoreCase(("PT"))) {
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

    private void generateReport(Scanner ip) {
        int numFT = 0;
        int numPT = 0;
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (students[i] != null) {
                if (students[i].getStudyMode().equals("FT")) {
                    numFT++;
                } else {
                    numPT++;
                }
            }
        }

        int numFTMale = 0;
        int numPTMale = 0;
        int numFTFemale = 0;
        int numPTFemale = 0;
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (students[i] != null) {
                if (students[i].getStudyMode().equalsIgnoreCase("FT")) {
                    if (students[i].getGender().equalsIgnoreCase("M")) {
                        numFTMale++;
                    } else {
                        numFTFemale++;
                    }
                } else {
                    if (students[i].getGender().equalsIgnoreCase("M")) {
                        numPTMale++;
                    } else {
                        numPTFemale++;
                    }
                }
            }
        }
        double percentageFTMale = (double) numFTMale / numFT * 100;
        double percentageFTFemale = (double) numFTFemale / numFT * 100;
        double percentagePTMale = (double) numPTMale / numPT * 100;
        double percentagePTFemale = (double) numPTFemale / numPT * 100;

        System.out.println("Course Name: " + courseName);
        System.out.println("Total number of students enrolled: " + studentCount);
        System.out.println("Number of Full Time students: " + numFT);
        System.out.println("  Male: " + numFTMale + " (" + percentageFTMale + "%)");
        System.out.println("  Female: " + numFTFemale + " (" + percentageFTFemale + "%)");
        System.out.println("Number of PT students: " + numPT);
        System.out.println("  Male: " + numPTMale + " (" + percentagePTMale + "%)");
        System.out.println("  Female: " + numPTFemale + " (" + percentagePTFemale + "%)");
    }
}
