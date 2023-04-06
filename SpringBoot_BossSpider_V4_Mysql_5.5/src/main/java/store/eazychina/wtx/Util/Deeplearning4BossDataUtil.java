package store.eazychina.wtx.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import store.eazychina.wtx.pojo.bossPojo;


/**
 * 要实现的功能: 输入: 数据路径 输出: 结构化数据
 * 
 * 1.递归读取获得每个文件的路径 2.IO流读取文件,数据为字符串 3.log4j解析数据 4.将解析的数据结构化:创建实体类,使用对象保存
 * 5.结构化数据持久化
 * 
 * @author 86183
 *
 */
 public class Deeplearning4BossDataUtil {
	/**
	 * 边缘校验
	 */
	private static void checkFilePath(String path) {
		if (path.trim().length() == 0 || path == null) {
			throw new IllegalArgumentException("路径不合法");
		}
	}

	/**
	 * 1.递归读取获得每个文件的路径
	 * 
	 * @throws FileNotFoundException
	 */
	private static void getFiles(String path, List<String> list) {
		checkFilePath(path);
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					getFiles(files[i].getPath(), list);
				} else {
					list.add(files[i].getPath());
				}
			}
		} else {
			list.add(file.getPath());
		}
	}

	/**
	 * 2.IO流读取文件,数据为字符串
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static List<String> readFileFromFilePath(List<String> list)
			throws IOException {
		FileInputStream fil;
		BufferedReader bfr = null;
		StringBuffer sbf = new StringBuffer();
		List<String> stringData = new ArrayList<String>();
		for (String string : list) {
			checkFilePath(string);
			File file = new File(string);
			try {
				bfr = new BufferedReader(new java.io.FileReader(file));
				String tempStr;
				while ((tempStr = bfr.readLine()) != null) {
					sbf.append(tempStr + "\n");
				}
				bfr.close();
				stringData.add(sbf.toString());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return stringData;
	}

	/**
	 * 切分每个组数据放入list中
	 * 
	 * @param XMLdata
	 * @return
	 * 
	 */
	private static List<String> splitXMLData(List<String> XMLdata) {
		List<String> splitData = new ArrayList<String>();
		for (String string : XMLdata) {
			String[] arr = string.split("<div class=\"job-primary\">");
			for (String string2 : arr) {
				String[] a = string2.split("<\\s*img\\s+([^>]*)\\s*>");
				String finaldata = "";
				for (int i = 0; i < a.length; i++) {
					finaldata += a[i].toString();
				}
				splitData.add(finaldata);
			}
		}

		return splitData;
	}

	/**
	 * 3.log4j解析数据 4.将解析的数据结构化:创建实体类,使用对象保存
	 * 
	 * @param data
	 * @return
	 */
	private static HashSet<String> parsingStringDataForLog4j(
			List<String> splitData) {
		Document doc = null;
		final String startStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> <root><div>";
		final String endStr = "</root>";
		int i = 0;
		HashSet<String> finalData = new HashSet<String>();
		for (String string : splitData) {
			String dataStr = "";
			System.out.println("循环了" + i + "次");
			i++;
			String aaa = startStr + string + endStr;
			try {
				doc = DocumentHelper.parseText(aaa);
				Element rootElt = doc.getRootElement(); // 获取根节点
				/**
				 * 招聘岗位相关要求字段
				 */
				List<Element> jobTagItem = rootElt
						.selectNodes("//span[@class='tag-item']");
				String jobTagItemStr = "";
				for (Element element : jobTagItem) {
					jobTagItemStr += element.getText() + ",";
				}
				/**
				 * 招聘岗位名称
				 */
				Element jobNameFatherNode = (Element) rootElt
						.selectSingleNode("//span[@class='job-name']");
				Element jobName = (Element) jobNameFatherNode
						.selectSingleNode("//a");
				String jobNameStr = jobName.getText();
				/**
				 * 招聘地点
				 */
				Element jobAreaWrapper = (Element) rootElt
						.selectSingleNode("//span[@class='job-area']");
				String jobAreaWrapperStr = jobAreaWrapper.getText();
				/**
				 * job-limit clearfix 工资薪酬
				 */
				Element red = (Element) rootElt
						.selectSingleNode("//span[@class='red']");
				String redStr = red.getText();
				/**
				 * 学历要求
				 */
				Element vline = (Element) rootElt.selectSingleNode("//p");
				String vlineStr = vline.getText();
				/**
				 * HR
				 */
				Element hrName = (Element) rootElt
						.selectSingleNode("//div[@class='info-publis']");
				Element hrMessage = (Element) rootElt
						.selectSingleNode("//h3[@class='name']");
				String hrMessageStr = hrMessage.getText();
				/**
				 * 公司名称
				 */
				List<Element> companyName = rootElt.selectNodes("//a");
				String companyNameStr = companyName.get(1).getText();
				dataStr = companyNameStr + "\001" + hrMessageStr + "\001"
						+ vlineStr + "\001" + redStr + "\001"
						+ jobAreaWrapperStr + "\001" + jobNameStr + "\001"
						+ jobTagItemStr;
				finalData.add(dataStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return finalData;
	}

	/**
	 * 5.结构化数据,并且持久化
	 * 
	 * @param finalData
	 * @return 
	 */
	private static List<bossPojo> getPojoList(HashSet<String> finalData) {
		List<bossPojo> list = new ArrayList<bossPojo>();
		for (String string : finalData) {
			String[] pojoData = string.split("\001");
			//"260元/天"去掉实习
			if (pojoData[3].indexOf("元/天")!=-1) {
				bossPojo boss = new bossPojo(pojoData[0], pojoData[1], pojoData[2],
						0, 0, pojoData[4], pojoData[5], pojoData[6],pojoData[3]);
				list.add(boss);
			}else {
				String[] reds = pojoData[3].split("-");
				int min = Integer.parseInt(reds[0]);
				int max = Integer.parseInt(reds[1].split("K")[0]);
				bossPojo boss = new bossPojo(pojoData[0], pojoData[1], pojoData[2],
						min, max, pojoData[4], pojoData[5], pojoData[6]);
				list.add(boss);	
			}
		}
		return list;
	}

	/**
	 * 对外提供的managerAPI
	 * @return
	 * @throws Exception
	 */
	public static List<bossPojo> startMakeDataForBossSpider(String dataPath) throws Exception{

		List<String> list = new ArrayList<String>();
		getFiles(dataPath, list);
		// 获取到文件路径
		List<String> strData = readFileFromFilePath(list);
		System.out.println(strData.size());// 8
		// for (String str : strData) {
		// System.out.println(str);
		// }
		List<String> splitData = splitXMLData(strData);
		HashSet<String> finalData = parsingStringDataForLog4j(splitData);
		System.out.println("去重后剩余岗位数量:" + finalData.size());
		// 循环了9731次 去重后 剩余1346个岗位
		List<bossPojo> pojoCollections=getPojoList(finalData);
		for (bossPojo bossPojo : pojoCollections) {
			System.out.println(bossPojo);
		}
		return pojoCollections;
	
	}
}
