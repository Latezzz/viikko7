package main;
import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    Enrollment newEnrollment = null;

    private int i;

    public Gifu(String university){
        this.university = university;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listCourses() {
        i = 0;
        for (Course course : courses) {
            System.out.println(i + ") " + course.getInformation());
            i++;
        }
    }

    public void listStudents() {
        i = 0;
        for (Student student : students) {
            System.out.println(i + ") " + student.getInformation());
            i++;
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }

    public ArrayList<Enrollment> getEnrolments(Course course) {
        ArrayList<Enrollment> enrollmentsForCourse = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse() == course) {
                enrollmentsForCourse.add(enrollment);
            }
        }
        return enrollmentsForCourse;
    }

    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> enrollmentsForStudent = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent() == student) {
                enrollmentsForStudent.add((enrollment));
            }
        }
        return enrollmentsForStudent;
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public void enrollStudent(Student s, Course c) {
        newEnrollment = new Enrollment(s, c);
        enrollments.add(newEnrollment);
    }


            
        
    
}
