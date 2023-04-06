package store.eazychina.wtx.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.eazychina.wtx.pojo.bossPojo;

@Mapper
public interface BossSpiderMapper {
	public  void bossAddData(bossPojo list);
	public List<bossPojo> findAll();
	public List<bossPojo> PathLike(String value);
	public List<bossPojo> jobName(String value);
	public List<bossPojo> companyName(String value);
	public List<bossPojo> jobTagItem(String value);
	public List<bossPojo> moneyLike(Integer value);
	public List<bossPojo> alldata(bossPojo obj);

}
