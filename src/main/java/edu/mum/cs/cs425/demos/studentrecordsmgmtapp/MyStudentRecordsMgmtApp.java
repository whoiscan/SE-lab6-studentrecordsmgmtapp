package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        initStudents();
        printStudents(students);
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents();
        System.out.println("<------------------------------->");
        System.out.println("PLATINUM ALUMNI STUDENTS");
        printStudents(platinumAlumniStudents);

        System.out.println("<------------------------------->");
        System.out.println("HELLO WORLD!");
        printHelloWorld(new int[]{1, 5, 7, 35, 4});

        System.out.println("<------------------------------->");
        System.out.println("NEXT BIGGEST");
        System.out.println(findSecondBiggest(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findSecondBiggest(new int[]{19, 9, 11, 0, 12}));
    }

    private static void initStudents() {
        students.add(new Student(110001, "Dave", LocalDate.of(1951, 11, 18)));
        students.add(new Student(110002, "Anna", LocalDate.of(1990, 7, 12)));
        students.add(new Student(110003, "Erica", LocalDate.of(1974, 1, 31)));
        students.add(new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)));
        students.add(new Student(110005, "Bob", LocalDate.of(1990, 3, 5)));
    }

    private static void printStudents(List<Student> list) {
        list.forEach(System.out::println);
    }

    private static List<Student> getListOfPlatinumAlumniStudents() {
        List<Student> studentList = new ArrayList<>();
        for (Student s : students) {
            if (s.getDateOfAdmission().isBefore(LocalDate.now().minusYears(30))) {
                studentList.add(s);
            }
        }
        return studentList;
    }

    private static void printHelloWorld(int[] numbers) {
        for (int i : numbers) {
            if (i % 5 == 0) System.out.print("Hello");
            if (i % 7 == 0) System.out.println("World");
        }
    }

    private static int findSecondBiggest(int[] numbers) {
        int currentMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : numbers) {
            if (i > currentMax) {
                max = currentMax;
                currentMax = i;
            } else if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
