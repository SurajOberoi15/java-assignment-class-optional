import java.util.*;

class ClassRoom {
    int roomId;
    Optional<List<Student>> studentList;

    public ClassRoom(int roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }
        // Checking that if the studentList has no students in a particular roomID
        public boolean hasStudent() {
            long count = studentList.get().size();
            return count != 0 ? true : false;
        }


    public void studentsWithParticularRoomId(int id) {
        studentList.orElse(null).stream()
                .filter(student -> this.roomId == id)
                .forEach(student -> System.out.println("Student name : " + student.name + ", Student subjects :" + student.subjects));

    }

    public void studentWithNoSubjects() {
        studentList.orElse(null).stream()
                .filter(student -> {
                    return student.subjects.orElse(null).size() == 0;
                })
                .forEach(student -> System.out.println("Student which has no subjects associated with it "+student.name));
    }
}

class Student {
    String name;
    int rollNumber;
    Optional<List<String>> subjects;

    public Student(String name, int rollNumber, Optional<List<String>> subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
    }

}

class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Physics");
        list1.add("Chemistry");

        Optional<List<String>> subjectList1 = Optional.of(list1);

        Student s1 = new Student("A",2,subjectList1);

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("C++");
        list2.add("Physics");

        Optional<List<String>> subjectList2 = Optional.of(list2);

        Student s2 = new Student("C",1,subjectList2);

        List<String> list3 = new ArrayList<>();

        Optional<List<String>> subjectList3 = Optional.of(list3);

        Student s3 = new Student("B",3,subjectList3);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Optional<List<Student>> studentList = Optional.of(students);

        ClassRoom room = new ClassRoom(121,studentList);

        //no subjects
        room.studentWithNoSubjects();

        //unique subject list
        room.studentsWithParticularRoomId(121);

        //if a room has students or not
        boolean flag = room.hasStudent();

        if(flag) {
            System.out.println("Hello Students!");
        }
        else {
            System.out.println("Room " + room.roomId + "has no students in it");
        }

    }
}