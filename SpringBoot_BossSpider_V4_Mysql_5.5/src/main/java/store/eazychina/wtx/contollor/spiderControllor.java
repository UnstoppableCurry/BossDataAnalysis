package store.eazychina.wtx.contollor;

import java.util.List;

import javax.management.JMException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import store.eazychina.wtx.Util.BossDataUtil;
import store.eazychina.wtx.pojo.bossPojo;
import store.eazychina.wtx.service.BossDataService;
import store.eazychina.wtx.spider.bossSpider_V2;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;

@Controller
public class spiderControllor {
	@Autowired(required = false)
	BossDataService boss;
	
	
	
	@ResponseBody
	@RequestMapping("/addBossData")
	public String addBossSpiderDataFromSpringBoot(String path) {
		List<bossPojo> list = null;
		System.out.println(path);
		try {
			list = BossDataUtil.startMakeDataForBossSpider(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boss.addBossData(list);
		return "导入成功";
	}

	@RequestMapping("/spider/controller")
	public String spiderControllerPage() {
		System.out.println("爬虫");
		return "/jsp/spider";
	}

	@RequestMapping("getBossList")
	public String getBossList(Model model) {
		model.addAttribute("users", boss.findAll());
		return "/jsp/user/user/list" ;
	}

	@RequestMapping("PathLike")
	public String getBossList(Model model, String value) {
		System.out.println(value);
		model.addAttribute("users", boss.PathLike(value));
		return "/jsp/user/user/list" ;
	}


	@RequestMapping("companyName")
	public String companyName(Model model, String value) {
		System.out.println(value);
		model.addAttribute("users", boss.companyName(value));
		return "/jsp/user/user/list" ;
	}

	@RequestMapping("jobName")
	public String jobName(Model model, String value) {
		System.out.println(value);
		model.addAttribute("users", boss.jobName(value));
		return "/jsp/user/user/list" ;

	}

	@RequestMapping("jobTagItem")
	public String jobTagItem(Model model, String value) {
		System.out.println(value);
		model.addAttribute("users", boss.jobTagItem(value));
		return "/jsp/user/user/list" ;

	}
	@RequestMapping("alldata")
	public String alldata(Model model, String jobTagItem, String companyName, String jobName, String jobAreaWrapper) {
		System.out.println(jobTagItem+companyName+jobName+jobAreaWrapper);
		bossPojo obj=new bossPojo();
		obj.setCompanyName(companyName);
		obj.setJobAreaWrapper(jobAreaWrapper);
		obj.setJobTagItem(jobTagItem);
		obj.setJobName(jobName);
		model.addAttribute("users", boss.alldata(obj));
		return "/jsp/user/user/list" ;

	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/bossSpiderStart")
	public static String startBtSpider(String FileName,String path){
				
		try {
				bossSpider_V2	bossSpider=new bossSpider_V2();
				bossSpider.setCharset("utf-8");
				bossSpider_V2.setDataPath(path);
				bossSpider_V2.setFileName("/"+FileName+".txt");
				// 设置selemium浏览器配置驱动
				SeleniumDownloader seleniumDownloader = new SeleniumDownloader(
						"G:\\爬虫\\drive\\chromedriver.exe");
				seleniumDownloader.setSleepTime(20000);
				// 配置当前浏览器配置
				System.setProperty("selenuim_config",
						"G:\\workspace\\Git\\webmagic\\config.ini");
				// request类型配置,使用responsebody配置请求头,调用method方法选择post/get请求
				Request request = new Request();
				// 设置被爬取页面
				String st = "https://www.zhipin.com/job_detail/?query=%E6%8E%A8%E8%8D%90%E7%AE%97%E6%B3%95&city=100010000&industry=&position=";
				// spider对象用于监控
				Spider obj = Spider.create(bossSpider).addUrl(st)
						.setDownloader(seleniumDownloader).thread(1);
				// 注册监控
				
					SpiderMonitor lister = SpiderMonitor.instance().register(obj);
					obj.start();
				} catch (JMException e) {
					e.printStackTrace();
				}
				
		return "爬虫启动";
	}
	
	
	
	/**
	 * 阿里云参数
	 * /root/spiderdata  数据地址
	 * /usr/bin/chromedriver 驱动地址
	 * /root/spider/selenium selenium地址
	 * /root/spider/springjar/springboot_spider_v1/config.ini
	 * @return
	 * 操作网址
	 * http://47.242.82.87:8089/WebMagic_SpringBoot/bsstart
	 */
		@ResponseBody
		@RequestMapping("/bsstart")
		public static String startBoosSpider(){
					
			try {
					bossSpider_V2	bossSpider=new bossSpider_V2();
					bossSpider.setCharset("utf-8");
					bossSpider_V2.setDataPath("/root/spiderdata");
					bossSpider_V2.setFileName("/springboost测试数据.txt");
					// 设置selemium浏览器配置驱动
					SeleniumDownloader seleniumDownloader = new SeleniumDownloader(
							"/usr/bin/chromedriver");
					seleniumDownloader.setSleepTime(5000);
					// 配置当前浏览器配置
					System.setProperty("selenuim_config",
							"/root/spider/springjar/springboot_spider_v1/config.ini");
					// request类型配置,使用responsebody配置请求头,调用method方法选择post/get请求
					Request request = new Request();
					// 设置被爬取页面
					String st = "https://www.zhipin.com/job_detail/?query=%E7%9F%B3%E5%AE%B6%E5%BA%84javaweb&city=100010000&industry=&position=";
					// spider对象用于监控
					Spider obj = Spider.create(bossSpider).addUrl(st)
							.setDownloader(seleniumDownloader).thread(1);
					// 注册监控
					
						SpiderMonitor lister = SpiderMonitor.instance().register(obj);
						obj.start();
					} catch (JMException e) {
						e.printStackTrace();
					}
					
			return "爬虫启动";
		}

}
