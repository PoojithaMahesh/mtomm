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
	
	
	
	public void updateStudent(int id,Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			entityTransaction.begin();
			student.setId(id);
			student.setCourses(dbStudent.getCourses());
			entityManager.merge(student);
			entityTransaction.commit();
		}else {
			System.out.println("Id is not present");
		}
		
	}
	
	public void findStudent(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			System.out.println(dbStudent);
		}else {
			System.out.println("Id is not present");
		}
	}
	
	
	
	public void deleteStudent(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			entityTransaction.begin();
			List<Courses> courses=dbStudent.getCourses();
			for(Courses c:courses) {
				List<Student> students=c.getStudents();
				students.remove(dbStudent);
				c.setStudents(students);	
			}
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
