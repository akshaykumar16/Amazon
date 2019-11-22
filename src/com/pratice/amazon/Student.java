package com.pratice.amazon;

import java.util.Comparator;

public class Student implements Comparable<Student>{

    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student student) {

        if(student.marks==this.marks)
        {
            if(student.name.compareTo(this.name)<0)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }

        else if(student.marks>this.marks)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
