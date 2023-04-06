package store.eazychina.wtx.spider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;

public class likePeople {

	public static void main(String[] args) throws Exception {
	//设置selemium浏览器配置驱动
	SeleniumDownloader seleniumDownloader=new SeleniumDownloader("G:\\爬虫\\drive\\chromedriver.exe");
	//配置当前浏览器配置
	System.setProperty("selenuim_config", "G:\\workspace\\Git\\webmagic\\config.ini");	
	//request类型配置,使用responsebody配置请求头,调用method方法选择post/get请求
	Request request=new Request();
	//设置被爬取页面
	String st="https://www.zhipin.com/";
	
	WebDriver driver = new ChromeDriver();
	Thread.sleep(500);
	driver.manage().window().maximize();
	Thread.sleep(500);
	driver.get(st);
	Thread.sleep(500);
	System.out.println("输入搜索内容");

	driver.findElement(By.name("query")).sendKeys("石家庄大数据");
	driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
	WebElement obj=driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[3]/div/div/div[1]/form/button"));
	driver.switchTo().frame(obj);
//	driver.findElement(By.cssSelector(".button")).click();
//	driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[3]/div/div/div[1]"))
//	.findElement(By.cssSelector("////*[@id=\"wrap\"]/div[3]/div/div/div[1]/form/button")).click();

	Thread.sleep(3000);

	}

}
