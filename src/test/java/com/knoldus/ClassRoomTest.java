package com.knoldus;

import org.junit.Test;
import java.util.*;


public class ClassRoomTest {

    @Test
    public void invalidTestCaseForHasStudent(){
        List<Student> students= new ArrayList<>();
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(121, studentList);

        assert(!room.hasStudent());
    }

    @Test
    public void validTestCaseForStudentsWithParticularRoomId(){
        Student student1 = new Student("Suraj Oberoi", 1,  Optional.of(Arrays.asList("Physics", "Chemistry")),121);
        Student student2 = new Student("Ankit Mogha", 2,  Optional.of(Arrays.asList("Physics", "Chemistry", "C++")),121);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(121,studentList);

        assert(room.studentsWithParticularRoomId());
    }

    @Test
    public void invalidTestCaseForStudentsWithParticularRoomId(){
        Student student1 = new Student("Suraj Oberoi", 1,  Optional.of(Arrays.asList("Physics", "Chemistry")), 121);
        Student student2 = new Student("Ankit Mogha", 2,  Optional.of(Arrays.asList("Physics", "Chemistry", "C++")), 121);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(111,studentList);

        assert(room.studentsWithParticularRoomId());
    }
}
