package org.hire.me.config;

import org.hire.me.controller.EncurtarLinkController;
import org.hire.me.dao.LinkDao;
import org.hire.me.service.EncurtadorLinkService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan(basePackageClasses={EncurtarLinkController.class,
		EncurtadorLinkService.class,
		LinkDao.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("/**");
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}	

}
