package model;

public class IAMStudent {
    public String firstName;
    public String lastName;
    private int creditOfDifferentialEquation = 7;
    private int creditOfNumericalAnalysis = 6;
    private int creditOfFunctionalAnalysis = 5;
    private int creditOfOperatingSystem = 4;
    private int creditOfGUI = 4;
    private int gradeOfDifferentialEquation = 8;
    private int gradeOfNumericalAnalysis = 8;
    private int gradeOfFunctionalAnalysis = 8;
    private int gradeOfOperatingSystem = 8;
    private int gradeOfGUI = 8;
    private float GPA = 8F;
    private float sumOfCredits = this.creditOfDifferentialEquation + this.creditOfFunctionalAnalysis + this.creditOfGUI +
            this.creditOfNumericalAnalysis + this.creditOfOperatingSystem;

    public void getFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    public void setGradeOfDifferentialEquation(int gradeOfDifferentialEquation) {
        if (gradeOfDifferentialEquation >= 8 && gradeOfDifferentialEquation <= 20) {
            this.gradeOfDifferentialEquation = gradeOfDifferentialEquation;
        } else {
            System.out.println("Wrong grade of Differential equation");
        }
    }

    public void setGradeOFNumericalAnalysis(int gradeOFNumericalAnalysis) {
        if (gradeOFNumericalAnalysis >= 8 && gradeOFNumericalAnalysis <= 20) {
            this.gradeOfNumericalAnalysis = gradeOFNumericalAnalysis;
        } else {
            System.out.println("Wrong grade of Numerical analysis");
        }
    }

    public void setGradeOfFunctionalAnalysis(int gradeOfFunctionalAnalysis) {
        if (gradeOfFunctionalAnalysis >= 8 && gradeOfFunctionalAnalysis <= 20) {
            this.gradeOfFunctionalAnalysis = gradeOfFunctionalAnalysis;
        } else {
            System.out.println("Wrong grade of Functional analysis");
        }
    }

    public void setGradeOfOperatingSystem(int gradeOfOperatingSystem) {
        if (gradeOfOperatingSystem >= 8 && gradeOfOperatingSystem <= 20) {
            this.gradeOfOperatingSystem = gradeOfOperatingSystem;
        } else {
            System.out.println("Wrong grade of Operating System");
        }
    }

    public void setGradeOfGUI(int gradeOfGUI) {
        if (gradeOfGUI >= 8 && gradeOfGUI <= 20) {
            this.gradeOfGUI = gradeOfGUI;
        } else {
            System.out.println("Wrong grade of GUI");
        }
    }

    public float getGPA() {
        this.GPA = ((creditOfDifferentialEquation * gradeOfDifferentialEquation) + (creditOfNumericalAnalysis *
                gradeOfNumericalAnalysis) + (creditOfFunctionalAnalysis * gradeOfFunctionalAnalysis) +
                (creditOfOperatingSystem * gradeOfOperatingSystem) + (creditOfGUI * gradeOfGUI)) / sumOfCredits;
        return this.GPA;
    }


}
