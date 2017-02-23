package org.hire.me.service;

import org.hire.me.config.DataSourceConfigurationTest;
import org.hire.me.config.JPAConfiguration;
import org.hire.me.dao.LinkDao;
import org.hire.me.model.Link;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class,LinkDao.class,DataSourceConfigurationTest.class,EncurtadorLinkService.class})
@ActiveProfiles("test")
public class EncurtadorLinkServiceTest {
	
	@Autowired
	EncurtadorLinkService encurtadorLinkService;
	
	private String url;
	
	private String alias;
	
	@Before
	public void setup(){
		this.url = "http://www.bemobi.com.br";
		this.alias = "bemobi";
	}
	
	@Test
	@Transactional
	public void deveCriarERecuperarComAliasTest() {
		
		Link linkCriado = encurtadorLinkService.criar( this.url, this.alias);
		
		Link linkRecuperado = encurtadorLinkService.recuperar(this.alias);

		Assert.assertTrue(linkCriado != null);
		Assert.assertTrue(linkRecuperado != null);
		
		Assert.assertTrue(linkCriado.getUrlFinal().endsWith(this.alias));
	}
	
	@Test
	@Transactional
	public void deveCriarERecuperarSemAliasTest() {
		
		Link linkCriado = encurtadorLinkService.criar( this.url , null);
		
		Link linkRecuperado = encurtadorLinkService.recuperar(linkCriado.getAlias());

		Assert.assertTrue(linkCriado != null);
		Assert.assertTrue(linkRecuperado != null);
		
		Assert.assertTrue(linkRecuperado.getUrlFinal().endsWith(linkCriado.getAlias()));
	}	

}
