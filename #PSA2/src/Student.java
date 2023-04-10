public class Student {
    private String fName;
    private String sName;
    private String dob;
    private String gender;
    private String studyMode;
    private int year;
    private int numModules;
    private double tuitionFee;

    public Student(String fName, String sName, String dob, String gender, String studyMode, int year, int numModules,
            double tuitionFee) {
        this.fName = fName;
        this.sName = sName;
        this.dob = dob;
        this.gender = gender;
        this.studyMode = studyMode;
        this.year = year;
        this.numModules = numModules;
        this.tuitionFee = tuitionFee;
    }

    public String getFirstName() {
        return fName;
    }

    public String getSecondName() {
        return sName;
    }

    public String getStudyMode() {
        return studyMode;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public int getYear() {
        return year;
    }

    public int getNumModules() {
        return numModules;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void displayDetails() {
        System.out.println("\nFirst Name: " + fName);
        System.out.println("Second Name: " + sName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Study Mode: " + studyMode);
        System.out.println("Year: " + year);
        System.out.println("Number of Modules: " + numModules);
        System.out.println("Tuition cost: " + tuitionFee);
    }

}
