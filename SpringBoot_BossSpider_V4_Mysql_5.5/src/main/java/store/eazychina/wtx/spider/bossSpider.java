package store.eazychina.wtx.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class bossSpider implements PageProcessor {
	static int i = 0;

	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		if (page.getResultItems().get("name") == null) {
			page.setSkip(true);
			page.addTargetRequests(page.getHtml()
					.xpath("/html/body/div[1]/div[3]/div/div[2]/div[3]")
					.links().all());
		}

		List<String> list = page.getHtml().css("[class=job-primary]").all();
		String jsonStr2;
		FileOutputStream fos = null;
		 OutputStreamWriter writer = null;
		try {
					 fos=new FileOutputStream("G://boss爬虫数据A.txt", true);
					     writer = new OutputStreamWriter(fos, "UTF-8");
					for (String string : list) {
				jsonStr2 = string;
				   writer.append(jsonStr2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// System.out.println(page.getHtml().css("[class=job-primary]"));
		// System.out.println(page.getHtml().getDocument().getElementsByClass("job-title"));
		// System.out.println(page.getHtml().$(".job-title"));
		// 翻页,css选择翻页,就会一直循环
		page.addTargetRequests(page.getHtml()
				.xpath("/html/body/div[1]/div[3]/div/div[2]/div[3]").links()
				.all());
		i++;
	}

	public static void main(String[] args) throws Exception {
		// 创建爬虫实体类
		bossSpider selemium = new bossSpider();
		// 设置selemium浏览器配置驱动
		SeleniumDownloader seleniumDownloader = new SeleniumDownloader(
				"G:\\爬虫\\drive\\chromedriver.exe");
		seleniumDownloader.setSleepTime(5000);
		// 配置当前浏览器配置
		System.setProperty("selenuim_config",
				"G:\\workspace\\Git\\webmagic\\config.ini");
		// request类型配置,使用responsebody配置请求头,调用method方法选择post/get请求
		Request request = new Request();
		// 设置被爬取页面
		String st = "https://www.zhipin.com/job_detail/?query=%E7%9F%B3%E5%AE%B6%E5%BA%84%E5%A4%A7%E6%95%B0%E6%8D%AE&city=100010000&industry=&position=";
		// spider对象用于监控
		Spider obj = Spider.create(selemium).addUrl(st)
				.setDownloader(seleniumDownloader).thread(1);
		// 注册监控
		SpiderMonitor lister = SpiderMonitor.instance().register(obj);
		obj.start();
	}

}
