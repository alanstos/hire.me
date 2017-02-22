package org.hire.me.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hire.me.model.Link;
import org.springframework.stereotype.Repository;

@Repository
public class LinkDao {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public Link findByAlias(String alias){
		
		if (alias == null)
			throw new IllegalArgumentException("parametro alias esta vazio");
		
		try {
			
			Link link = entityManager.createQuery("select l from Link l where l.alias = :alias ",Link.class)
					.setParameter("alias", alias)
					.getSingleResult();
			
			return link;	
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void salvar(Link link){
		entityManager.persist(link);
	}

	public void updateQtdAcesso(Link link) {
		System.out.println("updateQtdAcesso qtdAcesso + " + link.getQtdAcesso());
		entityManager.createQuery("update Link set qtdAcesso = :qtdAcesso where alias = :alias ")
			.setParameter("alias", link.getAlias())
			.setParameter("qtdAcesso", link.getQtdAcesso())
			.executeUpdate();
		
	}

	public List<Link> getlistar() {
		return entityManager.createQuery("select l from Link l order by l.qtdAcesso desc",Link.class).getResultList();
	}

}
