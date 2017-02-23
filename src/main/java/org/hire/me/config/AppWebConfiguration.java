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
	
//	@Bean
//	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager){
//	    List<ViewResolver> viewResolvers = new ArrayList<>();
//	    viewResolvers.add(new JsonViewResolver());
//
//	    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//	    resolver.setViewResolvers(viewResolvers);
//	    resolver.setContentNegotiationManager(manager);
//	    return resolver;
//	}	
	
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
//		mappingJackson2HttpMessageConverter.setPrettyPrint(true);
//		return mappingJackson2HttpMessageConverter;
//	}
//
//	@Bean
//	public ObjectMapper objectMapper() {
//		ObjectMapper objMapper = new ObjectMapper();
//		objMapper.enable(SerializationFeature.INDENT_OUTPUT);
//		return objMapper;
//	}

}
