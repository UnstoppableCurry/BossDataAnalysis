package store.eazychina.wtx.spider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.math3.analysis.function.Add;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;

public class bossSpider_V2 implements PageProcessor {
	private static String dataPath;
	private static String fileName;
	private static String charset;
	private static int i = 0;  //监控爬虫循环次数

	public static String getDataPath() {
		return dataPath;
	}

	public static void setDataPath(String dataPath) {
		bossSpider_V2.dataPath = dataPath;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		bossSpider_V2.fileName = fileName;
	}

	public static String getCharset() {
		return charset;
	}

	public static void setCharset(String charset) {
		bossSpider_V2.charset = charset;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		bossSpider_V2.i = i;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
	public bossSpider_V2() {
		super();
	}
	
	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}
	
	List<String> list;
	public void process(Page page) {
		page.addTargetRequests(page.getHtml()
				.css("[class=page]")
				.links().all());
		if (page.getResultItems().get("name") == null) {
			page.setSkip(true);
		}
		System.out.println(page.getHtml().css("[class=job-primary]"));
		
		//		List<String> list = page.getHtml().css("[class=job-primary clearfix]").all();
		IOwriteData(dataPath, fileName, charset, page.getHtml().css("[class=job-primary]").all().toString() );
//		IOwriteData("G:\\爬虫数据\\北京算法工程师", "测试1", "utf-8", list);

		page.addTargetRequests(page.getHtml()
				.xpath("/html/body/div[1]/div[3]/div/div[2]/div[3]").links()
				.all());
		i++;
	}

	
	
	
	
	public static void main(String[] args) throws Exception {
		// 创建爬虫实体类
		bossSpider_V2 selemium = new bossSpider_V2();
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
		String st = "https://www.zhipin.com/job_detail/?query=%E7%AE%97%E6%B3%95&city=101010100";
		//https://www.zhipin.com/job_detail/?query=%E7%9F%B3%E5%AE%B6%E5%BA%84javaweb&city=100010000&industry=&position=
		// spider对象用于监控
		Spider obj = Spider.create(selemium).addUrl(st)
				.setDownloader(seleniumDownloader).thread(1);
		// 注册监控
		SpiderMonitor lister = SpiderMonitor.instance().register(obj);
		obj.start();
	}

	private static void IOwriteData(String dataPath,String fileName,String charset,List<String> list){
		String str;
		FileOutputStream fos = null;
		 OutputStreamWriter writer = null;
		try {
					 fos=new FileOutputStream(dataPath+fileName, true);
					     writer = new OutputStreamWriter(fos,charset);
					for (String string : list) {
						str = string;
				   writer.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			    try {
					writer.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}	private static void IOwriteData(String dataPath,String fileName,String charset,String list){
		String str;
		FileOutputStream fos = null;
		 OutputStreamWriter writer = null;
		try {
					 fos=new FileOutputStream(dataPath+fileName, true);
					     writer = new OutputStreamWriter(fos,charset);
				   writer.append(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			    try {
					writer.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
