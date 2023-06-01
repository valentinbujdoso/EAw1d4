package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all students
        TypedQuery<Students> query = em.createQuery("from cs544.Students ", Students.class);
        List<Students> studentList = query.getResultList();
        for (Students student : studentList) {
            System.out.println("Student: " + student.getName());
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Students student1 = new Students(777 ,"Name", "Email", "Pwd");
        em.persist(student1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all students
        query = em.createQuery("from cs544.Students ", Students.class);
        studentList = query.getResultList();
        for (Students student : studentList) {
            System.out.println("Student: " + student.getName());
        }
        em.getTransaction().commit();
        em.close();
    }
}
