package org.hire.me.service;

import java.util.Random;

import org.hire.me.dao.LinkDao;
import org.hire.me.exception.EncurtadorLinkException;
import org.hire.me.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EncurtadorLinkService {
	
	@Autowired
	private LinkDao linkDao;
	
	
	private static final String BASE_URL_SHORT = "http://alanstos.heroku.com.br";
	//XYhakR

	public static void main(String[] args) {
		
		EncurtadorLinkService s = new EncurtadorLinkService();
		
		System.out.println(s.geraLinkCurto("qualquer_coisa"));
		System.out.println(s.geraLinkCurto());
		
		System.out.println(s.gerarString());
		
		s.gera();
		s.gera();
		s.gera();
		s.gera();

	}
	
	public String geraLinkCurto(){
		
		return geraLinkCurto(null);
		
	}

	
	public String geraLinkCurto(String customAlias){
		
		String custom = "";
		
		if (!isEmpty(customAlias)){
			//TODO busca no banco se existe
			
			custom = customAlias;
		}else{
			custom = gerarString();
		}
		
		return BASE_URL_SHORT + "/u/"+custom;
		
	}
	
	public String gerarString(){
		return gerarString(7,"ABCDEFGHIJKLMNPQRSTUVXZWYabcdefghijklmnopqrstuvxzwy");
	}	
	
	public String gerarString(int tamanho, String letras) {
		Random random = new Random();
		StringBuilder saida = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			saida.append(letras.charAt(random.nextInt(letras.length())));
		}
		return saida.toString();
	}
	
	public void gera(){
		Random random = new Random();
		System.out.println(random.nextInt(10));
	}
	
	public boolean isEmpty(String valor){
		return valor == null || valor.isEmpty();
	}

	public Link criar(String url, String customAlias) {
		
		if (!isEmpty(customAlias)){
			
			//veficaSeJaExiste
			
			Link linkByAlias = linkDao.findByAlias(customAlias);
			
			if (linkByAlias != null)
				throw new EncurtadorLinkException("001","CUSTOM ALIAS ALREADY EXISTS");			
			
		}
		
		
		String alias = isEmpty(customAlias) ? gerarString() : customAlias; 
		
		Link link = new Link();
		link.setAlias(alias);
		link.setUrlOriginal(url);
		link.setUrlFinal( geraLinkCurto(alias) );
		link.setQtdAcesso(0);
		
		linkDao.salvar(link);
		
		return link;
	}

	public Link recuperar(String alias) {
		
		Link linkByAlias = linkDao.findByAlias(alias);
		
		if (linkByAlias != null)
			throw new EncurtadorLinkException("002","Description:SHORTENED URL NOT FOUND");		
		
		return null;
	}
	

}
