package com.generation.model;

import com.generation.service.CourseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//property
public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();

//Constructor
    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

//Methods


//    public boolean enrollToCourse( Course course )
//    {
//        if (this.enrolledCourses.containsKey(course.getCode())) {
//            System.out.println("You're already enrolled to the course " + course);
//        }
//        this.enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
//        return false;
//    }


    //adds a course to hashmap enrolledCourses (enrolling a student to course)
    public boolean enrollToCourse( Course course )
    {
        if ( !enrolledCourses.containsKey( course.getCode() ) )
        {
            enrolledCourses.put( course.getCode(), new EnrolledCourse( course ) );
            return true;
        }
        return false;
    }


    //to return a student's enrolled courses hashmap
    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        return this.enrolledCourses;
    }


    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        EnrolledCourse getCourse = this.enrolledCourses.get(courseCode);
        if (grade >= 1 || grade <= 6 ) {
            getCourse.setGrade(grade);
        }
    }

    //findCourseById method takes a String key and returns Course object
    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id
        return this.enrolledCourses.get(courseId);
    }


    //TODO Check the enrolled courses grade and compare to the passing grade
    //returns a hashmap of passed courses
    public HashMap<String, EnrolledCourse> findPassedCourses() {

        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();

        for(EnrolledCourse course : enrolledCourses.values()) {
            if (course.getGrade() >= PASS_MIN_GRADE) {
                passedCourses.put(course.getCode(), course);
            }
        }
        return passedCourses;
    }



    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
