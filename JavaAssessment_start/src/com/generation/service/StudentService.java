package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Person;
import com.generation.model.Student;

import javax.sound.midi.Soundbank;
import java.util.HashMap;

public class StudentService
{
    //property
    private final HashMap<String, Student> students = new HashMap<>();

    //methods

    //Adds a student object to hashmap students
    public void registerStudent( Student student )
    {
        this.students.put(student.getId(), student);
    }


    //findStudent method which returns a student object
    public Student findStudent( String studentId )
    {
        return this.students.get(studentId);
    }


    //confirms student is registered then get and adds student object to enrollToCourse method
    public void enrollToCourse( String studentId, Course course )
    {
        if (this.students.containsKey(studentId)) {
            Student getStudent = findStudent(studentId);
            getStudent.enrollToCourse(course);
        }
    }


    //to print all student details including hashmap
    public void showSummary()
    {
        for (String i : students.keySet()) {
            Student getStudent = findStudent(i);
            String getEnrolledCourses = enrolledCourses(getStudent).toString();
            System.out.println(getStudent + getEnrolledCourses);

        }
    }


    //to return a hashmap of a student's enrolled courses by passing in a student object
    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        return student.getEnrolledCourses();
    }


    //to return the course enrolled by a student - returns a Course object by passing in Student object and String
    // courseID
    public Course findEnrolledCourse( Student student, String courseId )
    {
        return student.findCourseById(courseId);
    }


    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }



}//End of StudentService Class

