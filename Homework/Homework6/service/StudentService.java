package Homework.Homework6.service;

import Homework.Homework6.StudentMethods;
import Homework.Homework6.model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class StudentService implements StudentMethods {
    private Student[] arrayOfStudents = create();

    public StudentService() throws Exception {
    }

    private static Student[] create() throws Exception {
        Scanner s = new Scanner(System.in);
        File file = new File(s.nextLine());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String eachLine;
        String[] arrayOfStrings = new String[(int) file.length()];
        int index = 0;
        while ((eachLine = br.readLine()) != null) {
            arrayOfStrings[index++] = eachLine;
        }
        Student[] students = new Student[index];
        index = 0;
        int indexOfStudents = 0;
        while (indexOfStudents < students.length) {
            String[] studentInfo = arrayOfStrings[index++].split(",");
            students[indexOfStudents] = new Student();
            students[indexOfStudents].setFirstName(studentInfo[0]);
            students[indexOfStudents].setLastName(studentInfo[1]);
            students[indexOfStudents].setYear(Integer.parseInt(studentInfo[2]));
            students[indexOfStudents].setGender(studentInfo[3]);
            students[indexOfStudents].setMark(Double.parseDouble(studentInfo[4]));
            indexOfStudents++;
        }
        return students;
    }

    @Override
    public void printFullNames() {
        for (int i = 0; i < arrayOfStudents.length; i++) {
            System.out.println(arrayOfStudents[i].getFirstName() + " " + arrayOfStudents[i].getLastName());
        }
    }


    @Override
    public void printMaleStudents() {
        for (int i = 0; i < arrayOfStudents.length; i++) {
            if (arrayOfStudents[i].getGender().equals("m")) {
                System.out.println(arrayOfStudents[i].getFirstName() + " " + arrayOfStudents[i].getLastName());
            }
        }
    }

    @Override
    public void printFemaleStudentsGreater50_4() {
        for (int i = 0; i < arrayOfStudents.length; i++) {
            if (arrayOfStudents[i].getGender().equals("f") && arrayOfStudents[i].getMark() > 50.4) {
                System.out.println(arrayOfStudents[i].getFirstName() + " " + arrayOfStudents[i].getLastName());
            }
        }
    }

    @Override
    public void printStudentLowestMark() {
        Student minMark = arrayOfStudents[0];
        for (int i = 1; i < arrayOfStudents.length; i++) {
            if (arrayOfStudents[i].getMark() < minMark.getMark()) {
                minMark = arrayOfStudents[i];
            }
        }
        System.out.println("Firstname is " + minMark.getFirstName());
        System.out.println("Lastname is " + minMark.getLastName());
        System.out.println("Year is " + minMark.getYear());
        if (minMark.getGender().equals("m")) {
            System.out.println("Gender is male");
        } else {
            System.out.println("Gender is female");
        }
        System.out.println("Mark is " + minMark.getMark());
    }

    @Override
    public void printOldestMaleStudent() {
        Student oldestStudent = arrayOfStudents[0];
        int i = 0;

        while (i < arrayOfStudents.length) {
            if (arrayOfStudents[i].getGender().equals("m")) {
                oldestStudent = arrayOfStudents[i++];
                break;
            }
            i++;
        }
        while (i < arrayOfStudents.length) {
            if (arrayOfStudents[i].getGender().equals("m") && oldestStudent.getYear() > arrayOfStudents[i].getYear()) {
                oldestStudent = arrayOfStudents[i++];
            } else {
                i++;
            }
        }


        System.out.println("Firstname is " + oldestStudent.getFirstName());
        System.out.println("Lastname is " + oldestStudent.getLastName());
        System.out.println("Year is " + oldestStudent.getYear());
        System.out.println("Gender is male");
        System.out.println("Mark is " + oldestStudent.getMark());
    }

    @Override
    public void printStudentsSortedByMark() {
        for (int i = 0; i < arrayOfStudents.length - 1; i++) {
            boolean swapped = true;
            for (int j = 0; j < arrayOfStudents.length - i - 1; j++) {
                if (arrayOfStudents[j].getMark() > arrayOfStudents[j + 1].getMark()) {
                    Student temp = arrayOfStudents[j];
                    arrayOfStudents[j] = arrayOfStudents[j + 1];
                    arrayOfStudents[j + 1] = temp;
                    swapped = false;
                }
            }
            if (swapped)
                break;
        }
        for (int i = 0; i < arrayOfStudents.length; i++) {
            System.out.println(arrayOfStudents[i].getFirstName() + " " + arrayOfStudents[i].getLastName() + " " + arrayOfStudents[i].getMark());
        }
    }

    @Override
    public void printFemaleStudentsSortedByYear() {
        for (int i = 0; i < arrayOfStudents.length - 1; i++) {
            boolean swapped = true;
            for (int j = 0; j < arrayOfStudents.length - i - 1; j++) {
                if (arrayOfStudents[j].getYear() > arrayOfStudents[j + 1].getYear()) {
                    Student temp = arrayOfStudents[j];
                    arrayOfStudents[j] = arrayOfStudents[j + 1];
                    arrayOfStudents[j + 1] = temp;
                    swapped = false;
                }
            }
            if (swapped)
                break;
        }

        for (int i = 0; i < arrayOfStudents.length; i++) {
            if (arrayOfStudents[i].getGender().equals("f")) {
                System.out.println(arrayOfStudents[i].getFirstName() + " " + arrayOfStudents[i].getLastName() + " " + arrayOfStudents[i].getYear());
            }
        }
    }

}
