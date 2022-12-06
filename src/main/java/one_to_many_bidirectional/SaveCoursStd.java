package one_to_many_bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveCoursStd {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pawar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		List<Course>courses=new ArrayList<Course>();
		
		Student student=new Student();
		student.setName("aniket");
		student.setAddress("Mumbai");
		student.setMailid("aniket@71");
		student.setCourses(courses);
		
		
		Course course=new Course();
		course.setCourse_name("JAVA");
		course.setDuration("3 months");
		course.setStudent(student);
		
		Course course1=new Course();
		course1.setCourse_name("Web Tech");
		course1.setDuration("5 months");
		course1.setStudent(student);
		
		Course course2=new Course();
		course2.setCourse_name("SQL");
		course2.setDuration("7 months");
		course2.setStudent(student);
		
		
		courses.add(course);
		courses.add(course1);
		courses.add(course2);
		
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();
		
		System.out.println("All Ok");
		
		
		
	}
	
}
