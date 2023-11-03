package mtom.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mtom.dto.Courses;
import mtom.dto.Student;

public class StudentDao {

	public void saveStudent(int coursesId,Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Courses dbCourses=entityManager.find(Courses.class, coursesId);
		if(dbCourses!=null) {
			List<Courses> courses=new ArrayList<Courses>();
			courses.add(dbCourses);
			student.setCourses(courses);
			entityTransaction.begin();
//			update the courses details
			List<Student>  students=dbCourses.getStudents();
			students.add(student);
			dbCourses.setStudents(students);
			
//			persist the student
			entityManager.persist(student);
			
			entityTransaction.commit();
			
		}
		
	}
	
	public void addCoursesToStudent(int coursesId,int studentId) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, studentId);
		if(dbStudent!=null) {
//			that student is a crct student so i should add the course to this student
			
			Courses dbCourses=entityManager.find(Courses.class, coursesId);
			if(dbCourses!=null) {
//				that courses is also present
//				here i need to update both courses and students
				List<Courses> courses =dbStudent.getCourses();
				courses.add(dbCourses);
//				im going set again
				dbStudent.setCourses(courses);
				
				
//				same with the courses
				List<Student> students=dbCourses.getStudents();
				students.add(dbStudent);
				dbCourses.setStudents(students);
				
			}else {
				System.out.println("course is not present");
			}
			
			
			
		}else {
			System.out.println("Sorry student id is not present");
		}
		
		
		
		
		
	}
	
	
	
	
	
}
