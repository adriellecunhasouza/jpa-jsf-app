package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Cliente;

public class TesteJPA {

	public static void main(String[] args) {
/*		fabricaEntidades = Persistence.createEntityManagerFactory("EclipseLinkExemploPU");
		entitymanager = fabricaEntidades.createEntityManager();
		entitymanager.getTransaction().begin();
		*/
		
		
		EntityManager entityMgr = Persistence
        		.createEntityManagerFactory("EclipseLinkExemploPU")
        		.createEntityManager();
		System.out.println("Ok ----- JPA");
		
		 
		Query query = entityMgr.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		for (Cliente c1 : clientes) {
			System.out.println(c1.getNome() + " " + c1.getId());
		}
		
		
		
	/*	Cliente e = new Cliente();
		e.setId(22);
		e.setNome("Arroz");
		e.setEndereco("cccccc");
		entitymanager.persist(e);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		fabricaEntidades.close();
		System.out.println("BD Criado!!!");*/
        

	}

}
