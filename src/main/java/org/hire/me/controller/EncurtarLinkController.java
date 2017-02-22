package org.hire.me.controller;

import java.util.List;

import org.hire.me.exception.EncurtadorLinkException;
import org.hire.me.model.Link;
import org.hire.me.service.EncurtadorLinkService;
import org.hire.me.util.DataUtil;
import org.hire.me.vo.BaseVo;
import org.hire.me.vo.ErrorVo;
import org.hire.me.vo.LinkVo;
import org.hire.me.vo.RequestLinkVo;
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
	
	@RequestMapping(value="criar2", method={RequestMethod.PUT,RequestMethod.POST})
	@ResponseBody
	public ErrorVo criar2(RequestLinkVo obj){
		
		System.out.println("bagteu");
		
		System.out.println(obj);
		
		return new ErrorVo("test", "", obj.toString());
	}

	
	@RequestMapping(value="criar/{url}/{customAlias}", method={RequestMethod.PUT,RequestMethod.POST})
	@ResponseBody
	public BaseVo criar(@PathVariable String url, @PathVariable(required=false) String customAlias){
		try {
			
			System.out.println("criar / " + url + " | " +customAlias);
			
			long inicioTimeInMillis = DataUtil.getAgoraInMillis();
			
			Link link = service.criar(url,customAlias);
			
			long fimTimeInMillis = DataUtil.getAgoraInMillis();
			
			System.out.println("tempo a " + inicioTimeInMillis + " / " 
			+ fimTimeInMillis + "  = " 
					+( fimTimeInMillis - inicioTimeInMillis));
			
			return LinkVo.parse(link, ( fimTimeInMillis - inicioTimeInMillis));
			
		} catch (EncurtadorLinkException e) {
			e.printStackTrace();
			return ErrorVo.parse(customAlias, e.getCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ErrorVo.parse(customAlias, "999", e.getMessage());
		}
		
	}
	
	@RequestMapping(value="recuperar/{alias}", method={RequestMethod.GET})
	@ResponseBody
	public BaseVo recuperar(@PathVariable String alias){
		long inicioTimeInMillis = DataUtil.getAgoraInMillis();
		System.out.println("recuperar / " + alias);
		
		try {
			Link link = service.recuperar(alias);
			
			long fimTimeInMillis = DataUtil.getAgoraInMillis();
			
			return LinkVo.parseUrlOriginal(link, ( fimTimeInMillis - inicioTimeInMillis));
			
		} catch (EncurtadorLinkException e) {
			e.printStackTrace();
			return ErrorVo.parse(alias, e.getCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ErrorVo.parse(alias, "999", e.getMessage());
		}
	}
	
	@RequestMapping(value="listar", method={RequestMethod.GET})
	@ResponseBody
	public List<Link> listar(){
		System.out.println("listar / " );
		
		List<Link> links = service.listar();
		
		return links;
	}	

}
