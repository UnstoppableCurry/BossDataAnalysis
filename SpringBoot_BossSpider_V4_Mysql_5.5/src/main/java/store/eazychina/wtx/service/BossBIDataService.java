package store.eazychina.wtx.service;

import java.util.List;

import store.eazychina.wtx.pojo.BossBiPojo;
import store.eazychina.wtx.pojo.BossBiPojoFromAddr;
import store.eazychina.wtx.pojo.bossPojo;



public interface BossBIDataService {
	public  List<BossBiPojo> findByAddr();
	public  List<BossBiPojo> findByJobName();
	public  List<BossBiPojo> findByAddrJobName();
	public  List<BossBiPojo> findByAddrJobNameBeiJing();
	public  List<BossBiPojo> findByAddrJobNameBeiJing_deelplearning();
	
}

