package org.hire.me.controller;

import org.hire.me.exception.EncurtadorLinkException;
import org.hire.me.model.Link;
import org.hire.me.service.EncurtadorLinkService;
import org.hire.me.vo.LinkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("encurtar")
public class EncurtarLinkController {
	
	@Autowired
	EncurtadorLinkService service;

	
	@RequestMapping(value="criar/{url}/{customAlias}", method={RequestMethod.PUT,RequestMethod.POST})
	@ResponseBody
	public LinkVo criar(@PathVariable String url, @PathVariable(required=false) String customAlias){
		try {
			
			Link link = service.criar(url,customAlias);
			
		} catch (EncurtadorLinkException e) {
//			return new Error("");
		} catch (Exception e) {

		}

		
		return new LinkVo("goolgle.ico/u/adsfads","goolgle.com/flamengo",200l);
	}
	
	@RequestMapping(value="recuperar/{alias}", method={RequestMethod.GET})
	@ResponseBody
	public LinkVo recuperar(@PathVariable String alias){
		
		//ERR_CODE: 002, Description:SHORTENED URL NOT FOUND
		
		Link link = service.recuperar(alias);
		
		return new LinkVo("goolgle.ico/u/adsfads","goolgle.com/flamengo",100l);
		
	}

}
