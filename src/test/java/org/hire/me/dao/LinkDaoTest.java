package org.hire.me.dao;

import java.util.List;

import org.hire.me.config.DataSourceConfigurationTest;
import org.hire.me.config.JPAConfiguration;
import org.hire.me.model.Link;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class,LinkDao.class,DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class LinkDaoTest {
	
	@Autowired
	LinkDao linkDao;
	
	@Test
	@Transactional
	public void deveListarDezMaisAcessadosTest() {
		List<Link> dezMaisList = linkDao.getlistarMaxDez();

		Assert.assertTrue(dezMaisList.size() < 10);
	}

}
