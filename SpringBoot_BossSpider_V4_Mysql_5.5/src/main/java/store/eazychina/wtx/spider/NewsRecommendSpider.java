package store.eazychina.wtx.spider;

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
import us.codecraft.webmagic.processor.PageProcessor;

public class NewsRecommendSpider implements PageProcessor {
	private static String dataPath;
	private static String fileName;
	private static String charset;
	private static int i = 0;  //监控爬虫循环次数

	public static String getDataPath() {
		return dataPath;
	}

	public static void setDataPath(String dataPath) {
		NewsRecommendSpider.dataPath = dataPath;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		NewsRecommendSpider.fileName = fileName;
	}

	public static String getCharset() {
		return charset;
	}

	public static void setCharset(String charset) {
		NewsRecommendSpider.charset = charset;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		NewsRecommendSpider.i = i;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
	public NewsRecommendSpider() {
		super();
	}
	
	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {

		List<String> list = page.getHtml().css("h3.t").all();
		System.out.println("开始输出");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("结束");
		
	}

	
	
	
	
	public static void main(String[] args) throws Exception {
		// 创建爬虫实体类
		NewsRecommendSpider selemium = new NewsRecommendSpider();
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
		String st = "https://www.baidu.com/s?ie=utf-8&word=";
		String str=st+"Toy Story (1995)";
		// spider对象用于监控
		Spider obj = Spider.create(selemium).addUrl(str)
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
	}
}
