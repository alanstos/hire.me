package org.hire.me.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hire.me.model.Link;
import org.springframework.stereotype.Repository;

@Repository
public class LinkDao {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public Link findByAlias(String alias){
		
		if (alias == null)
			throw new IllegalArgumentException("param alias esta vazio");
		
		Link link = entityManager.createQuery("select l from Link l where l.alias = :alias ",Link.class)
				.setParameter("alias", alias)
				.getSingleResult();
		
		return link;	
	}
	
	public void salvar(Link link){
		entityManager.persist(link);
	}

}
