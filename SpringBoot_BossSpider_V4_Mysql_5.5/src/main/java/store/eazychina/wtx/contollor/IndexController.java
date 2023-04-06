package store.eazychina.wtx.contollor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import store.eazychina.wtx.pojo.bossPojo;
import store.eazychina.wtx.service.BossDataService;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public  String indexof(String path){
		return "/jsp/index";
	}
	
	
	@RequestMapping("/home/homepage2")
	public  String homepage(String path){
		return "/jsp/home/homepage2";
	}
	
	


}
