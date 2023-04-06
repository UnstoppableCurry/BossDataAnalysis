package store.eazychina.wtx.spider;

import javax.management.JMException;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;

public class test {
public static void main(String[] args) {
	try {
		bossSpider_V2	bossSpider=new bossSpider_V2();
		bossSpider.setCharset("utf-8");
		bossSpider_V2.setDataPath("G:\\爬虫数据\\北京算法工程师");
		bossSpider_V2.setFileName("/"+"测试3"+".txt");
		// 设置selemium浏览器配置驱动
		SeleniumDownloader seleniumDownloader = new SeleniumDownloader(
				"G:\\爬虫\\drive\\chromedriver.exe");
		seleniumDownloader.setSleepTime(70000);
		// 配置当前浏览器配置
		System.setProperty("selenuim_config",
				"G:\\workspace\\Git\\webmagic\\config.ini");
		// request类型配置,使用responsebody配置请求头,调用method方法选择post/get请求
		Request request = new Request();
		// 设置被爬取页面
		String st = "https://www.zhipin.com/job_detail/?query=%E7%AE%97%E6%B3%95&city=101010100";
		// spider对象用于监控
		Spider obj = Spider.create(bossSpider).addUrl(st)
				.setDownloader(seleniumDownloader).thread(1);
		// 注册监控
		
			SpiderMonitor lister = SpiderMonitor.instance().register(obj);
			obj.start();
			obj.stop();
		} catch (JMException e) {
			e.printStackTrace();
		}
		
}
}
