package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Pessoa;

public class JavaApplication {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Starter1", "starter1@email.com");
		Pessoa p2 = new Pessoa(null, "Starter2", "starter2@email.com");
		Pessoa p3 = new Pessoa(null, "Starter3", "starter3@email.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		System.out.println(p);
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Deletado com sucesso");
		
		
		em.close();
		emf.close();
	}

}
