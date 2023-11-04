package mtom.controller;

import mtom.dao.CoursesDao;
import mtom.dao.StudentDao;
import mtom.dto.Courses;
import mtom.dto.Student;

public class Main {
public static void main(String[] args) {
//	Courses courses=new Courses();
//	courses.setId(2);
//	courses.setName("Advjava");
//	courses.setFees(10000);
//	
//	
//	CoursesDao coursesDao=new CoursesDao();
//	coursesDao.saveCourses(courses);
//	Student student=new Student();
//	student.setId(100);
//	student.setName("shreya");
//	student.setAddress("mumbai");
//	
//	StudentDao studentDao=new StudentDao();
//	studentDao.saveStudent(2, student);
	
	CoursesDao coursesDao=new CoursesDao();
//	coursesDao.deleteCoursesById(1);
	StudentDao studentDao=new StudentDao();
	studentDao.deleteStudent(100);
	
	
	
	
	
	
	
	
}
}
