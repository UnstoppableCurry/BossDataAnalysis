package store.eazychina.wtx.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.eazychina.wtx.pojo.BossBiPojo;
import store.eazychina.wtx.pojo.BossBiPojoFromAddr;
import store.eazychina.wtx.pojo.bossPojo;

@Mapper
public interface BossBISpiderMapper {
	public  List<BossBiPojo> findByAddr();
	public  List<BossBiPojo> findByJobName();
	public  List<BossBiPojo> findByAddrJobName();
	public  List<BossBiPojo> findByAddrJobNameBeiJing();
	public  List<BossBiPojo> findByAddrJobNameBeiJing_deelplearning();
}
