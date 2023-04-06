package store.eazychina.wtx.contollor;

import java.util.List;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import store.eazychina.wtx.pojo.BossBiPojo;
import store.eazychina.wtx.pojo.BossBiPojoFromAddr;
import store.eazychina.wtx.service.BossBIDataService;

@Controller
public class BossAnalysisControllor {
	@Autowired(required = false)
	BossBIDataService boss;
	//柱状图
	
	@RequestMapping("/getdatabyaddr")
	public String bossFindByAddrListData(Model model) {
		List<BossBiPojo> list =boss.findByAddr();
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (BossBiPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getAvgred());
				arr2.add(bossBiPojo.getAddr());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/addr_money";
	}
	
	//北京/岗位-工资分析
	@RequestMapping("/getmoneyforjobnamebybeijing")
	public String getmoneyforjobnamebyaddr(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobNameBeiJing();
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (BossBiPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getAvgred());
				arr2.add(bossBiPojo.getJobName()+"\n" +" 技术栈:  "+bossBiPojo.getjobTageItem());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/getmoneyforjobnamebybeijing";
	}
	//北京/算法岗位-工资分析
	@RequestMapping("/findByAddrJobNameBeiJing_deelplearning")
	public String suanfagang(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobNameBeiJing_deelplearning();
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (BossBiPojo bossBiPojo : list) {
				System.out.println(bossBiPojo);
				arr.add(bossBiPojo.getAvgred());
				arr2.add("工作名称: "+bossBiPojo.getJobName()+"\n" +" 技术栈:  "+bossBiPojo.getjobTageItem()+"\n"+"薪资范围: "+bossBiPojo.getMinred()+"k-"+bossBiPojo.getMaxred()+"k    地址:  "+bossBiPojo.getAddr());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/getmoneyforjobnamebybeijing_deeplearning";
	}
	//北京/岗位-工资分析
	@RequestMapping("/getmoneyforjobnamebyshijiazhuang")
	public String getmoneyforjobnamebyshijiazhuang(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobName();
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (BossBiPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getAvgred());
				arr2.add(bossBiPojo.getJobName()+"\n" +" 技术栈:  "+bossBiPojo.getjobTageItem());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/getmoneyforjobnamebyshijiazhuang";
	}
	//供需分析
	@RequestMapping("/getdatabyjobname")
	public String bossFindByJobNameListData(Model model) {
		List<BossBiPojo> list =boss.findByJobName();
		JSONArray arr=new JSONArray();
		for (BossBiPojo bossBiPojo : list) {
			System.out.println(bossBiPojo);
			JSONObject jo=new JSONObject();
			jo.put("name", bossBiPojo.getJobName()+" "+bossBiPojo.getAvgred()+"k");
			jo.put("value",bossBiPojo.getRank());

			arr.add(jo);
		}
		model.addAttribute("data",arr);

		return "/BI/China_jobName_money";
	}
	
	@RequestMapping("/getdatabyaddrjobname")
	public String bossFindByAddrJobNameListData(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobName();
		JSONArray arr=new JSONArray();
		for (BossBiPojo bossBiPojo : list) {
			
			System.out.println(bossBiPojo);
			JSONObject jo=new JSONObject();
			jo.put("name", bossBiPojo.getJobName()+" "+bossBiPojo.getAvgred()+"k");
			jo.put("value",bossBiPojo.getRank());

			arr.add(jo);
		}
		model.addAttribute("data",arr);
		return "/BI/shijiazhang_addr_jobName_money";
	}
	
	
	@RequestMapping("/findByAddrJobNameBeiJing")
	public String findByAddrJobNameBeiJing(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobNameBeiJing();
		JSONArray arr=new JSONArray();
		for (BossBiPojo bossBiPojo : list) {
			
			System.out.println(bossBiPojo);
			JSONObject jo=new JSONObject();
			jo.put("name", bossBiPojo.getJobName()+" "+bossBiPojo.getAvgred()+"k");
			jo.put("value",bossBiPojo.getRank());
			arr.add(jo);
		}
		model.addAttribute("data",arr);
		return "/BI/BeiJing_addr_jobName_money";
	}
	
	@RequestMapping("/asd")
	public String asd(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobNameBeiJing();
		JSONArray arr=new JSONArray();
			JSONObject jo=new JSONObject();
			jo.put("name","asdsa");
			jo.put("value",123);
			arr.add(jo);
			System.out.println(arr);
//		model.addAttribute("data",arr);
		return "/BI/addr_money2";
	}
	
	@RequestMapping("/asd1")
	public String asd1(Model model) {
		List<BossBiPojo> list =boss.findByAddrJobNameBeiJing();
		JSONArray arr=new JSONArray();
			JSONObject jo=new JSONObject();
			jo.put("name","asdsa");
			jo.put("value",123);
			arr.add(jo);
			System.out.println(arr);
//		model.addAttribute("data",arr);
		return "/BI/addr_money3";
	}
	
	
	
	
}
