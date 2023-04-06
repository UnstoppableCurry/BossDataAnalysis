package store.eazychina.wtx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import store.eazychina.wtx.mapper.BossSpiderMapper;
import store.eazychina.wtx.pojo.bossPojo;
import store.eazychina.wtx.service.BossDataService;


//@Component
@Service
public class BossDataServiceImpl implements BossDataService{
	@Autowired(required=false)
	BossSpiderMapper boss;
	
	public void addBossData(List<bossPojo> bossdata) {
		int i=0;
		for (bossPojo bossPojo : bossdata) {
			System.out.println("数据库插入数据第"+i+"次");
			boss.bossAddData(bossPojo);
			i++;
		}
	}

	public List<bossPojo> findAll() {
		return boss.findAll();
	}

	public List<bossPojo> PathLike(String value) {
		return boss.PathLike(value);	}

	public List<bossPojo> jobName(String value) {
		return boss.jobName(value);	}

	public List<bossPojo> companyName(String value) {
		return boss.companyName(value);	}


	public List<bossPojo> jobTagItem(String value) {
		return boss.jobTagItem(value);	}

	public List<bossPojo> moneyLike(Integer value) {
		return boss.moneyLike(value);
	}

	public List<bossPojo> alldata(bossPojo obj) {
		return boss.alldata(obj);
	}

}
