package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String name;
        String id;
        int idint;
        
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        if (sc.hasNext()) {
            String university = sc.nextLine();
            Gifu gifu = new Gifu(university);    
            Course newCourse = null;
            Student newStudent = null;

            

            boolean exit = false;
            
            while (!exit) {
                System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");

                if (sc.hasNext()) {
                    int i = Integer.parseInt(sc.nextLine());

                    switch (i) {
                        case 1:
                            System.out.println("Anna kurssin nimi:");
                            name = sc.nextLine();
                            System.out.println("Anna kurssin ID:");
                            id = sc.nextLine();
                            System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                            int maxNumberOfStudents = Integer.parseInt(sc.nextLine());

                            newCourse = new Course(maxNumberOfStudents, name, id);
                            gifu.addCourse(newCourse);
                            break;

                        case 2:
                            System.out.println("Anna opiskelijan nimi:");
                            name = sc.nextLine();
                            System.out.println("Anna opiskelijan opiskelijanumero:");
                            id = sc.nextLine();

                            newStudent = new Student(name, id);
                            gifu.addStudent(newStudent);
                            break;

                        case 3:
                            gifu.listCourses();
                            break;

                        case 4:
                            gifu.listStudents();
                            break;

                        case 5:
                            gifu.listCourses();
                            System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                            idint = Integer.parseInt(sc.nextLine());
                            Course c1 = gifu.getCourse(idint);

                            gifu.listStudents();
                            System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                            idint = Integer.parseInt(sc.nextLine());
                            Student s1 = gifu.getStudent(idint);

                            gifu.enrollStudent(s1, c1);
                            
                            break;

                        case 6:
                            gifu.listCourses();
                            System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                            idint = Integer.parseInt(sc.nextLine());
                            Course c2 = gifu.getCourse(idint);

                            ArrayList<Enrollment> e1 = gifu.getEnrolments(c2);
                            for (Enrollment enrollment : e1) {
                                Student s2 = enrollment.getStudent();
                                System.out.println("Anna arvosana opiskelijalle " + s2.getInformation());
                                int grade = Integer.parseInt(sc.nextLine());
                                enrollment.gradeCourse(grade);
                            }

                            break;

                        case 7:
                            gifu.listCourses();
                            System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                            idint = Integer.parseInt(sc.nextLine());
                            Course c3 = gifu.getCourse(idint);

                            ArrayList<Enrollment> e2 = gifu.getEnrolments(c3);
                            for (Enrollment enrollment : e2) {
                                Student s3 = enrollment.getStudent();
                                int grade = enrollment.getGrade();
                                System.out.println(s3.getInformation() + ", arvosana: " + grade);
                            }
                            break;

                        case 8:
                            gifu.listStudents();
                            System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                            idint = Integer.parseInt(sc.nextLine());
                            Student s4 = gifu.getStudent(idint);

                            System.out.println("Opiskelijan " + s4.getInformation() + " arvosanat:");
                            ArrayList<Enrollment> e3 = gifu.getEnrollments(s4);
                            for (Enrollment enrollment : e3) {
                                Course c4 = enrollment.getCourse();
                                System.out.println(c4.getInformation() + ", arvosana: " + enrollment.getGrade());                                
                            }
                            break;

                        case 9:
                            ArrayList<Course> c5 = gifu.getCourses();
                            for (Course course : c5) {
                                ArrayList<Enrollment> e5 = gifu.getEnrolments(course);
                                System.out.println(course.getInformation());
                                for (Enrollment enrollment : e5) {
                                    Student s5 = enrollment.getStudent();
                                    int grade = enrollment.getGrade();
                                    System.out.println(s5.getInformation() + ", arvosana: " + grade);
                                }
                            }                           
                            break;

                        case 0:
                            exit = true;
                            System.out.println("Kiitos ohjelman käytöstä.");
                            break;  

                        default:

                            break;
                    }
                }

            }



            sc.close();
        }
    }
}
