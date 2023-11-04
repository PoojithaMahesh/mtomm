package mtom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mtom.dto.Courses;
import mtom.dto.Student;

public class CoursesDao {

	public void saveCourses(Courses courses) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
	}
	
	public void updateCourses(int id,Courses courses) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			courses.setId(id);
			courses.setStudents(dbCourses.getStudents());
			entityManager.merge(courses);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	public void findCourses(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
			System.out.println(dbCourses);
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	public void deleteCoursesById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			List<Student> students=dbCourses.getStudents();
			
			for(Student student:students) {
				List<Courses> courses=student.getCourses();
//				sql java adv java react
				courses.remove(dbCourses);
//				sql java react jsss
//				again after removing a particular courses im restting
//				the courses again
				student.setCourses(courses);
			}
			entityManager.remove(dbCourses);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
