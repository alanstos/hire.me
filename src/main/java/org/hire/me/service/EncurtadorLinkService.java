package org.hire.me.service;

import java.util.List;
import java.util.Random;

import org.hire.me.dao.LinkDao;
import org.hire.me.exception.EncurtadorLinkException;
import org.hire.me.model.Link;
import org.hire.me.util.EncurtadorLinkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EncurtadorLinkService {
	
	@Autowired
	private LinkDao linkDao;
	
	


	public Link criar(String url, String customAlias) {
		
		verificaSeJaExisteAlias(customAlias);
		
		String alias = getAlias(customAlias);
		
		String shortUrl = EncurtadorLinkUtil.generateShortUrl(alias);
		
		Link link = new Link(alias,shortUrl,url);
		
		linkDao.salvar(link);
		
		return link;
	}

	
	public Link recuperar(String alias) {
		
		Link linkByAlias = linkDao.findByAlias(alias);
		
		if (linkByAlias == null)
			throw new EncurtadorLinkException("002","Description:SHORTENED URL NOT FOUND");	
		
		somaUmAcessoAoLink(linkByAlias);
		
		return linkByAlias;
	}	
	
	private void somaUmAcessoAoLink(Link link){
		Integer numAcesso = link.getQtdAcesso();
		
		link.setQtdAcesso( ++numAcesso );
		
		linkDao.updateQtdAcesso(link);
	}
	

	private String getAlias(String customAlias) {
		return EncurtadorLinkUtil.isEmpty(customAlias) ? EncurtadorLinkUtil.generateKey() : customAlias;
	}	

	private void verificaSeJaExisteAlias(String customAlias) {
		if (!EncurtadorLinkUtil.isEmpty(customAlias)){
			
			Link linkByAlias = linkDao.findByAlias(customAlias);
			
			if (linkByAlias != null)
				throw new EncurtadorLinkException("001","CUSTOM ALIAS ALREADY EXISTS");			
			
		}
	}


	public List<Link> listar() {
		return linkDao.getlistar();
	}


	

}
