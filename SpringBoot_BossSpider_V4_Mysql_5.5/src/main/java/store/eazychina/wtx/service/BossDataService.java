package store.eazychina.wtx.service;

import java.util.List;

import store.eazychina.wtx.pojo.bossPojo;



public interface BossDataService {
	
	public void addBossData(List<bossPojo> boss);
	public List<bossPojo> findAll();
	public List<bossPojo> PathLike(String value);
	public List<bossPojo> jobName(String value);
	public List<bossPojo> companyName(String value);
	public List<bossPojo> jobTagItem(String value);
	public List<bossPojo> moneyLike(Integer value);
	public List<bossPojo> alldata(bossPojo obj);

}

