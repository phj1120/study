package entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * https://docs.jboss.org/hibernate/orm/5.1/quickstart/html_single/#hibernate-gsg-tutorial-basic-config
 * https://github.com/halyph/hibernate-tutorials/blob/master/entitymanager/src/test/resources/META-INF/persistence.xml
 */
public class EntityManagerStudy {

    @Test
    public void name() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member(1L, "phj");
            em.persist(member);

            Team team = new Team(1L);
            em.persist(team);

            Member findMember = em.find(Member.class, 1L);
            Team findTeam = em.find(Team.class, 1L);

            System.out.println(findTeam);
            System.out.println(findMember);
            tx.commit();
        } catch (Exception e) {
            System.out.println("[Error Message] : " + e);
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    public void sessionFactory() {
        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Member member = new Member(1L, "phj");
        entityManager.persist(member);

        List<Member> members = entityManager.createQuery("from Member", Member.class).getResultList();
        for (Member mem : members) {
            System.out.println(mem);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}


