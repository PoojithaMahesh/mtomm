package mtom.controller;

import mtom.dao.CoursesDao;
import mtom.dao.StudentDao;
import mtom.dto.Courses;
import mtom.dto.Student;

public class Main {
public static void main(String[] args) {
//	Courses courses=new Courses();
//	courses.setId(1);
//	courses.setName("java");
//	courses.setFees(10000);
//	
//	
//	CoursesDao coursesDao=new CoursesDao();
//	coursesDao.saveCourses(courses);
	Student student=new Student();
	student.setId(1);
	student.setName("shreya");
	student.setAddress("mumbai");
	
	StudentDao studentDao=new StudentDao();
	studentDao.saveStudent(1, student);
}
}
