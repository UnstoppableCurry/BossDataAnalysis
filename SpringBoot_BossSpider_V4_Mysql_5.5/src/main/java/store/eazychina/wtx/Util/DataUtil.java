package store.eazychina.wtx.Util;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
public List<String> getIOData4RealTimeDate2RedisKey(String year,String month,String day){
	if (year.trim().length()<4) {
		return null;
	}else if (month.trim().length()<1) {
		return null;
	}else if(day.trim().length()<1) {
		return null;
	}
	//边界检查完成后,进行规则填充,这里省去正则校验,太麻烦没必要
	if (month.length()==1) {
		month=0+month;
	}
	if (day.length()==1) {
		day=0+day;
	}
	String finalstr;
	String fist_key=year.trim()+month.trim()+day.trim();
	List<String> list=new ArrayList<String>();
	//小时-xx两个字段一共24个小时  0-23
	String hour;
	String minuts;
	for (int i = 0; i < 24; i++) {
		String str=i+"";
		if (str.trim().length()<2) {
			str=0+str;
		}
		
		for (int j = 0; j < 12; j++) {
			String seconds=5*j+"";
			finalstr=fist_key+str+seconds.trim();
			list.add(finalstr);
		}
	}
	//分钟-x,xx一个或者两个字段,从0-60 对5求余为0的整数
	return list;
}
public static void main(String[] args) {
	DataUtil dataUtil=new DataUtil();
	List<String> list=dataUtil.getIOData4RealTimeDate2RedisKey("2012", "1", "2");
	for (String string : list) {
		System.out.println(string);
	}
}
}
