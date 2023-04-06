package store.eazychina.wtx.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class BT_Spider implements PageProcessor{

	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}
	public void process(Page page) {
		page.putField("author", page.getUrl().toString());
		if (page.getResultItems().get("name") == null) {
		    //判定条件,如果这个条件成立就跳过此页
			page.setSkip(true);
		}
		page.putField("readme", page.getHtml().getDocument().getElementsByClass("theme_list_con"));
//		System.out.println(page.getHtml().getDocument().getElementsByClass("theme_list_con"));
		// 部分三：从页面发现后续的url地址来抓取
		//翻页,css选择翻页,就会一直循环
		page.addTargetRequests(page.getHtml().css("div.pg").links().all());
		}	
}
