package com.knoldus;

import java.util.*;

class ClassRoom {
    int roomId;
    Optional<List<Student>> studentList;


    public ClassRoom(int roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }

    public boolean hasStudent() {
        long count = studentList.get().stream()
                .filter(student -> student.subjects.get().size() == 0)
                .count();
        if(count != 0) return true;
        else return false;
    }

    public boolean studentsWithParticularRoomId() {
        studentList.get().stream()
                .filter(student -> this.roomId == roomId)
                .forEach(student -> System.out.println("Student name : " + student.name + ", Student subjects :" + student.subjects +", Student room Id :" + student.roomID));
        return true;
    }

    public void studentWithNoSubjects() {
        studentList.get().stream()
                .filter(student -> student.subjects.get().size() == 0)
                .forEach(student -> System.out.println("Student which has no subjects associated with it "+student.name));
    }
}

class Student {
    String name;
    int rollNumber;
    Optional<List<String>> subjects;
    int roomID;

    public Student(String name, int rollNumber, Optional<List<String>> subjects, int roomID) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        this.roomID = roomID;
    }

}

class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Physics");
        list1.add("Chemistry");

        Optional<List<String>> subjectList1 = Optional.of(list1);

        Student s1 = new Student("A",2,subjectList1, 121);

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("C++");

        Optional<List<String>> subjectList2 = Optional.of(list2);

        Student s2 = new Student("C",1,subjectList2, 121);

        List<String> list3 = new ArrayList<>();

        Optional<List<String>> subjectList3 = Optional.of(list3);

        Student s3 = new Student("B",3,subjectList3, 121);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Optional<List<Student>> studentList = Optional.of(students);

        ClassRoom room = new ClassRoom(121,studentList);

        //Student with no associated subjects
        room.studentWithNoSubjects();

        // students with particular room ID
        boolean flag1 =  room.studentsWithParticularRoomId();
       // System.out.println(flag1);

        // If a room has students associated with it or not
        boolean flag = room.hasStudent();

        if(flag) {
            System.out.println("Hello Students!");
        }
        else {
            System.out.println("Room " + room.roomId + "has no students in it");
        }
    }
}
