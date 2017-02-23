package org.hire.me.controller;

import org.hire.me.model.Link;
import org.hire.me.service.EncurtadorLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("u")
public class AcessoController {
	
	@Autowired
	EncurtadorLinkService service;	
	
	@RequestMapping(value="/{alias}", method={RequestMethod.GET})
	public String redirect(@PathVariable String alias){
		Link link = service.recuperar(alias);
		
		String redirectUrl = link.getUrlOriginal();
		
		if (!redirectUrl.startsWith("http://") &&  !redirectUrl.startsWith("https://")){
			redirectUrl = "http://" +link.getUrlOriginal(); 
		}
		
		return "redirect:" + redirectUrl;
	}
	

}
