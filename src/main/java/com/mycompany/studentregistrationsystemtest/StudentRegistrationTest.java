/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentregistrationsystemtest;

import com.mycompany.studentregistrationsystem.CourseProgramme;
import com.mycompany.studentregistrationsystem.Module;
import com.mycompany.studentregistrationsystem.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Joe
 */
public class StudentRegistrationTest {
    
    public static void main(String[] args) {
        
        // Creating the students, modules and course programmes
        
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Joe", 20, new Date(97, 2, 12), 14457102));
        students.add(new Student("Luke", 21, new Date(96, 9, 25), 1457809));
        students.add(new Student("Brian", 21, new Date(96, 7, 20), 1445442));
        students.add(new Student("Eoghan", 21, new Date(96, 4, 15), 1445899));
        students.add(new Student("Emma", 21, new Date(97, 1, 7), 1456721));
        students.add(new Student("Kieran", 20, new Date(97, 4, 24), 1458834));
        students.add(new Student("Shane", 20, new Date(97, 5, 12), 1450914));
        students.add(new Student("Dara", 20, new Date(97, 1, 11), 1447091));
        students.add(new Student("Cian", 20, new Date(97, 2, 9), 1443244));
        students.add(new Student("Katie", 22, new Date(95, 8, 24), 1454961));
        
        List<Module> modules = new ArrayList<Module>();
        modules.add(new Module("Software Engineering III", "CT417"));
        modules.add(new Module("Graphics and Image Processing", "CT404"));
        modules.add(new Module("Systems Modelling and Simulation", "CT561"));
        modules.add(new Module("Modern Information Management", "CT422"));
        modules.add(new Module("Machine Learning and Data Mining", "CT475"));
        
        List<CourseProgramme> courseProgrammes = new ArrayList<CourseProgramme>();
        courseProgrammes.add(new CourseProgramme("Computer Science and Information Technology", new DateTime(17, 9, 1, 0, 0), new DateTime(17, 12, 8, 0, 0)));
        courseProgrammes.add(new CourseProgramme("Computer Engineering", new DateTime(17, 9, 1, 0, 0), new DateTime(17, 12, 8, 0, 0)));
        
        // Assigning students to modules, and modules to course programmes
        
        modules.get(0).addStudent(students.get(0));
        modules.get(0).addStudent(students.get(2));
        modules.get(0).addStudent(students.get(5));
        modules.get(0).addStudent(students.get(7));
        modules.get(0).addStudent(students.get(8));
        
        modules.get(1).addStudent(students.get(0));
        modules.get(1).addStudent(students.get(2));
        modules.get(1).addStudent(students.get(5));
        modules.get(1).addStudent(students.get(7));
        modules.get(1).addStudent(students.get(8));
        
        modules.get(2).addStudent(students.get(6));
        modules.get(2).addStudent(students.get(2));
        modules.get(2).addStudent(students.get(5));
        modules.get(2).addStudent(students.get(4));
        modules.get(2).addStudent(students.get(7));
        modules.get(2).addStudent(students.get(9));
        
        modules.get(3).addStudent(students.get(1));
        modules.get(3).addStudent(students.get(3));
        modules.get(3).addStudent(students.get(4));
        modules.get(3).addStudent(students.get(7));
        modules.get(3).addStudent(students.get(9));
        
        modules.get(4).addStudent(students.get(1));
        modules.get(4).addStudent(students.get(3));
        modules.get(4).addStudent(students.get(4));
        modules.get(4).addStudent(students.get(7));
        modules.get(4).addStudent(students.get(9));
        
        courseProgrammes.get(0).addModule(modules.get(0));
        courseProgrammes.get(0).addModule(modules.get(1));
        courseProgrammes.get(0).addModule(modules.get(2));
        
        courseProgrammes.get(1).addModule(modules.get(2));
        courseProgrammes.get(1).addModule(modules.get(3));
        courseProgrammes.get(1).addModule(modules.get(4));
        
        // List all the students, their assigned modules and the course they are registered for and print to the console
        
        for (Student student : students) {
            String output = "\nName: " + student.getName() + "\n";
            output += "Age: " + student.getAge() + "\n";
            output += "DOB: " + student.getDOB() + "\n";
            output += "ID: " + student.getID() + "\n";
            output += "Username: " + student.getUsername() + "\n";
            
            List<CourseProgramme> studentsCourses = new ArrayList<CourseProgramme>();
            List<Module> studentsModules = new ArrayList<Module>();
            for (CourseProgramme courseProgramme : courseProgrammes) {
                boolean isStudentsCourse = false;
                for (Module module : modules) {
                    if (courseProgramme.getModuleByName(module.getName()) != null) {
                        if (module.getStudentByName(student.getName()) != null) {
                            isStudentsCourse = true;
                            if(studentsModules.isEmpty()) {
                                studentsModules.add(module);
                            }
                            else {
                                boolean isStudentsModule = true;
                                for (Module studentsModule : studentsModules) {
                                    if (studentsModule.getName().equals(module.getName())) {
                                        isStudentsModule = false;
                                    }
                                }
                                if (isStudentsModule) {
                                    studentsModules.add(module);
                                }
                            }
                        }
                    }
                }
                if(isStudentsCourse) {
                    studentsCourses.add(courseProgramme);
                }
            }
            
            output += "Modules: \n";
            
            for (Module module : studentsModules) {
                output += "   Module: " + module.getName() + "\n";
                output += "   Module ID: " + module.getID() + "\n";
            }
            
            output += "Course Programmes: \n";
            
            for (CourseProgramme courseProgramme : studentsCourses) {
                output += "   Course Programme: " + courseProgramme.getName() + "\n";
                output += "   Academic Start Date: " + courseProgramme.getStartDate() + "\n";
                output += "   Academic End Date: " + courseProgramme.getEndDate() + "\n"; 
            }
            
            /*for (Module module : modules) {
                if (module.getStudentByName(student.getName()) != null) {
                    outputM += "   Module: " + module.getName() + "\n";
                    outputM += "   Module ID: " + module.getID() + "\n";
                }
                
                String outputCP = "Course Programmes: \n";
            
                for (CourseProgramme courseProgramme : courseProgrammes) {
                    if (courseProgramme.getModuleByName(module.getName()) != null) {
                        outputCP += "   Course Programme: " + courseProgramme.getName() + "\n";
                        outputCP += "   Academic Start Date: " + courseProgramme.getStartDate() + "\n";
                        outputCP += "   Academic End Date: " + courseProgramme.getEndDate() + "\n";
                    }
                }
            }*/
            
            
            
            System.out.println(output);
        }
        
    }
    
}
