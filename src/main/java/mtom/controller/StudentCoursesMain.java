package mtom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mtom.dto.Courses;
import mtom.dto.Student;

public class StudentCoursesMain {
public static void main(String[] args) {
	Student  student1=new Student();
	student1.setId(1);
	student1.setName("Poojitha");
	student1.setAddress("Bangalore");
	
	Student  student2=new Student();
	student2.setId(2);
	student2.setName("Aman");
	student2.setAddress("Delhi");

	Courses courses1=new Courses();
	courses1.setId(1);
    courses1.setName("java");
    courses1.setFees(8000);
    
    Courses courses2=new Courses();
    courses2.setId(2);
    courses2.setName("AdvanceJava");
    courses2.setFees(10000);
    
    Courses courses3=new Courses();
    courses3.setId(3);
    courses3.setName("Sql");
    courses3.setFees(15000);
    
    
    
    List<Courses> coursesofPoojitha=new ArrayList<Courses>();
    coursesofPoojitha.add(courses1);
    coursesofPoojitha.add(courses2);
    coursesofPoojitha.add(courses3);
    
    
	student1.setCourses(coursesofPoojitha);
	
	
	student2.setCourses(coursesofPoojitha);
	
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	
	
	courses1.setStudents(students);
	
    courses2.setStudents(students);
    
    courses3.setStudents(students);
    
    
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(courses3);
	entityManager.persist(courses2);
	entityManager.persist(courses1);
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityTransaction.commit();
	
	
	
	
	
}
}
